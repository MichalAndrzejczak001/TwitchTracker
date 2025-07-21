package spring.project.twitchtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.project.twitchtracker.model.User;

import java.util.Optional;

@Repository
public interface UserRerpository extends JpaRepository<User, Long> {
    Optional<User> findByTwitchid(String twitchid);
}
