/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs413assg3;

/**
 *
 * @author karunmehta, eiffelv
 */
public class Bank {
    
   private String username;
   private String email;
   private String phone;
   private char sex;
   private String birthday;
   private String department;
   private int id;

    public Bank() {
        // Default constructor
    }

    public Bank(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Bank(int identity, String username, String email, String ph) {
        this.username = username;
        this.email = email;
        this.phone = ph;
        this.id = identity;
    }
    
    public void getEmployee(int i) {
        
        BankDTO custDTO = buildDTO(this.getID(), this.getUsername(), this.getEmail());
               
        this.setID(custDTO.getID());
        this.setUsername(custDTO.getUsername());
        this.setEmail(custDTO.getEmail());

    }
    
    public static BankDTO buildDTO(int custID, String name, String email) {
        
        BankDTO theDTO = new BankDTO(custID, name, email);
        return theDTO;
        
    }
    

    // Getter and Setter methods
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String dept) {
        this.department = dept;
    }    
    
    public int getID() {
        return id;
    }

    public void setID(int idNum) {
        this.id = idNum;
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

    public void setSex(char aChar) {
        this.sex = aChar;
    }

    public int getSex() {
        return sex;
    }
    
     public void setBirthday(String b) {
        this.birthday = b;
    }

    public String getBirthday() {
        return birthday;
    }
    
    @Override
    public String toString() {
        
        String empString = "Employee:" + " ID-" + this.getID() + ", " + " Name-" + this.getUsername() + ", " + "Email-" + this.getEmail() + ", " + "Phone-" + this.getPhone();
        return empString;
    }
    
}
