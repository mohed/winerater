package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class WineController {

    @Autowired
    private WineRepository wineRepository;

    @GetMapping("/")
    public ModelAndView start(){
        return new ModelAndView("index");
    }

    @PostMapping("/results")
    public ModelAndView matchingWines(@RequestParam int articlenumber){
        List<Wine> wines = wineRepository.listWines(articlenumber);
        return new ModelAndView("results").addObject("matchingWines", wines);
    }

    @GetMapping("/results")
    public ModelAndView wineChoice(){
        return new ModelAndView("results");
    }

    @GetMapping("/user")
    public ModelAndView userPage(@RequestParam String username){
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("username", username);
        return modelAndView;
    }

    @PostMapping("/user")
    public ModelAndView userPageWithWineList(@RequestParam String username, @RequestParam int articlenumber){
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("username", username);
        List<Wine> wines = wineRepository.listWines(articlenumber);
        modelAndView.addObject("matchingWines", wines);
        return modelAndView;
    }
}