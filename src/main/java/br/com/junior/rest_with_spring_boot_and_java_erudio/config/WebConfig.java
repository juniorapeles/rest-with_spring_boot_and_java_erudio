package br.com.junior.rest_with_spring_boot_and_java_erudio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${cors.originPatterns:default}")
    private String corsOriginPatterns;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        var allowedOrigins = Arrays.stream(corsOriginPatterns.split(","))
                .map(String::trim)
                .toArray(String[]::new);

        registry.addMapping("/**")
                .allowedOrigins(allowedOrigins)
                //.allowedMethods("POST", "GET", "PUT", "DELETE", "OPTIONS")
                .allowedMethods("*")
                .allowCredentials(true)
        ;
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("x-yaml", MediaType.APPLICATION_YAML)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML);
    }


}
