
package cs413assg3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CS413Assignment3 extends JFrame {
    
    private JTextField custID, custName, custPhone, custEmail;

    public CS413Assignment3() {
        setTitle("Customer Update Form");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2));

        JLabel custNameLabel = new JLabel("Customer Name:");
        custName = new JTextField();
        JLabel custEmailLabel = new JLabel("Customer Email:");
        custEmail = new JTextField();
        JLabel custPhoneLabel = new JLabel("Customer Phone:");
        custPhone = new JTextField();
        JLabel custIDLabel = new JLabel("Customer ID:");
        custID = new JTextField();        

        panel.add(custIDLabel);
        panel.add(custID);
        panel.add(custNameLabel);
        panel.add(custName);
        panel.add(custEmailLabel);
        panel.add(custEmail);
        panel.add(custPhoneLabel);
        panel.add(custPhone);

        JButton submitButton = new JButton("Submit");

        //Using Lambda fundtion for the ActionEvent. This creates a new custloyee based on the 
        // data provided in the textfields of the panel 
        submitButton.addActionListener((ActionEvent e) -> {
            int id = Integer.parseInt(custID.getText());
            String name = custName.getText();
            String ph = custPhone.getText();
            String em = custEmail.getText();
            
            // Create an Customer object
            
            Bank anCustomer = new Bank(id, name, em, ph);
            // Print or do something with the BankAccount object
            System.out.println("Details of the Customer: " + anCustomer);
        });
        panel.add(submitButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        
        createDemoCustomerObjects();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CS413Assignment3();
            }
        });
    }
    
    private static void createDemoCustomerObjects() {
        
    }
    
    public void createDcustCustomerObjects() {
        
        Bank cust1 = new Bank(44, "John Doe", "johndoe@sfsu.edu", "615.555.1212");
        Bank cust2 = new Bank(71,"Jane Deo", "janedoe@sfsu.edu","615.555.1212");
        Bank cust3 = new Bank(88,"Sam Doe", "johndoe@sfsu.edu", "615.555.1212");
        Bank cust4 = new Bank(22,"April Doe", "janedoe@sfsu.edu", "615.555.1212");
        
    }
}

