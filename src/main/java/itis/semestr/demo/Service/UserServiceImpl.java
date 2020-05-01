package itis.semestr.demo.Service;

import itis.semestr.demo.Dto.PasswordForm;
import itis.semestr.demo.Dto.SignUpDto;
import itis.semestr.demo.Models.User;
import itis.semestr.demo.Repo.UsersRepository;
import itis.semestr.demo.security.details.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return usersRepository.findUserById(id);
    }

    @Override
    public User changeUser(User user) {
       return usersRepository.save(user);
    }

    @Override
    public void edit(SignUpDto signUpDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = usersRepository.findUserByLogin(authentication.getName()).orElse(new User());
        user.setLogin(signUpDto.getLogin());
        user.setCountry(signUpDto.getCountry());
        user.setSex(signUpDto.getSex());

        usersRepository.save(user);
    }

    @Override
    public void changePassword(PasswordForm form) {
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        System.out.println("rfrf" + user);
        if (bCryptPasswordEncoder.matches(form.getOldPassword(), user.getHashPassword())){
            user.setHashPassword(passwordEncoder.encode(form.getNewPassword()));
            usersRepository.save(user);
        }else {
            throw new IllegalArgumentException();
        }
    }

//    @Override
//    public void checkUser(String login, String time) {
//        Optional<User> user = usersRepository.findUserByLogin(login);
//        User user1 = new User();
//        if (user.isPresent()) {
//            user1 = user.get();
//            if (user1.getLogin() != null){
//                if (user1.getTime() == time){
//                    user1.setActive(Active.ACTIVE);
//                    user1.setCount(0);
//                    usersRepository.save(user1);
//                }else {
//                    int count = user1.getCount();
//                    if (count < 2){
//                        user1.setCount(user1.getCount() + 1);
//                        usersRepository.save(user1);
//                    }else {
//                        user1.setIsBaned(true);
//                    }
//                }
//            }
//        }
//    }
}
