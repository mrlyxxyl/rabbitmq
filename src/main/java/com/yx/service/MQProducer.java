package com.yx.service;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mqProducer")
public class MQProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    private final static Logger LOGGER = Logger.getLogger(MQProducer.class);

    public void sendDataToQueue(String queueKey, Object object) {
        try {
            amqpTemplate.convertAndSend(queueKey, object);
        } catch (Exception e) {
            LOGGER.error(e);
            e.printStackTrace();
        }
    }
}