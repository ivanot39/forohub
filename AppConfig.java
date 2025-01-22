package com.foro.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.foro")
@Import(org.springframework.orm.jpa.annotation.EnableJpaRepositories.class)
public class AppConfig implements WebMvcConfigurer {
}
