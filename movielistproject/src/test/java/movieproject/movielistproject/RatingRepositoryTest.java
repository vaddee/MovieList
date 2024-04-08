package movieproject.movielistproject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import movieproject.movielistproject.domain.Rating;
import movieproject.movielistproject.domain.RatingRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RatingRepositoryTest {

    @Autowired
    private RatingRepository ratingRepository;

    @Test
    public void createNewRatingAndSave(){
        Rating rating = new Rating(6);
        ratingRepository.save(rating);

        assertThat(rating.getRatingId()).isNotNull();
    }

    @Test
    public void deleteRating(){
        Rating rating = new Rating(7);
        ratingRepository.save(rating);

        ratingRepository.delete(rating);
        assertFalse(ratingRepository.existsById(rating.getRatingId())); // tarkistus onnistumisesta.
    }

    @Test
    public void updateRating(){ // rating paivitys
        
        Rating rating = new Rating(8);
        ratingRepository.save(rating);

        // muokkaus
        rating.setRatingValue(9);
        
        // tallennus uus rating
        Rating updatedRating = ratingRepository.save(rating);

        // uuden rating haku
        Rating retrievedRating = ratingRepository.findById(updatedRating.getRatingId()).orElse(null);

        
        assertNotNull(retrievedRating);

        
        assertEquals(9, retrievedRating.getRatingValue());
    }

}
