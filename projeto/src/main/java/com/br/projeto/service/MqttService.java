package com.br.projeto.service;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqttService {

    @Autowired
    private MqttClient mqttClient;

    private static final int QOS = 1;

    public void subscribe(String topic) throws MqttException {
        mqttClient.subscribe(topic, QOS);
    }

    public void publish(String topic, String msg) throws MqttException {
        MqttMessage message = new MqttMessage(msg.getBytes());
        message.setQos(QOS);
        mqttClient.publish(topic, message);
    }

    public void disconnect() throws MqttException {
        mqttClient.disconnect();
        mqttClient.close();
    }

    public void testMqtt() throws MqttException, InterruptedException {

        String topic = "unifebe/si05gabigol22";
        String msg = "teste";

        publish(topic, msg);
        subscribe(topic);

        while (true) {
            Thread.sleep(1000);
            System.out.println(topic);
        }
            
    }
}
