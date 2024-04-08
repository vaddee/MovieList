package movieproject.movielistproject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import movieproject.movielistproject.web.CategoryController;
import movieproject.movielistproject.web.MovieController;

@SpringBootTest
class MovielistprojectApplicationTests {
	@Autowired
	private MovieController movieController;

	@Autowired
	private CategoryController categoryController;

	


	@Test
	void MovieControllerTest() {
		assertThat(movieController).isNotNull();
	}

	@Test
	void CategoryControllerTest() {
		assertThat(categoryController).isNotNull();
	}

}
