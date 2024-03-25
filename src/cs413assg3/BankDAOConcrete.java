
package cs413assg3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author karunmehta, eiffelv
 */
class BankDAOConcrete implements BankDAO {
 
    static Connection connection = null;
    PreparedStatement pStatement;
    ResultSet result;
    
    BankDAOConcrete() {

        try {

            connection = BankDataConnection.getDBConnection();           

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }        

    }
    
    public static Connection getConnection() {
        
        if(connection == null) {
            try {

                connection = BankDataConnection.getDBConnection();           

            } catch (SQLException se) {
                System.out.println(se.getMessage());
            }               
        }
        
        return connection;
    }
            
    
    // Method to disconnect from the database
    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // Method to insert a user into the database
    @Override
    public int insert(Bank cust) throws SQLException {
        
        int res = -1;
        pStatement = connection.prepareStatement(BankDataConnection.getInsert());
        pStatement.setString(1, cust.getUsername());
        pStatement.setString(2, cust.getEmail());
        res = pStatement.executeUpdate();
        disconnect();
        
        return res;
    }

    // Method to retrieve a user from the database by ID
    @Override
    public Bank get(int anID) throws SQLException {

        pStatement = connection.prepareStatement(BankDataConnection.getSelect());
        pStatement.setInt(1,anID);
        result = pStatement.executeQuery();
        
        Bank updatedEmp = null;
        if (result.next()) {
            Bank e = new Bank();
            updatedEmp = new Bank( result.getInt("id"), result.getString("username"), result.getString("email"), result.getString("phone"));
        }

        return updatedEmp;
    }

    // Method to update a user in the database
    @Override
    public int update(Bank cust) throws SQLException {
        
        int result = -1;
        
        pStatement = connection.prepareStatement(BankDataConnection.getUpdate());
        pStatement.setString(1, cust.getUsername());
        pStatement.setString(2, cust.getEmail());
        pStatement.setString(3, cust.getPhone());
        pStatement.setInt(4, cust.getID());
        result = pStatement.executeUpdate();
        
        return result;
    }

    // Method to delete a user from the database
    @Override
    public int delete(Bank cust) throws SQLException {
        
        int res = -1;
        
        pStatement = connection.prepareStatement(BankDataConnection.getDelete());
        pStatement.setInt(1,cust.getID());
        res = pStatement.executeUpdate();
        
        return res;
    }  

    // Method to update a user in the database
    @Override
    public int save(Bank cust) throws SQLException {
        
        int res = -1;
        
        String nameStr = cust.getUsername();
        String[] strArr = nameStr.split(" ");
        pStatement = connection.prepareStatement(BankDataConnection.getInsert());
        pStatement.setString(1, strArr[0]);
        pStatement.setString(2, strArr[1]);
        pStatement.setString(3, cust.getEmail());
        pStatement.setString(4, cust.getPhone());
        pStatement.setString(5, cust.getDepartment());
        res = pStatement.executeUpdate();

        return res;
    }
    
    public HashMap validateLogin(String id) {
        
        HashMap hm = null;
        
        try {
            
            pStatement = connection.prepareStatement(BankDataConnection.getAdmin());
            pStatement.setString(1, id);
            result = pStatement.executeQuery();
            
            if (result.next()) {
                hm = new HashMap();
                hm.put("ID", result.getString("userid"));
                hm.put("PWD", result.getString("pwd"));
            }
            
        } catch( Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage() + " Try again..");
        }
        
        return hm;
    }
    
}
