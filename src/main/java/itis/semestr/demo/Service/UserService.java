package itis.semestr.demo.Service;

import itis.semestr.demo.Dto.PasswordForm;
import itis.semestr.demo.Dto.SignUpDto;
import itis.semestr.demo.Models.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public interface UserService {
    void deleteUser(Long id);
    Optional<User> getUserById(Long id);
    User changeUser(User user);
    void edit(SignUpDto signUpDto);
    void changePassword(PasswordForm form);
//    void checkUser(String login, String time);
}
