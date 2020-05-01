package itis.semestr.demo.Service;

import itis.semestr.demo.Dto.VolDto;
import itis.semestr.demo.Models.Volunteering;

import java.util.List;

public interface VolService {
    void addVol(VolDto dto);
    List<Volunteering> getAll();
    void delete(Volunteering volunteering);
}
