package YCpowergroup.mealplanner;

import YCpowergroup.mealplanner.controller.FruitRepository;
import YCpowergroup.mealplanner.controller.FruitService;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

public class FruitServiceTest {

    @Autowired
    FruitService fruitService;

    @MockBean
    FruitRepository fruitRepository;
    public void test(){
    }
}
