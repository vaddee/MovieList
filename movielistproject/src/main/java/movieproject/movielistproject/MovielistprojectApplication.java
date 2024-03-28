package movieproject.movielistproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import movieproject.movielistproject.domain.Movie;
import movieproject.movielistproject.domain.MovieRepository;

@SpringBootApplication
public class MovielistprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovielistprojectApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(MovieRepository movieRepository) {
		return (args) -> {

			Movie movie1 = new Movie(1, "The Batman", 2022, "Matt Reeves");

			movieRepository.save(movie1);

			Movie movie2 = new Movie(2, "Parasite", 2017, "Bong Joon Ho");

			movieRepository.save(movie2);

			Movie movie3 = new Movie(3, "The Silence of the Lambs", 1991, "Jonathan Demme");

			movieRepository.save(movie3);



			

		};
	}

	}
