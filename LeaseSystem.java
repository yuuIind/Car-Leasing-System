import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LeaseSystem implements ActionListener {
    static ArrayList<Lease> leaseList = new ArrayList<>();
    JFrame mainMenu;
    JFrame newLeaseMenu;
    JButton leaseButton;
    JButton displayButton;
    JButton exitButton;
    JButton cancelButton;
    JButton continueButton;
    JTextField ownerIdTextField;
    JTextField carModelTextField;
    JTextField carModelYearTextField;
    JTextField leaseDurationTextField;

    LeaseSystem(){
        mainMenu = new JFrame();
        mainMenu.setTitle("Car Leasing System");
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setSize(800,600);
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(4,1, 0, 75));

        //<-----------------------------------------Setting Menu Label------------------------------------------------->
        JLabel menuTitle = new JLabel();
        menuTitle.setText("Car Leasing System");
        menuTitle.setFocusable(false);
        menuTitle.setHorizontalAlignment(JLabel.CENTER);
        menuTitle.setVerticalAlignment(JLabel.BOTTOM);
        menuTitle.setPreferredSize(new Dimension(300, 60));
        menuTitle.setOpaque(false);
        menuTitle.setFont(new Font("Arial", Font.BOLD, 24));
        gridPanel.add(menuTitle);
        //<-----------------------------------------Setting Menu Label------------------------------------------------->

        Dimension buttonDimension = new Dimension(150, 75); //button dimensions

        //<-----------------------------------------Setting Lease Button----------------------------------------------->
        leaseButton = new JButton();
        leaseButton.setText("Lease A Car");
        leaseButton.setBackground(Color.lightGray);
        leaseButton.setPreferredSize(buttonDimension);
        leaseButton.setFocusable(false);
        leaseButton.setFont(new Font("Arial", Font.BOLD, 16));
        leaseButton.addActionListener(this);
        gridPanel.add(leaseButton);
        //<-----------------------------------------Setting Lease Button----------------------------------------------->


        //<-----------------------------------------Setting Display Button--------------------------------------------->
        displayButton = new JButton();
        displayButton.setText("Display All Leases");
        displayButton.setBackground(Color.lightGray);
        displayButton.setPreferredSize(buttonDimension);
        displayButton.setFocusable(false);
        displayButton.setFont(new Font("Arial", Font.BOLD, 16));
        displayButton.addActionListener(this);
        gridPanel.add(displayButton, 2);
        //<-----------------------------------------Setting Display Button--------------------------------------------->


        //<-----------------------------------------Setting Exit Button------------------------------------------------>
        exitButton = new JButton();
        exitButton.setText("Exit");
        exitButton.setBackground(Color.white);
        exitButton.setPreferredSize(buttonDimension);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);
        gridPanel.add(exitButton);
        //<-----------------------------------------Setting Exit Button------------------------------------------------>

        JPanel mainPanel = new JPanel();
        mainPanel.add(gridPanel);
        mainMenu.add(mainPanel);

        mainMenu.setLocationRelativeTo(null);
        mainMenu.setVisible(true);
    }

    public void createLease(){
        newLeaseMenu = new JFrame();
        newLeaseMenu.setTitle("Car Leasing System");
        newLeaseMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newLeaseMenu.setSize(800,600);
        newLeaseMenu.setResizable(false);
        newLeaseMenu.setLayout(null);


        //<-----------------------------------------Setting Page Title Label------------------------------------------->
        JLabel pageTitle = new JLabel("Enter Lease Information");
        pageTitle.setFont(new Font("Arial", Font.BOLD, 24));
        pageTitle.setHorizontalAlignment(SwingConstants.CENTER);
        pageTitle.setVerticalAlignment(SwingConstants.CENTER);
        pageTitle.setBounds(275,80,300,50);
        newLeaseMenu.add(pageTitle);
        //<-----------------------------------------Setting Page Title Label------------------------------------------->



        //<-----------------------------------------Setting OwnerID Label---------------------------------------------->
        JLabel ownerIDlabel = new JLabel("Lease Owner ID:");
        ownerIDlabel.setFont(new Font("Arial", Font.ITALIC, 16));
        ownerIDlabel.setHorizontalAlignment(SwingConstants.RIGHT);
        ownerIDlabel.setBounds(200,150,150,25);
        newLeaseMenu.add(ownerIDlabel);
        //<-----------------------------------------Setting OwnerID Label---------------------------------------------->
        //<-----------------------------------------Setting OwnerID TextField------------------------------------------>
        ownerIdTextField= new JTextField("e.g. John Doe");
        ownerIdTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        ownerIdTextField.setBounds(375,150,250,25);
        newLeaseMenu.add(ownerIdTextField);
        //<-----------------------------------------Setting OwnerID TextField------------------------------------------>



        //<-----------------------------------------Setting Car Model Label-------------------------------------------->
        JLabel CarModelLabel = new JLabel("Car Brand and Model:");
        CarModelLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        CarModelLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        CarModelLabel.setBounds(175,225,175,25);
        newLeaseMenu.add(CarModelLabel);
        //<-----------------------------------------Setting Car Model Label-------------------------------------------->
        //<-----------------------------------------Setting Car Model TextField---------------------------------------->
        carModelTextField = new JTextField("e.g. Toyota Corolla");
        carModelTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        carModelTextField.setBounds(375,225,250,25);
        newLeaseMenu.add(carModelTextField);
        //<-----------------------------------------Setting Car Model TextField---------------------------------------->



        //<-----------------------------------------Setting Car Model Year Label--------------------------------------->
        JLabel CarModelYearLabel = new JLabel("Car Model Year:");
        CarModelYearLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        CarModelYearLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        CarModelYearLabel.setBounds(200,300,150,25);
        newLeaseMenu.add(CarModelYearLabel);
        //<-----------------------------------------Setting Car Model Year Label--------------------------------------->
        //<-----------------------------------------Setting Car Model Year TextField----------------------------------->
        carModelYearTextField = new JTextField("e.g. 2022");
        carModelYearTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        carModelYearTextField.setBounds(375,300,250,25);
        newLeaseMenu.add(carModelYearTextField);
        //<-----------------------------------------Setting Car Model Year TextField----------------------------------->



        //<-----------------------------------------Setting Lease Duration Label--------------------------------------->
        JLabel LeaseDurationLabel = new JLabel("Lease Duration:");
        LeaseDurationLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        LeaseDurationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        LeaseDurationLabel.setBounds(200,375,150,25);
        newLeaseMenu.add(LeaseDurationLabel);
        //<-----------------------------------------Setting Lease Duration Label--------------------------------------->
        //<-----------------------------------------Setting Lease Duration TextField----------------------------------->
        leaseDurationTextField = new JTextField("e.g. 4 months");
        leaseDurationTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        leaseDurationTextField.setBounds(375,375,250,25);
        newLeaseMenu.add(leaseDurationTextField);
        //<-----------------------------------------Setting Lease Duration TextField----------------------------------->



        //<-----------------------------------------Setting Continue Button-------------------------------------------->
        continueButton = new JButton();
        continueButton.setText("Continue");
        continueButton.setBackground(Color.lightGray);
        continueButton.setBounds(420,450,135,25);
        continueButton.setFocusable(false);
        continueButton.setFont(new Font("Arial", Font.BOLD, 16));
        continueButton.addActionListener(this);
        newLeaseMenu.add(continueButton);
        //<-----------------------------------------Setting Continue Button-------------------------------------------->


        //<-----------------------------------------Setting Cancel Button---------------------------------------------->
        cancelButton = new JButton();
        cancelButton.setText("Cancel");
        cancelButton.setBackground(Color.lightGray);
        cancelButton.setBounds(250,450,135,25);
        cancelButton.setFocusable(false);
        cancelButton.setFont(new Font("Arial", Font.BOLD, 16));
        cancelButton.addActionListener(this);
        newLeaseMenu.add(cancelButton);
        //<-----------------------------------------Setting Cancel Button---------------------------------------------->



        newLeaseMenu.setLocationRelativeTo(null);
        newLeaseMenu.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == leaseButton){
            createLease();
            mainMenu.setVisible(false);
        }
        else if(e.getSource() == displayButton){
            int i = 1;
            String message = "";
            for (Lease l : leaseList){
                message += "Lease #"+ i + "\n"
                        + l.getLeaseId() + "\n"
                        + l.getCarBrand() + "\n"
                        + l.getCarYear() + "\n"
                        + l.getCarYear() + "\n"
                        + l.getLeaseDuration() + " "
                        + l.getLeaseDurationType() + "\n";
                i++;
            }
            JOptionPane.showMessageDialog(mainMenu,message,"All Leases", JOptionPane.PLAIN_MESSAGE);
        }
        else if(e.getSource() == exitButton){
            System.exit(0);
        }
        if(e.getSource() == cancelButton){
            System.exit(0);
        }
        else if(e.getSource() == continueButton){
            Lease lease = new Lease();
            lease.setLeaseId(ownerIdTextField.getText());
            lease.getCar().setCarBrandModel(carModelTextField.getText());
            lease.getCar().setCarModelYear(Integer.parseInt(carModelYearTextField.getText()));
            String[] dummy = leaseDurationTextField.getText().split(" ");
            lease.setLeaseDuration(Integer.parseInt(dummy[0]));
            lease.setLeaseDurationType(dummy[1]);
            leaseList.add(lease);
            mainMenu.setVisible(true);
            newLeaseMenu.dispose();
        }
    }
}
