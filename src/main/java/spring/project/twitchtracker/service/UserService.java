package spring.project.twitchtracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.project.twitchtracker.model.User;
import spring.project.twitchtracker.repository.UserRerpository;
import spring.project.twitchtracker.utility.TwitchApiClient;

@Service
public class UserService implements IUserService{

    private final UserRerpository userRerpository;

    @Autowired
    public UserService(UserRerpository userRerpository) {
        this.userRerpository = userRerpository;
    }

    @Override
    public User getUser(String login) {
        TwitchApiClient client = new TwitchApiClient();
        User response = client.getUser(login);
        User savedUser = userRerpository.findByTwitchid(response.getTwitchId())
                .ifPresentOrElse((user) -> { }, );

        return response;
    }
}
