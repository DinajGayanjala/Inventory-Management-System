
package infc.code;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnect 
{

    public static Connection connect() {
        Connection conn = null;
        
        try {
          
            Class.forName("com.mysql.cj.jdbc.Driver");
            
 
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/inventory?useSSL=false&serverTimezone=UTC", 
                "root", 
                ""
            );
            
           // JOptionPane.showMessageDialog(null, "✅ Database connected successfully!");
            
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "❌ MySQL Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Database connection failed: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Unexpected error: " + e.getMessage());
        }
        
        return conn;
    }


    public static Connection getCon() {
        return connect(); 
    }
}
