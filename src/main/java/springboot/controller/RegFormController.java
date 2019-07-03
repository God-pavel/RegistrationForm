package springboot.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.dto.RegNoteDTO;
import springboot.entity.User;
import springboot.service.UserService;


@Slf4j
@RestController
@RequestMapping(value = "/api/registration")
public class RegFormController {
    private final UserService userService;

    @Autowired
    public RegFormController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public void register(RegNoteDTO note) {
        log.info("{}", note);
        User user = User.builder()
                .firstName(note.getFirstName())
                .lastName(note.getLastName())
                .email(note.getEmail())
                .login(note.getLogin())
                .password(note.getPassword())
                .build();

        log.info(user.toString());

        userService.saveNewUser(user);
    }

}