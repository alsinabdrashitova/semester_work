package itis.semestr.demo.Controllers;

import itis.semestr.demo.Models.Volunteering;
import itis.semestr.demo.Service.VolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VolunteeringController {

    @Autowired
    private VolService volService;

    @Autowired
    ConversionService conversionService;


    @GetMapping("/vol")
    public String getVolPage(Model model) {
        model.addAttribute("vol", volService.getAll());
        return "vol";
    }

    @PostMapping("/delete")
    public String deleteVol(Volunteering volunteering){
        volService.delete(volunteering);
        return "redirect:/vol";
    }

    @GetMapping("/vol/{id}")
    public String getByIdPage(Model model, @PathVariable("id") String idLine){
        Volunteering elem = conversionService.convert(idLine, Volunteering.class);
        model.addAttribute("elem", elem);
        return "volId";
    }
}
