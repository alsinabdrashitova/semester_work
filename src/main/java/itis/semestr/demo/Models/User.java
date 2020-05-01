package itis.semestr.demo.Models;

import itis.semestr.demo.Validator.FieldMatch;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_table")
//@FieldMatch.List({@FieldMatch(first = "password", second = "passwordRepeat", message = "Пароли не совпадают")})
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String hashPassword;

    @Transient
    private String passwordRepeat;

    private String sex;

    private String country;

    @Enumerated(value = EnumType.STRING)
    private Role role;

//    private String time;

//    @Enumerated(value = EnumType.STRING)
//    private Active active;
//
//    private int count;
//
//    private boolean isBaned;
}
