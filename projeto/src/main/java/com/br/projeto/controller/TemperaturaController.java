package com.br.projeto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TemperaturaController {
    
    @RequestMapping(path="/temperatura", method=RequestMethod.GET)
    public String temperatura(Model model) {

        return "temperatura";
    }
}
