package itis.semestr.demo.Service;

import itis.semestr.demo.Models.Tag;
import itis.semestr.demo.Validator.FieldMatch;

import java.util.List;

public interface TagService {
    List<Tag> getAll();
    Tag findByName(String name);
}
