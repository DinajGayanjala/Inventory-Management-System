
package infc.code;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
public class TestConnection {
    public static void main(String[] args) {
        testDatabase();
    }
    
    public static void testDatabase() {
        Connection conn = null;
        try {
         
            conn = dbconnect.connect();
            
            if (conn != null) {
             
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as total FROM appuser1");
                
                if (rs.next()) {
                    int rowCount = rs.getInt("total");
                    JOptionPane.showMessageDialog(null, 
                        "✅ Database Working Perfectly!\n" +
                        "Connection: Successful\n" +
                        "Table 'appuser1' exists\n" +
                        "Total records: " + rowCount);
                }
                
                rs.close();
                stmt.close();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Test failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
