package springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.stereotype.Service;
import springboot.dto.LogNoteDTO;
import springboot.entity.User;
import springboot.exception.NoUserException;
import springboot.exception.NotUniqueException;
import springboot.exception.WrongPasswordException;
import springboot.repository.UserRepository;


import java.sql.SQLException;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public List<User> findAll() {
        return repository.findAll();
    }

    public void saveNewUser(User user) {

        try {
            repository.save(user);
        } catch (Exception ex) {
            Throwable specificException = NestedExceptionUtils.getMostSpecificCause(ex);

            int errorCode = 0;

            if (specificException instanceof SQLException) {
                SQLException sqlException = (SQLException) specificException;
                errorCode = sqlException.getErrorCode();
            }

            if (errorCode == 1062) {
                log.warn("Login already exists");
                throw new NotUniqueException("Entered login is already used, please try another", user.getLogin());
            }

            throw ex;
        }

    }

    public User getUser (LogNoteDTO logFormDTO){
        log.info("Get user: " + logFormDTO.toString());

        User user = repository.findByLogin(logFormDTO.getLogin());

        if (user == null) {
            throw new NoUserException("There are no user with that login", logFormDTO.getLogin());
        }

        if (!(logFormDTO.getPassword().equals(user.getPassword()))) {
            throw new WrongPasswordException("Wrong password", logFormDTO.getLogin());
        }

        log.info("Returning user: " + user.toString());
        return user;
    }
}
