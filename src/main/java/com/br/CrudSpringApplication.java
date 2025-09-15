package com.br;

import com.br.enums.Category;
import com.br.model.Course;
import com.br.model.Lesson;
import com.br.repository.CourseRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	@Profile("test")
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			for (int i = 0; i < 20; i++) {

				Course c = new Course();
				c.setName("Honda " + i);
				c.setCategory(Category.MOTO);

				Lesson l = new Lesson();
				l.setName("Funcionamento de Motor");
				l.setYoutubeUrl("01234567890");
				l.setCourse(c);
				c.getLessons().add(l);

				Lesson l1 = new Lesson();
				l1.setName("Estrutura do chassi");
				l1.setYoutubeUrl("01234567891");
				l1.setCourse(c);
				c.getLessons().add(l1);

				courseRepository.save(c);
			}
		};
	}
}
