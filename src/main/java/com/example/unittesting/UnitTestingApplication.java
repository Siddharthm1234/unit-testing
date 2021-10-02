package com.example.unittesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class UnitTestingApplication implements CommandLineRunner {

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(UnitTestingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String[] activeProfiles = this.environment.getActiveProfiles();

		boolean testProfile  = false;
		for(String env : activeProfiles){
			if(env.equals("test")){
				testProfile = true;
			}
		}

		if(testProfile){
			//any logic can go here
		}
	}
}
