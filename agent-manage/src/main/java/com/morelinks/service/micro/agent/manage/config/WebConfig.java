package com.morelinks.service.micro.agent.manage.config;

import com.morelinks.service.micro.agent.manage.interceptor.APIInterceptor;
import com.morelinks.service.micro.agent.manage.interceptor.CrossInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean
    CrossInterceptor CrossInterceptor() {
        return new CrossInterceptor();
    }

    @Bean
    APIInterceptor APIInterceptor() {
        return new APIInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(
                CrossInterceptor());//.addPathPatterns("/**");
        registry.addInterceptor(
                APIInterceptor());
    }
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        AntPathMatcher matcher = new AntPathMatcher();
        matcher.setCaseSensitive(false);
        configurer.setPathMatcher(matcher);
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("PUT", "DELETE","GET","POST")
//                .allowedHeaders("*")
//                .exposedHeaders("access-control-allow-headers",
//                        "access-control-allow-methods",
//                        "access-control-allow-origin",
//                        "access-control-max-age",
//                        "X-Frame-Options")
//                .allowCredentials(false).maxAge(3600);
//    }

    @Bean
    UserAgentArgumentResolver UserAgentArgumentResolver() {
        return new UserAgentArgumentResolver();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(UserAgentArgumentResolver());
    }


}