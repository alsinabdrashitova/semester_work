package itis.semestr.demo.Service;

import itis.semestr.demo.Models.HostCountry;

import java.util.List;

public interface CountryService {
    List<HostCountry> getAll();
    HostCountry findByName(String countryName);
}
