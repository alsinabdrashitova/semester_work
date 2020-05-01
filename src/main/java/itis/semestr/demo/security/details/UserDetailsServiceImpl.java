package itis.semestr.demo.security.details;

import itis.semestr.demo.Repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import itis.semestr.demo.Models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "customUserDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> optionalUser = usersRepository.findUserByLogin(login);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            return new UserDetailsImpl(user);
        }
        throw new UsernameNotFoundException("User not found");
    }
}
