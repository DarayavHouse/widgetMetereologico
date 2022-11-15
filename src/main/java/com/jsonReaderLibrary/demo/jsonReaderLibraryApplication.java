package com.jsonReaderLibrary.demo;

import com.jsonReaderLibrary.demo.utilities.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class jsonReaderLibraryApplication implements CommandLineRunner  {
    static Logger logger = Logger.getLogger(jsonReaderLibraryApplication.class.getName());

    @Autowired
    private ConfigProperties config;

    public static void main(String[] args) {
        SpringApplication.run(jsonReaderLibraryApplication.class, args);
    }
    @Override
    public void run(String... strings) {
        logger.info(getLogo());
        logger.info("------------------------Il Server è Up!------------------------");
    }

    public static String getLogo() {
        return  "\n\n" +
                "  JSON READER\n" +
                "  JSON READER\n" +
                "  JSON READER\n" +
                "  JSON READER\n" +
                "  JSON READER\n" +
                "  JSON READER\n" +
                "  JSON READER\n";
    }

}
