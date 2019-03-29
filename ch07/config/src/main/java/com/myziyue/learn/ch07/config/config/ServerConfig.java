package com.myziyue.learn.ch07.config.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("server")
@Configuration
public class ServerConfig {
    private int port;
    private String contextPath;

    public int getPort(){
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getContextPath(){
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
}
