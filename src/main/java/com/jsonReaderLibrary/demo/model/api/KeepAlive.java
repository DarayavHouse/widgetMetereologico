package com.jsonReaderLibrary.demo.model.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class KeepAlive {

    static Logger logger = Logger.getLogger(KeepAlive.class.getName());

    @RequestMapping("/keepAlive")
    @ResponseBody
    public ResponseEntity<String> keepAlive(){
        logger.info("keepAlive");
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}
