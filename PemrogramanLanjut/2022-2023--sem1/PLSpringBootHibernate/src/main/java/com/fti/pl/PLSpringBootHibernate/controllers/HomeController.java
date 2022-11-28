package com.fti.pl.PLSpringBootHibernate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping(path = {"/"}, method = RequestMethod.GET)
    public String home (
        @RequestParam(name = "nama", defaultValue = "", required = false) String namaParam,
        Model model
    ) {
        model.addAttribute("namaModel", namaParam);
        return "index";
    }

}
