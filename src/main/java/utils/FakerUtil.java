package utils;

import com.github.javafaker.Faker;

public class FakerUtil {
    Faker faker = new Faker();


    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {

        return faker.name().lastName();
    }

    public Integer getRandomInt(){
        return faker.random().nextInt(1000);
    }
}
