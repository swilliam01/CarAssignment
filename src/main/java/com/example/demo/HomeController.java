package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    CarRepository carRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("/")
    public String carsList(Model model){
        model.addAttribute("carstore", carRepository.findAll());
        return "base";
    }
    @GetMapping("/add")

    public String carList(Model model){
        model.addAttribute("carstores", new Car());
        return "list";
    }
}
