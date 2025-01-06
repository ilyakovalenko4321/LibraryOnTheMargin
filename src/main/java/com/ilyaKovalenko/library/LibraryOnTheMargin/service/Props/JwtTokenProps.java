package com.ilyaKovalenko.library.LibraryOnTheMargin.service.Props;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "security")
@Data
public class JwtTokenProps {

    private String secretKey;

    private Long validity;
}
