package com.mybatis.demo.comMybatis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value ={"classpath:db/db.properties"})
@Data
public class SystemConfig {
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${db.url}")
    private String url;
    @Value("${db.driver}")
    private String driver;
    @Value("${db.locationMapper}")
    private String locationMapper;//mybatis文件的位置
    @Value("${db.mappersLocation}")
    private String mappersLocation;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
    public String getLocationMapper() {
        return locationMapper;
    }

    public void setLocationMapper(String locationMapper) {
        this.locationMapper = locationMapper;
    }

    public String getMappersLocation() {
        return mappersLocation;
    }

    public void setMappersLocation(String mappersLocation) {
        this.mappersLocation = mappersLocation;
    }
}
