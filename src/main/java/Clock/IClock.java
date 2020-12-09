package Clock;

import GUI.IObserver;

public interface IClock{
    void setTime(int hour, int minute, int seconds);
    void addTime(int hour, int minute, int seconds);

    int getHour();
    int getMinute();
    int getSecond();
    int getPrice();
    ClockBrands getBrand();
    ClockType getType();

    void subscribe(IObserver observer);

}
