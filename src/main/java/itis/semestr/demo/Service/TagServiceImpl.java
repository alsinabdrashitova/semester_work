package itis.semestr.demo.Service;

import itis.semestr.demo.Models.Tag;
import itis.semestr.demo.Repo.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag findByName(String name) {
        return tagRepository.findTagByName(name);
    }
}
