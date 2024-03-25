
package cs413assg3;

import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author karunmehta, eiffelv
 */
public class BankDTO {
    
    private int id;
    private String username;
    private String email;
    private String phone;
   
    static BankDAOConcrete ed = new BankDAOConcrete();

    public BankDTO() {
        

    }

    public BankDTO(int custID, String username, String email) {

        this.username = username;
        this.email = email;
        id = custID;
    }

    public BankDTO(String username, String email, String ph) {
        
        this.username = username;
        this.email = email;
        this.phone = ph;
    }    
    
    // Getter and Setter methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String ph) {
        this.phone = ph;
    }
    
    public int getID() {
        
        return id;
    }

    public void setID(int anID) {
        this.id = anID;
    }  
    
    public static Bank bankerByID(int anId) {
        
        Bank aCustomer = null;
        
        try {
            aCustomer = ed.get(anId);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        if(aCustomer != null) System.out.println(aCustomer.toString()); 
            
        System.out.println("\nFetched Customer with ID: " + anId + " Customer Details:\n" + aCustomer.toString());        
        return aCustomer;
        
    }
    
    public static int performUpdate(Bank aCustomer) {

        int updateResult = -1;
        
        try {
            updateResult = ed.update(aCustomer);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        
        if(updateResult != -1) System.out.println("\nUpdate Successful");
         System.out.println("Customer Details:\n" + aCustomer.toString());
        return updateResult;        
    }
    
    public static HashMap validateUser(String id) {
        
        return ed.validateLogin(id);
        
    }

    public static int performCreate(Bank aCustomer) {

        int updateResult = -1;
        
        
        
        try {
            updateResult = ed.save(aCustomer);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        
        if(updateResult != -1) System.out.println("\nCustomer Update Successful");
         System.out.println("Customer Details:\n" + aCustomer.toString());
        return updateResult;        
    }    
    
}
