package com.example.kdh.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@AllArgsConstructor
@Configuration
@Slf4j
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/",
                        "/error",

                        "/css/**", "/font/**", "/img/**", "/js/**", "/assets/**", "/node_modules/**", "/scss/**", "/vendor/**"); // resource file
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**", "/img/**", "/css/**", "/js/**", "/vendor/**", "/font/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/", "classpath:/static/img/", "classpath:/static/css/",
                        "classpath:/static/js/", "classpath:/static/vendor/", "classpath:/static/font/");
    }

}
