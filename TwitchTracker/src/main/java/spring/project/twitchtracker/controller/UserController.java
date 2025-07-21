package spring.project.twitchtracker.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.project.twitchtracker.utility.TwitchApiClient;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @GetMapping("/get")
    public void getUser() {

    }
}
