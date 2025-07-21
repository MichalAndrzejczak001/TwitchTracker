package spring.project.twitchtracker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.project.twitchtracker.model.User;
import spring.project.twitchtracker.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController (IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get/{login}")
    public ResponseEntity<User> getUser(@PathVariable String login) {
        User user = userService.getUser(login);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
