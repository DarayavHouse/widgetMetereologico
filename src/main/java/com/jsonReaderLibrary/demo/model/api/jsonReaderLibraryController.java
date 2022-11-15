package com.jsonReaderLibrary.demo.model.api;

import com.jsonReaderLibrary.demo.utilities.ConfigProperties;
import com.jsonReaderLibrary.demo.utilities.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class jsonReaderLibraryController {

    static Logger logger = Logger.getLogger(jsonReaderLibraryController.class.getName());

    @Autowired
    private ConfigProperties config;

    @RequestMapping("/jsonReader")
    @ResponseBody
    public ResponseEntity<String> jsonReader() {
        logger.info("INIZIO jsonReader");
//        String url = config.getBaseurl() + "?lat=" + config.getLat() + "&lon=" + config.getLon() + "&units=metric&lang=it&appid=" + config.getAppId() + "";
        String url = config.getNewUrl() +"?bibkeys="+config.getBibKeys()+","+ config.getBibKeysDue()+"&format="+config.getFormat()+"";
        logger.info("Stampa Url Json Reader" + url);
        return new ResponseEntity<>(Utility.readableJson(Utility.getJson(url)), HttpStatus.OK);
    }

}
