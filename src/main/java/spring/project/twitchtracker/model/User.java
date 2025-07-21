package spring.project.twitchtracker.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @JsonAlias("id")
//    @JsonProperty("twitchId")
    private String twitchId;
    private String login;
    private String display_name;
    private String type;
    private String broadcaster_type;
    private String description;
    private String profile_image_url;
    private String offline_image_url;
    private String view_count;
    private String email;
    private String created_at;
}
