package movieproject.movielistproject.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import movieproject.movielistproject.domain.CategoryRepository;
import movieproject.movielistproject.domain.Movie;
import movieproject.movielistproject.domain.MovieRepository;
import movieproject.movielistproject.domain.Rating;
import movieproject.movielistproject.domain.RatingRepository;

@Controller

public class MovieController {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/read_reviews/{movieId}")
    public String readReviews(@PathVariable("movieId") Integer movieId, Model model) {
        // Find the movie by ID
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            // Get all ratings
            List<Rating> ratings = ratingRepository.findByMovie(movie);
            model.addAttribute("movie", movie);
            model.addAttribute("ratings", ratings);
            return "read_reviews"; // .html
        } else {

            return "error";
        }
    }

    @RequestMapping(value = "/movielist", method = RequestMethod.GET)
    public String getMovies(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "movielist";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String returnIndex() {
        return "index"; // html
    }

    @RequestMapping(value = "/addmovie", method = RequestMethod.GET)
    public String getNewMovieForm(Model model) {

        model.addAttribute("movie", new Movie());

        model.addAttribute("categories", categoryRepository.findAll()); /* kommentoi jos ei toimi */
        return "addmovie"; // .html
    }

    @RequestMapping(value = "/savemovie", method = RequestMethod.POST)
    public String saveMovie(@Valid Movie newMovie, BindingResult bindingResult, Model model) {
        // Tarkista validointivirheet
        if (bindingResult.hasErrors()) {
            // Jos validointivirheitä ilmenee, palaa takaisin lomakkeeseen näyttämään
            // virheet
            model.addAttribute("movie", newMovie);
            model.addAttribute("categories", categoryRepository.findAll());
            return "addmovie";
        }

        // Tallennetaan elokuva, jos validointi onnistui
        movieRepository.save(newMovie);

        return "redirect:/movielist";
    }

    @RequestMapping(value = "/deletemovie/{movieId}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')") // admin voi vain poistaa
    public String deleteBook(@PathVariable("movieId") Integer movieId, Model model) {

        movieRepository.deleteById(movieId);

        return "redirect:/movielist";
    }

    @RequestMapping(value = "/editmovie/{movieId}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')") // admin voi vain muokata
    public String editMovieGet(@PathVariable("movieId") Integer movieId, Model model) {

        Optional<Movie> movieToEdit = movieRepository.findById(movieId);

        // muokkaa kirjaa
        model.addAttribute("movie", movieToEdit);

        return "editmovie"; // .html
    }

    @RequestMapping(value = "/editmovie", method = RequestMethod.POST)
    public String editMoviePost(Movie editMovie, Model model) {

        movieRepository.save(editMovie);

        return "redirect:/movielist";
    }

    @GetMapping("/rate_movie/{movieId}")
    public String showRatingForm(@PathVariable("movieId") Integer movieId, Model model) {
        model.addAttribute("movieId", movieId);
        model.addAttribute("rating", new Rating());
        return "rate_movie";
    }

    @PostMapping("/rate_movie/{movieId}")
    public String submitRating(@PathVariable("movieId") Integer movieId, @ModelAttribute Rating rating) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);

        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();

            // Set the movie for the rating
            rating.setMovie(movie);

            ratingRepository.save(rating);

            // päivitä elokuvien rating list
            List<Rating> ratings = movie.getRatings();
            if (ratings == null) {
                ratings = new ArrayList<>();
            }
            ratings.add(rating);
            movie.setRatings(ratings);

            // Laskee average rating
            double sum = ratings.stream().mapToDouble(Rating::getRatingValue).sum();
            double averageRating = sum / ratings.size();
            movie.setAverageRating(averageRating);

            movieRepository.save(movie);

            return "redirect:/movielist";
        } else {
            
            return "error";
        }
    }

}
