package com.br.projeto.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.br.projeto.model.Sensor;
import com.br.projeto.model.Temperatura;
import com.br.projeto.repository.ISensorRepository;
import com.br.projeto.repository.ITemperaturaRepository;

import java.util.Optional;

@Controller
public class TemperaturaController {

    private final ISensorRepository sensorRepository;
    private final ITemperaturaRepository temperaturaRepository;

    public TemperaturaController(ISensorRepository sensorRepository, ITemperaturaRepository temperaturaRepository) {
        this.sensorRepository = sensorRepository;
        this.temperaturaRepository = temperaturaRepository;
    }

    @PostMapping("/temperatura")
    public String cadastroSensor(@ModelAttribute Sensor sensor, Model model) {

        Sensor existingSensor = sensorRepository.findByNome(sensor.getNome());
        if (existingSensor != null) {
            model.addAttribute("error", "Este nome já está em uso.");
            System.out.println("Deu errado");
            return "temperatura";
        }
        sensorRepository.save(sensor);
        System.out.println("Deu certo");
        return "redirect:/temperatura";
    }

    @RequestMapping(path="/temperatura", method=RequestMethod.GET)
    public String temperatura(Model model) {
        Iterable<Sensor> sensores = sensorRepository.findAll();
        model.addAttribute("sensores", sensores);
        return "temperatura";
    }

    @PostMapping("/cadastro-temperatura")
    public String cadastroTemperatura(@ModelAttribute Temperatura temperatura, Model model) {

        Optional<Temperatura> existingTemperatura = temperaturaRepository.findById(temperatura.getId());
        if (existingTemperatura.isPresent()) {
            model.addAttribute("error", "Este ID já está em uso.");
            System.out.println("Deu errado");
            return "temperatura";
        }
        temperaturaRepository.save(temperatura);
        System.out.println("Deu certo");
        return "redirect:/temperatura";
    }
}
