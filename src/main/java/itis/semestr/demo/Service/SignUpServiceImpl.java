package itis.semestr.demo.Service;

import itis.semestr.demo.Dto.SignUpDto;
import itis.semestr.demo.Models.Role;
import itis.semestr.demo.Models.User;
import itis.semestr.demo.Repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void signUp(SignUpDto form) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = simpleDateFormat.format(date);
        System.out.println("aaa" + time);
        String[] arrTime = time.split(":");
        String min = arrTime[1];
        System.out.println("ede"+ min);
        User user = User.builder()
                .login(form.getLogin())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .passwordRepeat(form.getPasswordRepeat())
                .sex(form.getSex())
                .country(form.getCountry())
//                .time(arrTime[1])
                .role(Role.USER)
//                .active(Active.NOTACTIVE)
//                .count(0)
                .build();

         usersRepository.save(user);
    }
}
