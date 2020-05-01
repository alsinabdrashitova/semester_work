package itis.semestr.demo.Controllers;

import itis.semestr.demo.Models.User;
import itis.semestr.demo.Repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class SignInController {

    @GetMapping("/signIn")
    public String getSignInPage() {
        return "signIn";
    }


}
