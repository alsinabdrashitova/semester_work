package itis.semestr.demo.Repo;

import itis.semestr.demo.Models.Volunteering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolRepository extends JpaRepository<Volunteering, Long> {
}
