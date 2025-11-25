package infc.code;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class table {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;

        try {
            // Connect DB
            con = dbconnect.connect();

            if (con == null) {
                JOptionPane.showMessageDialog(null, "❌ Database connection failed!");
                return;
            }

            st = con.createStatement();

            // ------------------------------------------------
            // 1. CATEGORY TABLE
            // ------------------------------------------------
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS category (" +
                "category_pk INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(200) NOT NULL" +
                ")"
            );

            // ------------------------------------------------
            // 2. CUSTOMER TABLE
            // ------------------------------------------------
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS customer (" +
                "customer_pk INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(200) NOT NULL, " +
                "mobilenumber VARCHAR(50), " +
                "email VARCHAR(200)" +
                ")"
            );

            // ------------------------------------------------
            // 3. ORDER DETAIL TABLE (Used in vieworder.java)
            // ------------------------------------------------
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS orderdetail (" +
                "orderid INT AUTO_INCREMENT PRIMARY KEY, " +
                "orderdate DATE NOT NULL, " +
                "totalpaid DECIMAL(10,2) NOT NULL, " +
                "customer_fk INT, " +
                "FOREIGN KEY (customer_fk) REFERENCES customer(customer_pk)" +
                ")"
            );

            // ------------------------------------------------
            // 4. PRODUCT TABLE
            // ------------------------------------------------
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS product (" +
                "product_pk INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(200), " +
                "quantity INT, " +
                "price DECIMAL(10,2), " +
                "description VARCHAR(500), " +
                "category_fk INT, " +
                "FOREIGN KEY (category_fk) REFERENCES category(category_pk)" +
                ")"
            );

            // ------------------------------------------------
            // 5. APPUSER TABLE
            // ------------------------------------------------
            String createTableSQL =
                "CREATE TABLE IF NOT EXISTS appuser1 (" +
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

            st.executeUpdate(createTableSQL);
            System.out.println("✅ Table 'appuser1' created successfully!");

            // ------------------------------------------------
            // 6. INSERT SUPER ADMIN (only if not exists)
            // ------------------------------------------------
            String insertSQL =
                "INSERT INTO appuser1 (userRole, name, mobileNumber, email, password, address, status) " +
                "VALUES ('Admin', 'Super Admin', '1234567890', 'admin@shop.com', 'admin123', 'System Data', 'Active')";

            st.executeUpdate(insertSQL);
            System.out.println("✅ SuperAdmin user inserted successfully!");

            JOptionPane.showMessageDialog(
                null,
                "🎉 DATABASE SETUP COMPLETED!\n\n" +
                "✓ category table created\n" +
                "✓ customer table created\n" +
                "✓ orderdetail table created\n" +
                "✓ product table created\n" +
                "✓ appuser1 table created\n" +
                "✓ Super Admin user inserted"
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
                System.out.println("🔒 Connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}