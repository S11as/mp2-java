package Clock;

import Clock.Clock;
import com.github.javafaker.Faker;
import com.github.javafaker.Number;

import java.util.ArrayList;

public class ClockFactory {

    public static IClock createClock(ClockType type, ClockBrands brand) {
        switch (type) {
            case DEFAULT: {
                return new Clock(brand);
            }
            case EXTENDED: {
                return new ExtendedClock(brand);
            }
            default:{
                return new Clock();
            }
        }
    }

    public static IClock createClock(ClockType type, ClockBrands brand, int price) {
        switch (type) {
            case DEFAULT: {
                return new Clock(brand, price);
            }
            case EXTENDED: {
                return new ExtendedClock(brand, price);
            }
            default:{
                return new Clock();
            }
        }
    }

    public static ArrayList<IClock> createClockList(int count){
        Faker faker = new Faker();
        Number n = faker.number();
        ArrayList<IClock> clocks = new ArrayList<IClock>();
        for (int i=0; i<count; i++){
            IClock c = ClockFactory.createClock(ClockType.getRandomType(),
                                                ClockBrands.getRandomBrand(),
                                                n.numberBetween(1000, 10000));
            clocks.add(c);
        }
        return clocks;
    }

}

