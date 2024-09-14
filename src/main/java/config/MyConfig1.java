package config;

import core.MyFilter1;
import core.NeedLoginServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "foo.bar", name = "enable", havingValue = "true", matchIfMissing = false)
public class MyConfig1 {


    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean<MyFilter1> registrationBean = new FilterRegistrationBean<>(new MyFilter1());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("noFilter", "/one,/two");
        registrationBean.setName("my-filter1");
        registrationBean.setOrder(1);
        return registrationBean;
    }

}
