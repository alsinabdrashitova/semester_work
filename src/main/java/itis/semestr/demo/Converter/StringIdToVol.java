package itis.semestr.demo.Converter;


import itis.semestr.demo.Models.Volunteering;
import itis.semestr.demo.Repo.VolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StringIdToVol implements Converter<String, Volunteering> {

    @Autowired
    private VolRepository volRepository;

    @Override
    public Volunteering convert(String s) {
        Long id = Long.parseLong(s);
        Optional<Volunteering> elem = volRepository.findById(id);
        if (elem.isPresent()){
            return elem.get();
        }
        return null;
    }
}