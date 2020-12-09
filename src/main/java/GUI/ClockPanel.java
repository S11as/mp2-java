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

    private JLabel hoursLabel;
    private JLabel minutesLabel;
    private JLabel secondsLabel;

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

        hoursLabel = new JLabel("1");
        minutesLabel = new JLabel("2");
        secondsLabel = new JLabel("3");

        setTime = new JButton("Set time");


        this.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        this.placeItem(brand, 0, 0, 1);
        this.placeItem(hoursLabel, 1, 0,0, true);
        this.placeItem(minutesLabel, 2, 0,0, true);
        this.placeItem(secondsLabel, 3, 0,0, true);
        this.placeItem(hours, 1, 1, 1);
        this.placeItem(minutes, 2, 1, 1);
        this.placeItem(seconds, 3, 1, 1);
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
        constraints.ipadx = 3;
        this.add(c, constraints);
    }

    void placeItem(Container c, int x, int y, int xwidth, boolean center){
        constraints.gridx=x;
        constraints.gridy=y;
        constraints.gridwidth=xwidth;
        if(center)
            constraints.ipadx = 10;

        this.add(c, constraints);
    }

    @Override
    public void refresh() {
        if(model == null) return;
        this.brand.setText(model.getBrand().getBrandName());
        this.price.setText("$"+model.getPrice());
        this.hoursLabel.setText(model.getHour()+"h");
        this.minutesLabel.setText(model.getMinute()+"m");
        this.secondsLabel.setText(model.getSecond()+"s");
        this.hours.setText(String.valueOf(0));
        this.minutes.setText(String.valueOf(0));
        this.seconds.setText(String.valueOf(0));
    }

    class ButtonEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.setTime(Integer.parseInt(hours.getText()),Integer.parseInt(minutes.getText()),
                    Integer.parseInt(seconds.getText()));
        }
    }
}


