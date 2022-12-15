import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUI extends JFrame {
    private JButton leaseButton; //
    private JButton displayButton;
    private JButton exitButton;
    private JLabel header; // Title label of main menu

    public MainMenuGUI() {
        super("Car Leasing System");
        setLayout(new FlowLayout());

        leaseButton = new JButton("Lease a Car");
        add(leaseButton);

        displayButton = new JButton("Display All Leases");
        add(displayButton);

        exitButton = new JButton("Exit");
        add(exitButton);

        header = new JLabel("Car leasing System");

        ButtonHandler handler = new ButtonHandler();

    }

    private class ButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(MainMenuGUI.this,
                    String.format("You pressed the %s button", e.getActionCommand() ) );
        }
    }
}
