
package cs413assg3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author karunmehta, eiffelv
 */
public class HomePage extends JFrame implements ActionListener {
    
    JButton jbAll, jbAdd, jbRemove, jbUpdate;
    
    HomePage() {
    
        setLayout(null);
        
        //create icon you want on the frame
        ImageIcon iIcon = new ImageIcon(ClassLoader.getSystemResource("icons/emp.jpg"));
        Image anImage = iIcon.getImage().getScaledInstance(1000, 630, Image.SCALE_DEFAULT);
        ImageIcon iIcon2 = new ImageIcon(anImage);
        JLabel theLabel = new JLabel(iIcon2);
        theLabel.setBounds(0, 0, 1100,630);
        add(theLabel);
        
        JLabel heading = new JLabel("Customer Detail Update");
        heading.setBounds(100, 100, 400,40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        theLabel.add(heading);
        
        jbAll = new JButton("Show All Transactions");
        jbAll.setBounds(100, 200, 200,40);
        jbAll.addActionListener(this);
        theLabel.add(jbAll);
        
        jbAdd = new JButton("Create Transaction");
        jbAdd.setBounds(100, 250, 200,40);
        jbAdd.addActionListener(this);
        theLabel.add(jbAdd);

        jbUpdate = new JButton("Check Customer Data");
        jbUpdate.setBounds(100, 300, 200,40);
        jbUpdate.addActionListener(this);
        theLabel.add(jbUpdate);
        
        jbRemove = new JButton("Close Account");
        jbRemove.setBounds(100, 350, 200,40);
        jbRemove.addActionListener(this);
        theLabel.add(jbRemove);
        
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if((ae.getSource()) == jbAdd) { 
                new BankFrame();
        } else if((ae.getSource()) == jbAll) {
            JOptionPane.showMessageDialog(null, "Functionality to show All Transactions is WIP");
            this.setVisible(true);
        } else if((ae.getSource()) == jbUpdate) {
            JOptionPane.showMessageDialog(null, "Functionality to update an existing Customer is WIP");
            this.setVisible(true);
        } else if((ae.getSource()) == jbRemove){
            JOptionPane.showMessageDialog(null, "Functionality to close an existing Customer is WIP");
            this.setVisible(true);
            
        }
        
    }
    
    //This main method is not needed, unless you want to run this class by itself from your IDE to validate its look'n feel
    //This frame(window) will be called as a result of an action(click, select etc) from another widget on on another winhow during the GUI workflow
    public static void main(String[] args) {

        new HomePage();

    }
    
}
