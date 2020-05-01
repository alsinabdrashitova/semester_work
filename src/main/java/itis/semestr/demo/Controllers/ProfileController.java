package itis.semestr.demo.Controllers;

import itis.semestr.demo.Dto.PasswordForm;
import itis.semestr.demo.Dto.SignUpDto;
import itis.semestr.demo.Models.User;
import itis.semestr.demo.Service.UserService;
import itis.semestr.demo.Service.UserServiceImpl;
import itis.semestr.demo.security.details.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    @Autowired
    private UserServiceImpl userService;

   // @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public String getProfile(Authentication authentication, Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/logout")
    public String logoutProfile(){
        return "redirect:/signIn";

    }

    @PostMapping("/deleteUser")
    public String deleteUser(Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        userService.deleteUser(user.getId());
        return "redirect:/logout";
    }

    @PostMapping("/profile")
    public String editProfile(SignUpDto signUpDto){
        userService.edit(signUpDto);
        return "redirect:/profile";
    }

    @PostMapping("/pass")
    public String editPassword(PasswordForm passwordForm){
        userService.changePassword(passwordForm);
        return "redirect:/profile";
    }

}
