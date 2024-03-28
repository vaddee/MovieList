package movieproject.movielistproject.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import movieproject.movielistproject.domain.Movie;
import movieproject.movielistproject.domain.MovieRepository;

@Controller

public class MovieController {

    
    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(value = "/movielist", method = RequestMethod.GET)
    public String getMovies(Model model){
        model.addAttribute("movies", movieRepository.findAll());
        return "movielist"; // HTML template file name
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String returnIndex(){
        return "index";
    }

    @RequestMapping(value ="/addmovie", method = RequestMethod.GET)
    public String getNewMovieForm(Model model) {

        
        model.addAttribute("movie", new Movie()); 
        
        /* model.addAttribute("categories", categoryRepository.findAll()); */
        return "addmovie"; // .html
    }

    @RequestMapping(value= "/savemovie", method = RequestMethod.POST)
    public String saveMovie(Movie newMovie, Model model) {

        // tallennus
        movieRepository.save(newMovie);
        
        return "redirect:/movielist"; 
    }

     @RequestMapping(value = "/deletemovie/{movieId}", method = RequestMethod.GET)
    /* @PreAuthorize("hasAuthority('ADMIN')") //suojaa deleten vain adminille, case sensitive  */
    public String deleteBook(@PathVariable("movieId") Integer movieId, Model model) {
        

        movieRepository.deleteById(movieId);

        return "redirect:/movielist";
    }

    @RequestMapping(value = "/editmovie/{movieId}", method = RequestMethod.GET)
    public String editMovieGet(@PathVariable("movieId") Integer movieId, Model model) {

        Optional<Movie> movieToEdit = movieRepository.findById(movieId);


        // muokkaa kirjaa
        model.addAttribute("movie", movieToEdit);

        return "editmovie"; // .html
    }

    @RequestMapping(value= "/editmovie", method = RequestMethod.POST)
    public String editMoviePost(Movie editMovie, Model model) {

      
        movieRepository.save(editMovie);

       
        return "redirect:/movielist"; 
    }

    }



