package ClockShop;

import Clock.ClockBrands;
import Clock.IClock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ClockShop {
    private ArrayList<IClock> clocks = new ArrayList<>();

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

}
