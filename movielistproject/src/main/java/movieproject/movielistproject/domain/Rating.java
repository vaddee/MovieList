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
    private String reviewContent; // Added property for review content
    private String reviewerName; // ei valttamatta tarvii ? nyt tostring null, ei linkitysta

    @ManyToOne
    @JoinColumn(name = "movie_id")
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

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Rating [ratingId=" + ratingId + ", ratingValue=" + ratingValue + ", reviewContent=" + reviewContent + ", reviewerName=" + reviewerName + "]";
    }
}
