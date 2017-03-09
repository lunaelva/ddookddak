//package com.ddook.ddak.common.config;
//
//import javax.servlet.ServletContext;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import com.mitchellbosecke.pebble.PebbleEngine;
//import com.mitchellbosecke.pebble.loader.Loader;
//import com.mitchellbosecke.pebble.loader.ServletLoader;
//import com.mitchellbosecke.pebble.spring4.PebbleViewResolver;
//import com.mitchellbosecke.pebble.spring4.extension.SpringExtension;
//
//@Configuration
//@ComponentScan(basePackages = { "com.ddook.ddak.*" })
//@EnableWebMvc
//public class MvcConfig extends WebMvcConfigurerAdapter {
//
//    @Autowired
//    private ServletContext servletContext;
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
//    }
//
//    @Bean
//    public PebbleEngine pebbleEngine() {
//        return new PebbleEngine.Builder().loader(this.templateLoader()).extension(this.springExtension()).build();
//    }
//
//    @Bean
//    public SpringExtension springExtension() {
//        return new SpringExtension();
//    }
//
//    @Bean
//    public Loader<?> templateLoader() {
//        return new ServletLoader(this.servletContext);
//    }
//
//    @Bean
//    public ViewResolver viewResolver() {
//        PebbleViewResolver viewResolver = new PebbleViewResolver();
//        viewResolver.setPrefix("/WEB-INF/templates/");
//        viewResolver.setSuffix(".html");
//        viewResolver.setPebbleEngine(this.pebbleEngine());
//        return viewResolver;
//    }
//
//}