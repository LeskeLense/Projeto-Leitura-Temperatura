package com.br.projeto.controller;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.br.projeto.service.*;


@RestController
@RequestMapping("/mqtt")
public class MqttController {

    @Autowired
    private MqttService mqttService;

    @PostMapping("/publish")
    public void publish(@RequestParam String topic, @RequestParam String message) throws MqttException {
        mqttService.publish(topic, message);
    }

    @PostMapping("/subscribe")
    public void subscribe(@RequestParam String topic) throws MqttException {
        mqttService.subscribe(topic);
    }

    @PostMapping("/disconnect")
    public void disconnect() throws MqttException {
        mqttService.disconnect();
    }

    @PostMapping("/test")
    @GetMapping("/test") 
    public void testMqtt() throws MqttException, InterruptedException {
        mqttService.testMqtt();
    }
}
