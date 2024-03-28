package movieproject.movielistproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import movieproject.movielistproject.domain.Movie;
import movieproject.movielistproject.domain.MovieRepository;
import movieproject.movielistproject.domain.User;
import movieproject.movielistproject.domain.UserRepository;

@SpringBootApplication
public class MovielistprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovielistprojectApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(MovieRepository movieRepository, UserRepository userRepository) {
		return (args) -> {

			Movie movie1 = new Movie(1, "The Batman", 2022, "Matt Reeves");

			movieRepository.save(movie1);

			Movie movie2 = new Movie(2, "Parasite", 2017, "Bong Joon Ho");

			movieRepository.save(movie2);

			Movie movie3 = new Movie(3, "The Silence of the Lambs", 1991, "Jonathan Demme");

			movieRepository.save(movie3);



			//kayttajat , salasanat kryptattu bcryptcalculator.com
			User user1 = new User("user", "$2a$10$kZVbnojCrT.OoZGQAUxSN.4JJa0fRmGSmbeP7wZ3vQ8EdX0bZKMRy", "matti.mattinen@gmail.com", "USER");

			User user2 = new User("admin", "$2a$10$tgP2X.tnUKa6i5576MlhUOm/EkLuzq2xvC.9513jTkVKuFlfaUFuy", "maija.maijanen@gmail.com", "ADMIN");

			userRepository.save(user1); 
			userRepository.save(user2);


			

		};
	}

	}
