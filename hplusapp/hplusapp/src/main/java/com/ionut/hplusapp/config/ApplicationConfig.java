package com.ionut.hplusapp.config;

import com.ionut.hplusapp.convertors.*;
import com.ionut.hplusapp.interceptors.*;
import org.springframework.context.annotation.*;
import org.springframework.core.io.*;
import org.springframework.core.task.*;
import org.springframework.format.*;
import org.springframework.scheduling.concurrent.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.*;
import org.springframework.web.servlet.theme.*;
import org.springframework.web.servlet.view.*;

import java.util.*;

@Configuration
@ComponentScan(basePackages = "com.ionut.hplusapp")
public class ApplicationConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("css/**", "images/**")
                .addResourceLocations("classpath:/static/css/", "classpath:/static/images/");// we will tell the application to pick up
        // the static files from a particular path
    }

    @Bean
    public InternalResourceViewResolver jspviewresolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setOrder(2);
        return viewResolver;
    }

    @Override
    protected void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToEnumConverter());
    }

    @Override
    protected void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(5000);
        configurer.setTaskExecutor(myTaskExecutor());
    }

    @Bean
    public AsyncTaskExecutor myTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("hplusapp-thread-");
        return threadPoolTaskExecutor;
    }

    @Bean
    public XmlViewResolver xmlViewResolver() {
        XmlViewResolver viewResolver = new XmlViewResolver();
        viewResolver.setLocation(new ClassPathResource("views.xml"));
        viewResolver.setOrder(1);
        return viewResolver;
    }

//    @Bean
//    public ResourceBundleViewResolver resourceBundleViewResolver() {
//        ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
//        viewResolver.setBasename("views");
//        return viewResolver;
//    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/*");
        registry.addInterceptor(new ThemeChangeInterceptor()); // theme
        registry.addInterceptor(new LocaleChangeInterceptor()); //locale
    }

    @Bean
    public ThemeResolver themeResolver() {
        CookieThemeResolver cookieThemeResolver = new CookieThemeResolver();
        cookieThemeResolver.setCookieName("theme");
        cookieThemeResolver.setDefaultThemeName("client-theme1");
        return cookieThemeResolver;
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(Locale.US);
        cookieLocaleResolver.setCookieName("locale");
        return cookieLocaleResolver;
    }
}
