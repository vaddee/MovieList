package movieproject.movielistproject;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import movieproject.movielistproject.domain.Category;
import movieproject.movielistproject.domain.CategoryRepository;
import movieproject.movielistproject.domain.Movie;
import movieproject.movielistproject.domain.MovieRepository;

@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest

public class MovieRepositoryTest {
@Autowired
private MovieRepository movieRepository;

@Autowired
private CategoryRepository categoryRepository;

@Test
public void FindByDirectorShouldReturnMovie (){ // testataan MovieRepository findbyDirector toimintaa
    List<Movie> movies = movieRepository.findByDirector("Matt Reeves");

    assertThat(movies).hasSize(1);
    assertThat(movies.get(0).getName()).isEqualTo("The Batman");
}

@Test
public void createNewMovie(){ 
    // test save()method
    Category category = new Category();
    

    
    Movie movie = new Movie(9, "Maija Poppanen", 1969, "Valtteri Laakso", null, category); 
    

   
    movieRepository.save(movie);

    // Assert that the movie ID is not null
    assertThat(movie.getMovieId()).isNotNull();
}

@Test
public void deleteMovie(){ //test delete method
    Category category = new Category();
    

    
    Movie movie = new Movie(9, "Maija Poppanen", 1969, "Valtteri Laakso", null, category); 
    movieRepository.save(movie);
    movieRepository.delete(movie);
    assertThat(movieRepository.findById(movie.getMovieId()).isEmpty());
   
}


}
