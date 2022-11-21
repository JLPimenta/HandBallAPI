package crp.handball.API.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import crp.handball.API.model.user.User;

public interface userRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByLogin(String login);

}