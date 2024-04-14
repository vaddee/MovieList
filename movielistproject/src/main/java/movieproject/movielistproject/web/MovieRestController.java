package movieproject.movielistproject.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import movieproject.movielistproject.domain.Movie;
import movieproject.movielistproject.domain.MovieRepository;

@CrossOrigin
@Controller
public class MovieRestController {

    @Autowired
    private MovieRepository movieRepository;

    // REST to get all
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public @ResponseBody List<Movie> movieListRest() {
        return (List<Movie>) movieRepository.findAll();
    }

    // REST to get movie by id
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Movie> getOneMovieById(@PathVariable("id") Integer movieId) {
        return movieRepository.findById(movieId);
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public @ResponseBody Movie addNewMovie(@RequestBody Movie newMovie) {

        return movieRepository.save(newMovie);

    }
}
