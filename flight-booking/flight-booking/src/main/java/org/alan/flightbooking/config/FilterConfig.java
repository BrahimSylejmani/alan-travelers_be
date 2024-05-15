package org.alan.flightbooking.config;

import org.alan.flightbooking.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilter() {
        FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtFilter());
        // Apply to all endpoints or specific endpoints as needed
        registrationBean.addUrlPatterns("/api/v1/*");
        return registrationBean;
    }
}

