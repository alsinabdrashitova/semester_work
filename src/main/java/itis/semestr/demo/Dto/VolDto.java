package itis.semestr.demo.Dto;

import itis.semestr.demo.Models.HostCountry;
import itis.semestr.demo.Models.User;
import javafx.application.HostServices;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class VolDto {
    private String name;
    private String about;
    private User author;
    private String[] tag;
    private String countryName;
}
