package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.Fruit;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@Service
public class FruitService {

    @Autowired
    FruitRepository fruitRepository;

    FruitService(){
        System.out.println("Fruit Service");
    }



    public long DaysTillExpired(long id){
        System.out.println("Expired test");
        Fruit fruit = fruitRepository.findById(id).get();
        LocalDateTime today = LocalDateTime.now();
        return ChronoUnit.DAYS.between(LocalDateTime.now(),fruit.getExpiryDate());
    }

}
