package GUI;

import Clock.ClockBrands;
import ClockShop.ClockShop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveLoadPanel extends JPanel {
    private JButton save;
    private JButton load;
    private ClockShop shop;

    public SaveLoadPanel(ClockShop shop){
        this.shop = shop;

        save = new JButton("Save");
        load = new JButton("Load");

        this.setLayout(new FlowLayout());


        save.addActionListener((ActionListener) e -> {
            shop.save("shop.json");
        });

        load.addActionListener((ActionListener) e -> {
            try{
                shop.load("shop.json");
            }catch (Exception exception){
                exception.printStackTrace();
            }
        });

        this.add(save);
        this.add(load);
    }
}
