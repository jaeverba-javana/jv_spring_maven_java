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

        String lang = Idioma.getLang(request, response);
        System.out.println(lang);

        model.addAttribute("lang", lang);

        return "home";
    }

    /*@RequestMapping("/error")
    public String error() {
        return "error";
    }*/
}
