package com.br.projeto.service;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.projeto.model.Temperatura;
import com.br.projeto.repository.ITemperaturaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class MqttConfig {

    private static final String BROKER = "tcp://test.mosquitto.org:1883";
    private static final String CLIENT_ID = "mqttx_22c066c6";
    @Autowired
    private ITemperaturaRepository temperaturaRepository;

    @Bean
    public MqttClient mqttClient() throws MqttException {
        MqttClient client = new MqttClient(BROKER, CLIENT_ID);
        MqttConnectOptions options = new MqttConnectOptions();
        client.connect(options);
        
        client.setCallback(new MqttCallback() {
            @Override
            public void connectionLost(Throwable cause) {
                System.out.println("Connection lost: " + cause.getMessage());
            }

            @Override
            public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
                System.out.println("Topic: " + topic);
                System.out.println("QoS: " + mqttMessage.getQos());
                System.out.println("Message content: " + new String(mqttMessage.getPayload()));
                ObjectMapper mapper = new ObjectMapper();
                Temperatura temperatura = mapper.readValue(new String(mqttMessage.getPayload()), Temperatura.class);
                temperaturaRepository.save(temperatura);
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {
                System.out.println("Delivery complete: " + token.isComplete());
            }
        });
        
        return client;
    }
}
