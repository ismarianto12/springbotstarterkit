package com.edukasi.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigApp {

    public String Hostname;
    public String Port;
    public String getApidev;
    public String ApiKey;

    @Value("${app.ApiStaticsKey}")
    public void setApiKey(String apiKey) {
        this.ApiKey = apiKey;
    }

    @Value("${app.demoApi}")
    public void setApidev(String apidev) {
        this.getApidev = apidev;
    }

    @Value("${app.hostname}")
    public void setHost(String host) {
        this.Hostname = host;
    }

    @Value("${app.hostname}")
    public void setPort(String port) {
        this.Port = port;
    }

    public String getHostname() {
        return Hostname;
    }

    public String getPort() {
        return Port;
    }

    public String getApidev() {
        return getApidev;
    }
    public String getApiKey() {
        return ApiKey;
    }
}
