package com.ddook.ddak.common.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.Loader;
import com.mitchellbosecke.pebble.loader.ServletLoader;
import com.mitchellbosecke.pebble.spring4.PebbleViewResolver;
import com.mitchellbosecke.pebble.spring4.extension.SpringExtension;


@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	ServletContext servletContext;
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.defaultContentType(MediaType.APPLICATION_JSON);
		
		Map<String, MediaType> mediaTypes = new HashMap<String, MediaType>();
		mediaTypes.put("json", MediaType.APPLICATION_JSON);
		mediaTypes.put("xml", MediaType.APPLICATION_XML);
		mediaTypes.put("text", MediaType.TEXT_PLAIN);
		mediaTypes.put("html", MediaType.TEXT_HTML);
		mediaTypes.put("do", MediaType.TEXT_HTML);
		
		configurer.mediaTypes(mediaTypes);
	}
	
	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		//viewResolver.setContentNegotiationManager(manager);
		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
		
//		resolvers.add(jspViewResolver());
		resolvers.add(pebbleViewResolver());
		resolvers.add(jsonViewResolver());
		
		resolver.setViewResolvers(resolvers);
		resolver.setContentNegotiationManager(manager);
		
		return resolver;
	}
	
	@Bean
	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	@Bean
	public Loader templateLoader() {
		return new ServletLoader(servletContext);
	}
	/*
	@Bean
	public PebbleEngine pebbleEngine() {
		return new PebbleEngine(templateLoader());
	}*/
	
	@Bean
	public SpringExtension springExtension() {
		return new SpringExtension();
	}
	@Bean
	public PebbleEngine pebbleEngine() {
		return new PebbleEngine.Builder()
				.loader(this.templateLoader())
				.extension(springExtension())
				.build();
	}
	
	@Bean
	public ViewResolver pebbleViewResolver() {
		PebbleViewResolver viewResolver = new PebbleViewResolver();
		viewResolver.setPrefix("/WEB-INF/templates/");
		viewResolver.setSuffix(".html");
		viewResolver.setPebbleEngine(pebbleEngine());
		
		return viewResolver;
	}
	
	@Bean
	public ViewResolver jsonViewResolver() {
		return new JsonViewResolver();
	}
	
//	@Bean
//	public ViewResolver pebbleViewTemplateResolver() {
//		return new PebbleViewTemplateResolver().pebbleViewResolver();
//	}
}
