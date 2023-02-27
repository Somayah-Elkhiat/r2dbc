package cams.tv.tvmanagement.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class config {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
