package spring.project.twitchtracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TwitchUsersResponse {
    private List<User> data;
}
