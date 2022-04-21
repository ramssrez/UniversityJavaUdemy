package com.ramssrez.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.ramssrez")
@PropertySource("classpath:application.properties")
public class SpringConfig {
}
