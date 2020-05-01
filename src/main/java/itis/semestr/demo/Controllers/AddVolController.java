package itis.semestr.demo.Controllers;

import itis.semestr.demo.Dto.SignUpDto;
import itis.semestr.demo.Dto.VolDto;
import itis.semestr.demo.Service.CountryService;
import itis.semestr.demo.Service.TagService;
import itis.semestr.demo.Service.TagServiceImpl;
import itis.semestr.demo.Service.VolService;
import itis.semestr.demo.security.details.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddVolController {

    @Autowired
    private VolService volService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CountryService countryService;

    @GetMapping("/add")
    public String getAddVolPage(Model model) {
        model.addAttribute("tags",tagService.getAll());
        model.addAttribute("countries", countryService.getAll());
        return "add";
    }

    @PostMapping("/add")
    public String postAddVilPage(VolDto volDto){
        volService.addVol(volDto);
        return "redirect:/vol";
    }
}
