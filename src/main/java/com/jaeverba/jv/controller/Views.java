package com.jaeverba.jv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Views {
    @RequestMapping("/")
    public String home(HttpServletRequest request, HttpServletResponse response, Model model) {

        String idioma = Idioma.getLang(request, response);
        model.addAttribute("lang", idioma);

        return "home";
    }

    /*@RequestMapping("/error")
    public String error() {
        return "error";
    }*/
}
