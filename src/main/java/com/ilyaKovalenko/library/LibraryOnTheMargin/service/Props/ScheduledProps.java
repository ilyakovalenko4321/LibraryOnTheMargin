package com.ilyaKovalenko.library.LibraryOnTheMargin.service.Props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "time")
@Data
public class ScheduledProps {
    private long jwtTokenCheck;
}
