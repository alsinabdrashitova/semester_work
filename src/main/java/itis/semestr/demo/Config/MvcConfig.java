package itis.semestr.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS ={
      "classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/", "classpath:/public/"
    };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

    @Bean
    public InternalResourceViewResolver ftlhViewResolver(){
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/templates/");
        resourceViewResolver.setPrefix(".ftlh");
        return resourceViewResolver;
    }

    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/signUp").setViewName("signUp");
    }
}
