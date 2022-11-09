package mii.co.id.clientappsibkm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import mii.co.id.clientappsibkm.model.Region;
import mii.co.id.clientappsibkm.service.RegionService;

@Controller
@AllArgsConstructor
@RequestMapping("/region")
public class RegionController {
    private RegionService regionService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("regions", regionService.getAll());
        return "region/index";
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable Long id, Model model) {
        model.addAttribute("regions", regionService.getById(id));
        return "region/info";
    }    

    @GetMapping("/create")
    public String createView(Region region) {
        return "region/create-form";
    }

    @PostMapping
    public String create(Region region){
        regionService.create(region);
        return "redirect:/region";
    }

    @GetMapping("/edit/{id}")
    public String editView(Region region) {
        return "region/update-form";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id,Region region){
        regionService.update(id,region);
        return "redirect:/region";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        regionService.delete(id);
        return "redirect:/region";
    }
}
