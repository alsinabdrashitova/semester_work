package itis.semestr.demo.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SignUpDto {
    private String login;
    private String password;
    private String passwordRepeat;
    private String sex;
    private String country;
}