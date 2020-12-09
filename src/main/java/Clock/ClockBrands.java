package Clock;

import com.github.javafaker.Faker;
import com.github.javafaker.Number;

import java.util.Arrays;

public enum ClockBrands {
    HOWARD_MILLER("Howard Miller"),
    HERMLE("Hermle Clocks"),
    BULOVA("Bulova Clocks"),
    RHYTHM("Rhythm Clocks");

    private final String brand;
    ClockBrands(String h) {
        this.brand = h;
    }

    public String getBrandName(){
        return this.brand;
    }

    public static ClockBrands getRandomBrand(){
        Faker faker = new Faker();
        Number n = faker.number();
        int index = n.numberBetween(0, 4);
        switch (index){
            case 1:
                return HERMLE;
            case 2:
                return BULOVA;
            case 3:
                return RHYTHM;
            default:
                return HOWARD_MILLER;
        }
    }

    public static String[] getBrands(){
        return Arrays.stream(values()).map(Enum::name).toArray(String[]::new);
    }

//    public static ClockType getBrand(String type){
//        switch (type){
//            case "Extended":
//                return EXTENDED;
//            default:
//                return DEFAULT;
//        }
//    }
}
