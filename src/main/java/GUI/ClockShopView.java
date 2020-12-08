package GUI;

import Clock.Clock;
import Clock.ClockBrands;
import Clock.IClock;
import ClockShop.ClockShop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ClockShopView extends JFrame implements IObserver{
    private ClockShop shop;
    private ArrayList<ClockPanel> list = new ArrayList<>();
    private AddClockPanel panel;

    public ClockShopView(ClockShop s){
        super("Clock shop");

        this.setBounds(500, 500, 400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        shop = s;
        shop.subscribe(this);
        initialSetUp();
    }

    public void initialSetUp(){
        ArrayList<IClock> iClocks = shop.getClocks();

//        GridLayout grid = new GridLayout(iClocks.size()+3, 1);
        FlowLayout flow = new FlowLayout();
        flow.setVgap(25);
        this.setLayout(flow);

        for(IClock c : iClocks){
            ClockPanel p = new ClockPanel();
            p.init(c);
            this.list.add(p);
            this.add(p);
        }
        panel = new AddClockPanel(shop);
        this.add(panel);
    }

    @Override
    public void refresh() {
        for (ClockPanel p : list){
            this.remove(p);
        }
        this.remove(panel);
        this.list.clear();


        ArrayList<IClock> iClocks = shop.getClocks();

        for(IClock c : iClocks){
            ClockPanel p = new ClockPanel();
            p.init(c);
            this.list.add(p);
            this.add(p);
        }
        this.add(panel);

        this.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight()+100);
    }
}
