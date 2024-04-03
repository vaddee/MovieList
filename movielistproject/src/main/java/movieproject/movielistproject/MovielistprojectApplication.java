package movieproject.movielistproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import movieproject.movielistproject.domain.Movie;
import movieproject.movielistproject.domain.MovieRepository;
import movieproject.movielistproject.domain.Rating;
import movieproject.movielistproject.domain.RatingRepository;
import movieproject.movielistproject.domain.User;
import movieproject.movielistproject.domain.UserRepository;

@SpringBootApplication
public class MovielistprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovielistprojectApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(MovieRepository movieRepository, UserRepository userRepository, RatingRepository ratingRepository) {
		return (args) -> {

			 // Ratings 1-5/

			 Rating rating1 = new Rating(1);
			 ratingRepository.save(rating1);

			 Rating rating2 = new Rating(2);
			 ratingRepository.save(rating2);

			 Rating rating3 = new Rating(3);
			 ratingRepository.save(rating3);

			 Rating rating4 = new Rating(4);
			 ratingRepository.save(rating4);

			 Rating rating5 = new Rating(5);
			 ratingRepository.save(rating5);






			/* Movie movie1 = new Movie(1, "The Batman", 2022, "Matt Reeves", rating4);

			movieRepository.save(movie1);

			Movie movie2 = new Movie(2, "Parasite", 2017, "Bong Joon Ho", rating5);

			movieRepository.save(movie2);

			Movie movie3 = new Movie(3, "The Silence of the Lambs", 1991, "Jonathan Demme", rating3);

			movieRepository.save(movie3);

			Movie movie4 = new Movie(4, "jaskajokunen", 2022, "v.l", rating5);
			movieRepository.save(movie4);
 */
			



			//kayttajat , salasanat kryptattu bcryptcalculator.com
			User user1 = new User("user", "$2a$10$kZVbnojCrT.OoZGQAUxSN.4JJa0fRmGSmbeP7wZ3vQ8EdX0bZKMRy", "matti.mattinen@gmail.com", "USER");

			User user2 = new User("admin", "$2a$10$tgP2X.tnUKa6i5576MlhUOm/EkLuzq2xvC.9513jTkVKuFlfaUFuy", "maija.maijanen@gmail.com", "ADMIN");

			userRepository.save(user1); 
			userRepository.save(user2);


			

		};
	}

	}
