import Clock.Clock;
import Clock.ClockBrands;
import Clock.ClockFactory;
import Clock.IClock;
import Clock.ClockType;
import Clock.ClockBrands;
import ClockShop.ClockShop;
import GUI.ClockShopView;
import com.github.javafaker.Crypto;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.owlike.genson.Genson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<IClock> c = ClockFactory.createClockList(4);
        ClockShop shop = new ClockShop(c);
        ClockShopView app = new ClockShopView(shop);
        app.setVisible(true);
    }
}
