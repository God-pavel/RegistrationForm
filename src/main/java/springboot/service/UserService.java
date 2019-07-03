package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.entity.User;
import springboot.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("Pasha","Pankratov","ex@gmail.com","God-pavel","qwerty"));
    }

    @PostConstruct
    public void init(){
        repository.saveAll(users);
    }

    public List<User> findAll(){
        return repository.findAll();
    }
}
