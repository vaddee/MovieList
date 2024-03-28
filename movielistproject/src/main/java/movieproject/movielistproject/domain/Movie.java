package movieproject.movielistproject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer movieId;
    private String name;
    private Integer publicationYear;
    private String director;

    public Movie(Integer movieId, String name, Integer publicationYear, String director) {
        this.movieId = movieId;
        this.name = name;
        this.publicationYear = publicationYear;
        this.director = director;
    }

    public Movie() {
        super();
        this.movieId = null; 
        this.name = null; 
        this.publicationYear = 0; 
        this.director = null; 
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

    @Override
    public String toString() {
        return "Movie [id=" + movieId + ", name=" + name + ", publicationYear=" + publicationYear + ", director=" + director + "]";
    }
}
