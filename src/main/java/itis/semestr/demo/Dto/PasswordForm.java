package itis.semestr.demo.Dto;

import lombok.Data;

@Data
public class PasswordForm {
    private String oldPassword;
    private String newPassword;
}
