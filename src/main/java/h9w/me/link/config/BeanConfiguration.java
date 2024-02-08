package h9w.me.link.config;

import h9w.me.link.common.TokenProvider;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "h9w.me.link")
public class BeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {

        return new CustomModelMapper();
    }

    @Bean
    public TokenProvider tokenProvider() {

        return new TokenProvider();
    }
}
