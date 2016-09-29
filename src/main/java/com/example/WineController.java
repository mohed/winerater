package com.example;

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

    @RequestMapping("/results")
    public ModelAndView matchingWines(){

        return new ModelAndView("results");
    }

}
