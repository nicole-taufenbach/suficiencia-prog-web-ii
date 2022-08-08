package com.furb.prog.web.furb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.furb.prog.web.furb"))
                .paths(regex("/RestAPIFurb/comandas.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        return new ApiInfo(
                "Prova de Suficiencia Prog Web II",
                "Web Service REST da Prova de Suficiencia Prog Web II",
                "1.0",
                "Terms of Service",
                new Contact("Nicole Taufenbach", "https://github.com/nicole-taufenbach/suficiencia-prog-web-ii",
                        "ntaufenbach@br.experian.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<>()
        );
    }

}
