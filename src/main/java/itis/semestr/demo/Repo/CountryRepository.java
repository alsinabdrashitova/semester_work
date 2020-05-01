package itis.semestr.demo.Repo;

import itis.semestr.demo.Models.HostCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<HostCountry, Long> {
    HostCountry findHostCountryByCountryName(String countryName) ;
}
