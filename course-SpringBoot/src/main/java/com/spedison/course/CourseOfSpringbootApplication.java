package com.spedison.course;

import com.spedison.course.controler.AppErrorController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = {"com.spedison.course.controler"})
@Configuration
public class CourseOfSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseOfSpringbootApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

	@Autowired
	private ErrorAttributes errorAttributes;

	@Bean
	public AppErrorController appErrorController(){return new AppErrorController(errorAttributes);}

}
