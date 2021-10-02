package com.example.unittesting;

import com.example.unittesting.mvc.domain.Item;
import com.example.unittesting.mvc.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class UnitTestingApplication implements CommandLineRunner {

	@Autowired
	private Environment environment;

	@Autowired
	private ItemRepository itemRepository;

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
			Item item1 = new Item(1L, "Ball", 100, 3);
			Item item3 = new Item(2L, "Bat", 1500, 2);
			Item item2 = new Item(3L, "Stumps", 500, 2);

			itemRepository.save(item1);
			itemRepository.save(item2);
			itemRepository.save(item3);

		}
	}
}
