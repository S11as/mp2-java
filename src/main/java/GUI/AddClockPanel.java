package GUI;

import Clock.ClockBrands;
import Clock.ClockFactory;
import Clock.ClockType;
import Clock.IClock;
import ClockShop.ClockShop;
import com.github.javafaker.Bool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClockPanel extends JPanel {
    private ClockShop shop;

    private JTextField price;
    private JComboBox<String> brands;
    private JComboBox<String> extended;

    private JButton addClock;

    public AddClockPanel(ClockShop shop){
        this.shop = shop;
        brands = new JComboBox<String>(ClockBrands.getBrands());
        extended = new JComboBox<String>(new String[]{"DEFAULT", "EXTENDED"});
        price = new JTextField("1000", 5);
        addClock = new JButton("Add clock");

        this.setLayout(new FlowLayout());
        this.add(brands);
        this.add(extended);
        this.add(price);
        this.add(addClock);

        addClock.addActionListener(new ButtonEventListener());
    }

    class ButtonEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ClockBrands b = ClockBrands.valueOf((String) brands.getSelectedItem());
            ClockType type = ClockType.valueOf((String) extended.getSelectedItem());
            int p = Integer.parseInt(price.getText());
            IClock clock = ClockFactory.createClock(type,b,p);
            shop.addClock(clock);
        }
    }
}
