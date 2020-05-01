package itis.semestr.demo.Service;

import itis.semestr.demo.Models.HostCountry;
import itis.semestr.demo.Repo.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<HostCountry> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public HostCountry findByName(String countryName) {
        return countryRepository.findHostCountryByCountryName(countryName);
    }
}
