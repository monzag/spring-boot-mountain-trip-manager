package com.monzag.mountaintripmanager.common;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.stereotype.Component;

@Component
public class AppLogger {

    private Logger logger4j = LogManager.getLogger(AppLogger.class);
    private Marker marker = MarkerManager.getMarker("START");

    public void debug(String message) {
        logger4j.debug(marker, message);
    }

    public void error(String message) {
        logger4j.error(marker, message);
    }
}
