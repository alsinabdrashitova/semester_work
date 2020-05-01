package itis.semestr.demo.Repo;


import itis.semestr.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
Optional<User> findUserByLogin(String login);
Optional<User> findUserById(Long id);

}


