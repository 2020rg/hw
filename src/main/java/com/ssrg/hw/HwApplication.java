package com.ssrg.hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@SpringBootApplication
@Configuration
public class HwApplication{

    public static void main(String[] args) {
        SpringApplication.run(HwApplication.class, args);
    }


    /**
     * session时长设置
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8080);
            }
        };
    }

    /**
     * 添加对jsp支持
     *
     */
/*
    @Bean
    public ViewResolver getJspViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/");//前缀
        internalResourceViewResolver.setSuffix(".jsp");//后缀
        internalResourceViewResolver.setOrder(0);//优先级
        return internalResourceViewResolver;
    }
*/
    /**
     * 添加对Freemarker支持
     *
     */
/*
    @Bean
    public FreeMarkerViewResolver getFreeMarkerViewResolver() {
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setCache(false);
        freeMarkerViewResolver.setPrefix("/pages/");//前缀
        freeMarkerViewResolver.setSuffix(".html");//后缀
        freeMarkerViewResolver.setRequestContextAttribute("request");
        freeMarkerViewResolver.setOrder(1);//优先级
        freeMarkerViewResolver.setContentType("text/html;charset=UTF-8");
        return freeMarkerViewResolver;

    }
    */
}
