package com.smd.workshopspringMVC;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class WorkshopSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopSpringMvcApplication.class, args);
	}

    @Bean
    LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
    
}
