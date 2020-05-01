package itis.semestr.demo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier(value = "customUserDetailService")
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//       super.configure(http);
//        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/signUp").permitAll()
                .antMatchers("/profile").authenticated()
                .antMatchers("/deleteUser").authenticated()
                .antMatchers("/vol").authenticated()
                .antMatchers("/add").authenticated()
                .antMatchers("/volId/{id}").authenticated()
                .antMatchers("/").authenticated();
//                .and()
//                .logout().logoutSuccessUrl("/signIn").permitAll();

        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/signIn");

        http.formLogin()
                .loginPage("/signIn")
                .usernameParameter("login")
                .defaultSuccessUrl("/")
                .failureUrl("/signIn")
                .permitAll();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
