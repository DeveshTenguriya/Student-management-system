package com.example.Student.management.system.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean //Registers ModelMapper as a Spring Bean
    public ModelMapper modelMapper(){

        ModelMapper modelMapper = new ModelMapper();//Creates the ModelMapper instance , Spring manages this object lifecycle


        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)//Entity field name must match exactly with DTO field, Prevents accidental mapping errors
                .setSkipNullEnabled(true);//Very useful for PUT / UPDATE APIs , If DTO field is null, ModelMapper: it Will NOT overwrite existing entity value and Keeps old data safe

        return modelMapper;
    }
}
