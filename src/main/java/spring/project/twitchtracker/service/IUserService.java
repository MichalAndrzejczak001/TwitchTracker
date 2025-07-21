package spring.project.twitchtracker.service;

import spring.project.twitchtracker.model.User;

public interface IUserService {
    public User getUser(String login);
}
