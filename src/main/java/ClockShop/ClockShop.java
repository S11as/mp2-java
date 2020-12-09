package ClockShop;

import Clock.ClockBrands;
import Clock.ExtendedClock;
import Clock.IClock;
import GUI.IObserver;
import com.google.gson.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ClockShop.InterfaceSerializer;


public class ClockShop {
    private ArrayList<IClock> clocks = new ArrayList<>();
    transient protected ArrayList<IObserver> observers = new ArrayList<>();

    public ClockShop(){}
    public ClockShop(ArrayList<IClock> clocks){
        this.clocks = clocks;
    }

    public IClock getMostExpensiveClock(){
        if(this.clocks.size()==0)
            throw new NullPointerException("Shop is empty");
        IClock max = this.clocks.get(0);
        int maxPrice = max.getPrice();
        for(int i=1; i<this.clocks.size(); ++i){
            IClock clock = this.clocks.get(i);
            int clockPrice = clock.getPrice();
            if(clockPrice>maxPrice){
                max = clock;
                maxPrice = clock.getPrice();
            }
        }
        return max;
    }

    public void setTime(int hour, int minute, int second){
        for(IClock clock : this.clocks){
            clock.setTime(hour, minute, second);
        }
    }

    public void setTime(int hour, int minute){
        for(IClock clock : this.clocks){
            clock.setTime(hour, minute, 0);
        }
    }

    public ClockBrands getMostPopularBrand(){
        Map<ClockBrands, Integer> list = new HashMap<>();
        list.put(ClockBrands.HOWARD_MILLER, 0);
        list.put(ClockBrands.BULOVA, 0);
        list.put(ClockBrands.HERMLE, 0);
        list.put(ClockBrands.RHYTHM, 0);
        for(IClock clock : this.clocks){
            int val = list.get(clock.getBrand());
            list.put(clock.getBrand(), val+1);
        }
        if(list.isEmpty()){
            throw new NullPointerException("Shop is empty");
        }
        ClockBrands brand = ClockBrands.HOWARD_MILLER;
        Integer count = 0;
        for(Map.Entry<ClockBrands, Integer> entry : list.entrySet()){
            if(entry.getValue() > count){
                count = entry.getValue();
                brand = entry.getKey();
            }
        }
        return brand;
    }

    public ArrayList<IClock> getClocks(){
        return clocks;
    }

    public void subscribe(IObserver observer){
        this.observers.add(observer);
    }

    public void inform(){
        for(IObserver o:observers){
            o.refresh();
        }
    }

    public void addClock(IClock c){
        this.clocks.add(c);
        this.inform();
    }

    public boolean save(String filename){
        try{
            Writer writer = new FileWriter(filename);
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(IClock.class, new InterfaceSerializer())
                    .create();
            gson.toJson(this, writer);
            writer.flush();
            writer.close();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public  ClockShop load(String filename) throws IOException {
        File myFile = new File(filename);
        FileInputStream fIn = new FileInputStream(myFile);
        BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn));
        String aDataRow = "";
        StringBuilder aBuffer = new StringBuilder();
        while ((aDataRow = myReader.readLine()) != null)
        {
            aBuffer.append(aDataRow);
        }
        myReader.close();
        String json = aBuffer.toString();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(IClock.class, new InterfaceSerializer())
                .create();
        ClockShop clockShop = gson.fromJson(json, ClockShop.class);
        this.clocks = clockShop.getClocks();
        this.inform();
        return this;
    }



}
