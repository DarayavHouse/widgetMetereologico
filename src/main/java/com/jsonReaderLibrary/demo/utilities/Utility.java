package com.jsonReaderLibrary.demo.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsonReaderLibrary.demo.model.JsonReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

public class Utility {
    static Logger logger = Logger.getLogger(Utility.class.getName());

    public static JsonReader getJson(String url) {
        logger.info("getJson: " + url);
        return getJsonRequest(url);
    }

    public static JsonReader getJsonRequest(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(response.getBody(), JsonReader.class);
        } catch (JsonProcessingException e) {
            logger.severe(String.format("", response.getBody(), "JsonReader", e));
            throw new RuntimeException(e);
        }
    }

    public static String readableJson(JsonReader jr) {
        logger.info("readableJson");
        return "Vediamolo 'sto Json " + jr.getIsbnList() + jr.getLccnList();
    }



}