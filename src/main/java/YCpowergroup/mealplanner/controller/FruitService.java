package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@Service
public class FruitService {
    int a;

    @Autowired
    private FruitRepository fruitRepository;

    FruitService(){
        System.out.println("Fruit Service");
    }

    public long daysTillExpired(long id){
        System.out.println("Expired test");
        Fruit fruit = fruitRepository.findById(id).get();
        return ChronoUnit.DAYS.between(LocalDateTime.now(),fruit.getExpiryDate());
    }

}
