package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    CarRepository carRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("/")
    public String carsList(Model model) {
        model.addAttribute("carstore", carRepository.findAll());
        return "base";
    }

    @GetMapping("/add")
    public String categoryList(Model model) {
        model.addAttribute("carstores", new Category());
        return "categoryForm";
    }

    @PostMapping("/process")
    public String categoryAdd(@Valid @ModelAttribute("carstores") Category carstores) {
        categoryRepository.save(carstores);
        return "redirect:/categoryList";
    }

    @RequestMapping("/categoryList")
    public String getCategories(Model model){
        model.addAttribute("carstore", categoryRepository.findAll());
        return "listingform";
    }

    @GetMapping("/carpage")
    public String carList(Model model) {
        model.addAttribute("object2", new Car());
        return "carform";
    }

    @PostMapping("/carpage2")
    public String carAdding(@Valid @ModelAttribute("object2") Car object2) {
        carRepository.save(object2);
        return "redirect:/";
    }
}