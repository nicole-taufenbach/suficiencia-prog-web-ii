package com.furb.prog.web.furb.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {

        @Bean
        public ModelMapper obterModelMapper() {
            return new ModelMapper();
        }

}
