package com.fittestsoft.agentes.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogService.class);

    public void info(String message) {
        LOGGER.info(message);
        System.out.println(message);//Usado conforme requisito
    }

    public void error(String message, Exception ex) {
        LOGGER.error(message, ex);
    }
}
