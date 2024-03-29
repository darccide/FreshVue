package com.darccide.FreshVue;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class FreshVueApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreshVueApplication.class, args);
	}
        
        // Fix CORS issues
//        @Bean
//        public FilterRegistrationBean simpleCorsFilter() {
//            UrlBasedCorsConfigurationSource source 
//                    = new UrlBasedCorsConfigurationSource();
//            CorsConfiguration config = new CorsConfiguration();
//            config.setAllowCredentials(true);
//            config.setAllowedOrigins(Collections.singletonList(
//                    "http://localhost:8080"));
//            config.setAllowedMethods(Collections.singletonList("*"));
//            config.setAllowedHeaders(Collections.singletonList("*"));
//            source.registerCorsConfiguration("/**", config);
//            FilterRegistrationBean bean 
//                    = new FilterRegistrationBean<>(new CorsFilter(source));
//            bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//            return bean;
//        }

}
