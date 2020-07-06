package com.restapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDatabase {
    private static final Logger log = (Logger) LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(EmployRepository repository){
      return args -> {
        log.info("Preloading "+ repository.save(new Employee("Bilbao Baggins", "burglar")));
          log.info("Preloading "+ repository.save(new Employee("Frodo Baggins", "thief")));
      };
    }
}
