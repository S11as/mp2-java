package GUI;

import Clock.Clock;
import Clock.IClock;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockPanel extends JPanel implements IObserver{

    private IClock model = null;
    private GridBagConstraints constraints;

    private JLabel brand;
    private JLabel price;

    private JTextField hours;
    private JTextField minutes;
    private JTextField seconds;

    private JButton setTime;

    public ClockPanel(){
        brand = new JLabel("Brand");
        price = new JLabel("12312");
        hours = new JTextField("",4);
        minutes = new JTextField("",4);
        seconds = new JTextField("",4);

        setTime = new JButton("Set time");


        this.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        this.placeItem(brand, 0, 0, 1);
        this.placeItem(hours, 1, 0, 1);
        this.placeItem(minutes, 2, 0, 1);
        this.placeItem(seconds, 3, 0, 1);
        this.placeItem(price, 4, 0, 1);
        this.placeItem(setTime, 4, 1, 2);

        setTime.addActionListener(new ButtonEventListener());
    }

    void init(IClock m){
        model = m;
        model.subscribe(this);
        this.refresh();
    }

    void placeItem(Container c, int x, int y, int xwidth){
        constraints.gridx=x;
        constraints.gridy=y;
        constraints.gridwidth=xwidth;
        this.add(c, constraints);
    }

    void placeItem(Container c, int x, int y, int xwidth, double yweight){
        constraints.gridx=x;
        constraints.gridy=y;
        constraints.gridwidth=xwidth;
        constraints.weighty = yweight;
        this.add(c, constraints);
    }

    @Override
    public void refresh() {
        if(model == null) return;
        this.brand.setText(model.getBrand().getBrandName());
        this.price.setText("$"+model.getPrice());
        this.hours.setText(String.valueOf(model.getHour()));
        this.minutes.setText(String.valueOf(model.getMinute()));
        this.seconds.setText(String.valueOf(model.getSecond()));
    }

    class ButtonEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setTime(Integer.parseInt(hours.getText()),Integer.parseInt(minutes.getText()),
                    Integer.parseInt(seconds.getText()));
        }
    }
}


