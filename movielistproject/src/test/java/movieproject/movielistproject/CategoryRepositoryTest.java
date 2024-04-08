package movieproject.movielistproject;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import movieproject.movielistproject.domain.Category;
import movieproject.movielistproject.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
public void createNewCategoryAndSave(){ // testataan save()metodin toimivuutta
Category category = new Category("Romantic");
categoryRepository.save(category);

assertThat(category.getCategoryId()).isNotNull();
}

@Test 
public void deleteCategory(){ //delete toimivuus testi
    Category category = new Category("Scifi-horror");
    categoryRepository.save(category);

    categoryRepository.delete(category);

    assertThat(categoryRepository.findById(category.getCategoryId()).isEmpty());
}

@Test
public void findCategoryByName() { //categori etsintá findby metodi
    
    Category category = new Category("Horror");
    categoryRepository.save(category);

    
    List<Category> categories = categoryRepository.findByName("Horror");

    
    assertThat(categories).isNotEmpty();
    assertThat(categories.get(0).getName()).isEqualTo(category.getName());
}
}
