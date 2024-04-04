package movieproject.movielistproject.domain;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer movieId;
    private String name;
    private Integer publicationYear;
    private String director;

    @ManyToOne
    private Rating rating; 

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Rating> ratings;

    

    private double averageRating; // New field to store the average rating

    // Movie ManyToOne Category
    @JsonIgnoreProperties("movies") // avoidataan infinite loop Json haussa!
    @ManyToOne
    @JoinColumn(name = "categoryid") // Fk
    private Category category;

    public Movie() {
    }

    public Movie(Integer movieId, String name, Integer publicationYear, String director, Rating rating, Category category) {
        this.movieId = movieId;
        this.name = name;
        this.publicationYear = publicationYear;
        this.director = director;
        this.rating = rating;
        this.category = category;
      
    }

    // Getters and setters

   
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) { /* kommentoi jos ei toimi categoriat */
        this.category = category;
    }
    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    /* public List<Rating> getRatings() {
        return ratings;
    }
    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
 */
     public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    } 

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

 //calculates the average rating based on the ratings associated with the movie
       /*  public double getAverageRating() {
            if (rating != null) {
                return rating.getRatingValue();
            } else {
                return 0.0; // Return 0 if no rating is set for the movie
            }
        } */

        public void setAverageRating(double averageRating) {
            this.averageRating = averageRating;
        }

            // Calculate the average rating based on the ratings associated with the movie
    public double getAverageRating() {
        if (ratings != null && !ratings.isEmpty()) {
            double totalRating = ratings.stream().mapToDouble(Rating::getRatingValue).sum();
            return totalRating / ratings.size();
        } else {
            return 0.0; // Return 0 if no ratings are set for the movie
        }
    }

        
        @Override
        public String toString() {
            return "Movie [movieId=" + movieId + ", name=" + name + ", publicationYear=" + publicationYear
                    + ", director=" + director + ", rating=" + rating + ", category=" + category + "]";
        }

    
}
