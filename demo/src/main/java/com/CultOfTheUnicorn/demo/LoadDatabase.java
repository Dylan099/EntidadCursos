package com.CultOfTheUnicorn.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(CursoRepository repository){
        return args -> {
          log.info("Preloading" + repository.save(new Curso("Calculo I","10:00 - 11:00 A.M","Aula F11")));
        };
    }
}
