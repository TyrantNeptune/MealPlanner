package YCpowergroup.mealplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SpringBootApplication
@ConfigurationProperties
public class MealplannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MealplannerApplication.class, args);
	}

}
