package Clock;

import com.github.javafaker.Faker;
import com.github.javafaker.Number;

public enum ClockType {
    DEFAULT,
    EXTENDED;

    public static ClockType getRandomType(){
        Faker faker = new Faker();
        Number n = faker.number();
        int index = n.numberBetween(0, 2);
        if(index<0 || index> 1)
            throw new IllegalArgumentException("No such index");
        switch (index){
            case 1:
                return EXTENDED;
            default:
                return DEFAULT;
        }
    }
}
