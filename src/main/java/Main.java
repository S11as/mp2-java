import Clock.Clock;
import Clock.ClockFactory;
import Clock.ClockType;
import Clock.IClock;
import ClockShop.ClockShop;
import com.github.javafaker.Faker;
import com.github.javafaker.Number;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<IClock> c = ClockFactory.createClockList(10);
        ClockShop shop = new ClockShop(c);

        shop.setTime(12,0,0);
        System.out.println(shop.getMostExpensiveClock());
        System.out.println(shop.getMostPopularBrand());
    }


}
