/**
 * 
 */
package com.exide.sfcrm.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
/**
 * @author saurabhp
 *
 */
@SpringBootApplication
@ComponentScan(value="com.exide.sfcrm")
@Configuration
@EnableJpaRepositories("com.exide.sfcrm.repository")
@EnableAutoConfiguration(exclude = RepositoryRestMvcAutoConfiguration.class)
@EntityScan("com.exide.sfcrm.model")
@EnableTransactionManagement
public class Application extends SpringBootServletInitializer{


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 SpringApplication.run(Application.class, args);
		 
	}

}
