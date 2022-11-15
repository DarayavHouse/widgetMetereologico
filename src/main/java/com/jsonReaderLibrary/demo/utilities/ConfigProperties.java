package com.jsonReaderLibrary.demo.utilities;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("json.reader")
public class ConfigProperties{

    private String newUrl;
    private String bibKeys;
    private String bibKeysDue;
    private String format;

    public String getNewUrl() {
        return newUrl;
    }

    public void setNewUrl(String newUrl) {
        this.newUrl = newUrl;
    }

    public String getBibKeys() {
        return bibKeys;
    }

    public void setBibKeys(String bibKeys) {
        this.bibKeys = bibKeys;
    }

    public String getBibKeysDue() {
        return bibKeysDue;
    }

    public void setBibKeysDue(String bibKeysDue) {
        this.bibKeysDue = bibKeysDue;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}