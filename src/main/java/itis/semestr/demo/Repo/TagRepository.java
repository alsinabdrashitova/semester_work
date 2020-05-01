package itis.semestr.demo.Repo;

import itis.semestr.demo.Models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long>{
    Tag findTagByName(String name);
}

