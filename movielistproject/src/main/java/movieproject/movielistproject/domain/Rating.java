package movieproject.movielistproject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ratingId;
    private int ratingValue;

    @ManyToOne
    @JoinColumn (name = "movie_id") // Specify the foreign key column //tarviiko joincolumn?
    private Movie movie;

    public Rating() {
    }

    public Rating(int ratingValue) {
        this.ratingValue = ratingValue;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public int getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(int ratingValue) {
        this.ratingValue = ratingValue;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Rating [ratingId=" + ratingId + ", ratingValue=" + ratingValue + "]";
    }
}