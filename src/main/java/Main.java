import Clock.ClockBrands;
import Clock.ClockFactory;
import Clock.IClock;
import ClockShop.ClockShop;
import GUI.ClockShopView;
import com.github.javafaker.Crypto;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        ArrayList<IClock> c = ClockFactory.createClockList(4);
        ClockShop shop = new ClockShop(c);

        ClockShopView app = new ClockShopView(shop);
        app.setVisible(true);

    }


}
