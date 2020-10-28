package Clock;

import org.w3c.dom.ranges.RangeException;

import java.util.stream.Stream;

public class Clock implements IClock {
    protected int hour = 0;
    protected int minute = 0;
    protected int price = 0;
    protected ClockBrands brand;

    public Clock(){}

    public Clock(ClockBrands brand, int price){
        this.setBrand(brand);
        this.setPrice(price);
    }

    public Clock(ClockBrands brand){
        this.setBrand(brand);
    }

    public Clock(int hour, int minute, int price, ClockBrands brand){
        this.setHour(hour);
        this.setMinute(minute);
        this.setPrice(price);
        this.setBrand(brand);
    }

    public void setHour(int hour){
        if(hour < 0){
            throw new IllegalArgumentException("Hour shouldnt be lower than 0");
        }
        this.hour = hour % 24;
    }

    public int getHour(){
        return this.hour;
    }

    public void setMinute(int minute) {
        if(minute < 0){
            throw new IllegalArgumentException("Minute shouldnt be lower than 0");
        }
        this.minute = minute % 60;
    }

    public int getMinute(){
        return this.minute;
    }

    public void setPrice(int price){
        if(price <= 0){
            throw new IllegalArgumentException("Price shouldnt be lower than 0");
        }
        this.price = price;
    }

    @Override
    public int getPrice(){
        return this.price;
    }

    @Override
    public ClockBrands getBrand(){
        return this.brand;
    }

    public void setBrand(ClockBrands brand) { this.brand = brand; }

    @Override
    public void setTime(int hour, int minute, int seconds){
        this.setHour(hour);
        this.setMinute(minute);
    }


    @Override
    public String toString(){
        String h = this.hour < 10 ? "0"+this.hour : Integer.toString(this.hour);
        String m = this.minute < 10 ? "0"+this.minute : Integer.toString(this.minute);
        return h+":"+m + "  " + this.brand.getBrandName() + "  $" + this.price;
    }

    @Override
    public void addTime(int hour, int minute, int seconds){
        int excessHours = (this.minute + minute) / 60;
        this.minute  = (this.minute + minute) % 60;
        this.hour = (this.hour + excessHours + hour) % 24;
    }

}
