package itis.semestr.demo.Controllers;

import itis.semestr.demo.Dto.SignUpDto;
import itis.semestr.demo.Models.User;
import itis.semestr.demo.Service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
    @Autowired
    private SignUpService service;

   // @PreAuthorize("permitAll()")
    @GetMapping("/signUp")
    public String getSignUpPage(Model model) {
        model.addAttribute("user", new User());
            return "signUp";
        }

    //@PreAuthorize("permitAll()")
    @PostMapping("/signUp")
    public String signUp(SignUpDto form) {
        service.signUp(form);
        return "redirect:/signIn";
    }
}
