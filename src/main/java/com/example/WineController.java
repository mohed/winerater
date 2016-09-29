package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Roberto Angius on 2016-09-28.
 */

@RestController
public class WineController {

    @Autowired
    private WineRepository wineRepository;

    @GetMapping("/results")
    public ModelAndView matchingWines(){
        List<Wine> wines = wineRepository.listWines();
        return new ModelAndView("results").addObject("matchingWines", wines);
    }

}
