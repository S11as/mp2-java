import javax.swing.*;

public class MainFrame extends JFrame {
    MainFrame(){
        super("Clock shop");
        this.setBounds(100, 100, 250, 100);
        this.getContentPane().add(new ClockPanel());
    }
}
