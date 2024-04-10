package movieproject.movielistproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import movieproject.movielistproject.domain.Category;
import movieproject.movielistproject.domain.CategoryRepository;
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
	public CommandLineRunner demo(MovieRepository movieRepository, UserRepository userRepository, RatingRepository ratingRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			//luonti
			Category category1 = new Category("Fantasy");
			
			Category category2 = new Category("Horror");
			
			Category category3 = new Category("Comedy");
			
			Category category4 = new Category("Documentary");
			
			Category category5 = new Category("Science-fiction");
			
			Category category6 = new Category("Crime");
			
			//tallennus
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			categoryRepository.save(category4);
			categoryRepository.save(category5);
			categoryRepository.save(category6);

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






			 Movie movie1 = new Movie(1, "The Batman", 2022, "Matt Reeves", rating4,category1);

			movieRepository.save(movie1);

			Movie movie2 = new Movie(2, "Parasite", 2017, "Bong Joon Ho", rating5, category6);

			movieRepository.save(movie2);

			Movie movie3 = new Movie(3, "The Silence of the Lambs", 1991, "Jonathan Demme", rating3, category2);

			movieRepository.save(movie3);

			Movie movie4 = new Movie(4, "Psyko", 1960, "Alfred Hitchcock", rating5, category2);
			movieRepository.save(movie4);
 
			



			//kayttajat , salasanat kryptattu bcryptcalculator.com
			User user1 = new User("user", "$2a$10$kZVbnojCrT.OoZGQAUxSN.4JJa0fRmGSmbeP7wZ3vQ8EdX0bZKMRy", "matti.mattinen@gmail.com", "USER");

			User user2 = new User("admin", "$2a$10$tgP2X.tnUKa6i5576MlhUOm/EkLuzq2xvC.9513jTkVKuFlfaUFuy", "maija.maijanen@gmail.com", "ADMIN");

			userRepository.save(user1); 
			userRepository.save(user2);


			

		};
	}

	}
