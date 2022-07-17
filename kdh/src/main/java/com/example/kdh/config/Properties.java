package com.example.kdh.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "com.example.kdh")
@Getter
@Setter
@Component
public class Properties {

}
