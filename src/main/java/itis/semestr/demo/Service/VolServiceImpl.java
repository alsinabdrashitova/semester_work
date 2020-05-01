package itis.semestr.demo.Service;

import itis.semestr.demo.Dto.VolDto;
import itis.semestr.demo.Models.HostCountry;
import itis.semestr.demo.Models.Tag;
import itis.semestr.demo.Models.User;
import itis.semestr.demo.Models.Volunteering;
import itis.semestr.demo.Repo.CountryRepository;
import itis.semestr.demo.Repo.TagRepository;
import itis.semestr.demo.Repo.VolRepository;
import itis.semestr.demo.security.details.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VolServiceImpl implements VolService {

    @Autowired
    private VolRepository volRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void addVol(VolDto dto) {
        ArrayList<Tag> list = new ArrayList<>();
        for (String s : dto.getTag()) {
            list.add(tagRepository.findTagByName(s));
        }

        HostCountry hostCountry = countryRepository.findHostCountryByCountryName(dto.getCountryName());

        Volunteering volunteering = Volunteering.builder()

                .name(dto.getName())
                .about(dto.getAbout())
                .tags(list)
                .country(hostCountry)
                .build();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        volunteering.setAuthor(user);

        volRepository.save(volunteering);
    }

    @Override
    public List<Volunteering> getAll() {
        return volRepository.findAll();
    }

    @Override
    public void delete(Volunteering volunteering) {
        volRepository.delete(volunteering);
    }
}
