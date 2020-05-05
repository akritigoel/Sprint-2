package  org.com.onlinetest;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import org.com.onlinetest.controller.TestController;
import org.com.onlinetest.exception.RecordNotFoundException;
import org.com.onlinetest.model.Question;
import org.com.onlinetest.model.Assessment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@SpringBootApplication
public class OnlineTestManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineTestManagementApplication.class, args);
		
	}
	 @Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("")).build();
	   }

}
