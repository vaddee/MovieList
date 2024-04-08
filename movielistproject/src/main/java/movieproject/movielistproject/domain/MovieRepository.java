package movieproject.movielistproject.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface MovieRepository extends CrudRepository<Movie, Integer> {
List<Movie> findByDirector(String director);
}
