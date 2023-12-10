package com.org.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import jakarta.annotation.PostConstruct;

@Configuration
public class ThymleafConfig {

	@Autowired
	private SpringTemplateEngine templateEngine;
	
	@PostConstruct
	public void extension() {
		FileTemplateResolver resolver=new FileTemplateResolver();
		resolver.setPrefix("C:\\Recursos\\template\\");
		resolver.setSuffix(".html");
		resolver.setTemplateMode("HTML");
		resolver.setOrder(templateEngine.getTemplateResolvers().size());
		resolver.setCacheable(false);
		templateEngine.addTemplateResolver(resolver);
	}
}
