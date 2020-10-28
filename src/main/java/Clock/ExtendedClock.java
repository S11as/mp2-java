package Clock;

public class ExtendedClock extends Clock implements IClock {
    private int seconds = 0;

    public ExtendedClock(int hour, int minute, int seconds, int price, ClockBrands brand){
        super(hour, minute, price, brand);
        this.setSeconds(seconds);
    }

    public ExtendedClock(ClockBrands brand){
        super(brand);
    }
    public ExtendedClock(ClockBrands brand, int price){
        super(brand, price);
    }

    public int getSeconds(){ return this.seconds; }

    public void setSeconds(int seconds){
        if(seconds < 0){
            throw new IllegalArgumentException("Price shouldnt be lower than 0");
        }
        this.seconds = seconds;
    }

    @Override
    public void addTime(int hour, int minute, int seconds){
        int excessMinutes = (this.seconds + seconds)/60;
        int excessHours = (this.minute + minute + excessMinutes)/60;
        this.seconds = (this.seconds + seconds) % 60;
        this.minute = (this.minute + minute + excessMinutes) % 60;
        this.hour = (this.hour + hour + excessHours) % 24;
    }

    @Override
    public void setTime(int hour, int minute, int seconds) {
        this.setHour(hour);
        this.setMinute(minute);
        this.setSeconds(seconds);
    }

    @Override
    public String toString(){
        String h = this.hour < 10 ? "0"+this.hour : Integer.toString(this.hour);
        String m = this.minute < 10 ? "0"+this.minute : Integer.toString(this.minute);
        String s = this.seconds < 10 ? "0"+this.seconds : Integer.toString(this.seconds);
        return h+":"+m + ":"+ s + "  " + this.brand.getBrandName() + "  $" + this.price;
    }
}

