package com.example.log4j2demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Log4j2DemoApplication implements ApplicationRunner{

	private static final Logger logger = LogManager.getLogger(Log4j2DemoApplication.class);

	private static ConfigurableApplicationContext caCtx;

	public static void main(String[] args) {
        caCtx = SpringApplication.run(Log4j2DemoApplication.class, args);//.close();
        // Exemplo para forçar a saída da aplicação.
        // SpringApplication.exit(caCtx);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		logger.debug("Debugging log");
		logger.info("Info log");
		logger.warn("Hey, This is a warning!");
		logger.error("Oops! We have an Error. OK");
		logger.fatal("Damn! Fatal error. Please fix me.");
		//SpringApplication.
        //caCtx.close();
	}
}
