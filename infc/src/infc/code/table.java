
package infc.code;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class table 
{
   public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        
        try {
           
            con = dbconnect.connect();
            
            if (con == null) {
                JOptionPane.showMessageDialog(null, "❌ Database connection failed!");
                return;
            }
            
            st = con.createStatement();
            
            
            String createTableSQL = "CREATE TABLE IF NOT EXISTS appuser1 (" +
                    "appuser_pk INT AUTO_INCREMENT PRIMARY KEY, " +
                    "userRole VARCHAR(50) NOT NULL, " +
                    "name VARCHAR(200) NOT NULL, " +
                    "mobileNumber VARCHAR(15), " +
                    "email VARCHAR(100) UNIQUE, " +
                    "password VARCHAR(255) NOT NULL, " +
                    "address TEXT, " +
                    "status VARCHAR(50) DEFAULT 'Active', " +
                    "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                    ")";
            
          // st.executeUpdate("create table category(category_pk int AUTO_INCREMENT primary key , name varchar(200)) ");
                  //    st.executeUpdate("create table customer(customer_pk int AUTO_INCREMENT primary key , name varchar(200),mobilenumber varchar(50),email varchar(200)");
            
                   st.executeUpdate(
    "CREATE TABLE IF NOT EXISTS orderdetail(" +
    "order_pk INT AUTO_INCREMENT PRIMARY KEY, " +
    "orderid VARCHAR(200), " +
    "customer_fk INT, " +
    "orderdate VARCHAR(200), " +
    "totalpaid INT" +
    ")"
);
                  
            st.executeUpdate(createTableSQL);
           System.out.println("✅ Table 'appuser' created successfully!");
            
           
            String insertSQL = "INSERT INTO appuser1 (userRole, name, mobileNumber, email, password, address, status) " +
                    "VALUES ('rAdmin', 'Super Admin', '1234567890', 'dinaj5@.com', 'dinaj123', 'System Address', 'Active')";
            
            st.executeUpdate(insertSQL);
            System.out.println("✅ SuperAdmin user inserted successfully!");
            
         st.executeUpdate(
    "CREATE TABLE product (" +
    "product_pk INT AUTO_INCREMENT PRIMARY KEY, " +
    "name VARCHAR(200), " +
    "quantity INT, " +
    "price INT, " +
    "description VARCHAR(500), " +
    "category_fk INT" +
    ")");
          
            JOptionPane.showMessageDialog(null, "✅ Database Setup Complete!\n\n" +
                "✓ Table created successfully\n" +
                "✓ SuperAdmin user added\n" +
                "✓ All columns defined properly");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
         
            try {
                if (st != null) st.close();
                if (con != null) con.close();
                System.out.println("✅ Resources closed successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
