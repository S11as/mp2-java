package Clock;

public interface IClock{
    void setTime(int hour, int minute, int seconds);
    void addTime(int hour, int minute, int seconds);

    int getPrice();
    ClockBrands getBrand();
}
