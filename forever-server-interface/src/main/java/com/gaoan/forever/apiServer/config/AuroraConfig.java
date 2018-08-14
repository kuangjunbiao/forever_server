package com.gaoan.forever.apiServer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DELL on 2017/9/9.
 */
@Component
@ConfigurationProperties(prefix = "aurora")
public class AuroraConfig {
    private Map<String, String> mapProps = new HashMap<>();

    public Map<String, String> getMapProps() {
        return mapProps;
    }

    public void setMapProps(Map<String, String> mapProps) {
        this.mapProps = mapProps;
    }
}
