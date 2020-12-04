import javax.swing.*;
import java.awt.*;

public class ClockPanel extends JPanel{
    private JLabel label = new JLabel("Hello world");

    ClockPanel(){
        this.add(this.label);
    }
}
