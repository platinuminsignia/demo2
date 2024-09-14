package config;

import core.MyInterceptor1;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;

@Configuration
public class MyConfig3 implements WebMvcConfigurer {

    @PostConstruct
    public void init(){
        System.out.println("!!!!!!!!!!!!");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration registration = registry.addInterceptor(new MyInterceptor1());
        registration.addPathPatterns("/**");

    }
}
