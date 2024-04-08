package movieproject.movielistproject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import movieproject.movielistproject.domain.User;
import movieproject.movielistproject.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired

    private UserRepository repository;
   
  
    @Test
    public void createNewUserAndSave(){
        User user = new User("matti", "mattinen", "user.user@gmail.com", "USER");
        repository.save(user);

        assertThat(user.getId()).isNotNull(); // tarkistus, et tallentuu
    }

    @Test
    public void deleteUser(){
        User user = new User("matti", "mattinen", "user.user@gmail.com", "USER");
        repository.save(user);
        assertThat(user.getId()).isNotNull();

        repository.delete(user); //delete method
        assertFalse(repository.existsById(user.getId())); // tarkistus, et onnistui
    }

 
    
    

}