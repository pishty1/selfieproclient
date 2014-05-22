/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.selfiepro.client.config;

import javax.inject.Inject;

import org.selfiepro.client.user.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Spring MVC Configuration.
 * @author Keith Donald
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.selfiepro.client")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserInterceptor(usersConnectionRepository)).addPathPatterns("/item/buy/**");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/signin");
		registry.addViewController("/signout");
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	private @Inject UsersConnectionRepository usersConnectionRepository;
	
	
	@Configuration
	@EnableOAuth2Client
	protected static class ResourceConfiguration {
		
		
		@Bean
		public OAuth2ProtectedResourceDetails trusted() {
			ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
			details.setId("sparklr/trusted");
			details.setClientId("tata");
			details.setClientSecret("passoword");
			details.setGrantType("client_credentials");
			details.setAccessTokenUri("http://selfiepro.herokuapp.com/oauth/token");
			return details;
		}
		
		@Bean
		public OAuth2RestTemplate trustedClientRestTemplate() {
			return new OAuth2RestTemplate(trusted(), new DefaultOAuth2ClientContext());
		}
	}

}
