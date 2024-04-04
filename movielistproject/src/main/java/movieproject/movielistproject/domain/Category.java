package movieproject.movielistproject.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

    
    @Id //pk
    @JsonIgnoreProperties("category") // infinite looppi esto json haussa
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;
    private String name;

   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Movie> movies;

    public Category() {
    };

    public Category(String name) {
        super();
        this.name = name;
    }

    // get
    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    // set
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

   
    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", name=" + name + "]";
    } // ei lista attribuutteja
}

