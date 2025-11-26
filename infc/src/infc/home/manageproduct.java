
package infc;


import infc.code.dbconnect;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import com.mysql.cj.xdevapi.Result;
import java.sql.PreparedStatement;
import javax.swing.table.TableModel;


public class manageproduct extends javax.swing.JFrame {
    private int productpk= 0;
    private int totalquantity = 0;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(manageproduct.class.getName());

    
    public manageproduct() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    private void debugDatabaseContents() {
    try {
        Connection conn = dbconnect.getCon();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM product");
        
        System.out.println("=== DEBUG: Database Contents ===");
        while (rs.next()) {
            System.out.println("ID: " + rs.getString("product_pk") + 
                             ", Name: " + rs.getString("name") +
                             ", Quantity: " + rs.getString("quantity") +
                             ", Price: " + rs.getString("price") +
                             ", Desc: " + rs.getString("description") +
                             ", Category FK: " + rs.getString("category_fk"));
        }
        System.out.println("=== END DEBUG ===");
        conn.close();
    } catch(Exception e) {
        e.printStackTrace();
    }
}
    

   private void getAllCategory()
 {
    try {
        Connection conn = dbconnect.getCon();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM category");

        cbox.removeAllItems();   

        while (rs.next()) {
           
            cbox.addItem(rs.getString("category_pk") + "-" + rs.getString("name"));
        }
        conn.close();
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
   }
   private boolean validateFields(String formType)
   {
   if (formType.equals("edit") && !nbox.getText().equals("") && !pbox.getText().equals("") && !dbox.getText().equals(""))
    {
        return false ;
        
    }
   else if(formType.equals("new") && !nbox.getText().equals("") && !pbox.getText().equals("") && !dbox.getText().equals("") && !qbox.getText().equals("") )
   {
    return false;
   }
   else
       return true;
   
   }
    @SuppressWarnings("unchecked")


    private void nboxActionPerformed(java.awt.event.ActionEvent evt) {
       
    }

    private void qboxActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {
    String name = nbox.getText().trim();
    String quantityStr = qbox.getText().trim(); 
    String priceStr = pbox.getText().trim();    
    String description = dbox.getText().trim();
    String category = (String) cbox.getSelectedItem();
    
    if (category == null) {
        JOptionPane.showMessageDialog(null, "Please select a category");
        return;
    }
    
    String categoryId[] = category.split("-");

    if (validateFields("new")) {  
        JOptionPane.showMessageDialog(null, "All fields are required");
        return;
    }

    try {
        Connection conn = dbconnect.getCon();
        PreparedStatement ps = conn.prepareStatement(
            "INSERT INTO product (name, quantity, price, description, category_fk) VALUES (?, ?, ?, ?, ?)"
        );

        ps.setString(1, name);
        
        int quantity;
        if (quantityStr.isEmpty() || quantityStr.equalsIgnoreCase("null")) {
            quantity = 0;
        } else {
            quantity = Integer.parseInt(quantityStr);
        }
        ps.setInt(2, quantity);

        double price;
        if (priceStr.isEmpty() || priceStr.equalsIgnoreCase("null")) {
            price = 0.0; 
        } else {
            price = Double.parseDouble(priceStr);
        }
        ps.setDouble(3, price);

        ps.setString(4, description); 
        ps.setInt(5, Integer.parseInt(categoryId[0]));

        int rows = ps.executeUpdate();
        System.out.println("DEBUG - Inserted " + rows + " row(s)"); 

        JOptionPane.showMessageDialog(null, "Product added successfully!");
        
        
        formComponentShown(null);
        
       
        nbox.setText("");
        qbox.setText("");
        pbox.setText("");
        dbox.setText("");
        cbox.setSelectedIndex(0);
        
    } catch(NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Please enter valid numbers for Quantity and Price");
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        e.printStackTrace();
    }
    }

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {
      setVisible(false);
      new manageproduct().setVisible(true);
    }

    private void cboxActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void formComponentShown(java.awt.event.ComponentEvent evt) {
       getAllCategory();
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0); 

    try {
        Connection conn = dbconnect.getCon();
        Statement st = conn.createStatement();

        String query = "SELECT p.product_pk, p.name, p.quantity, p.price, p.description, " +
                      "c.category_pk as category_id, c.name as category_name " +
                      "FROM product p INNER JOIN category c ON p.category_fk = c.category_pk";

        System.out.println("DEBUG - Executing query: " + query); 
        
        ResultSet rs = st.executeQuery(query);

        int rowCount = 0;
        while (rs.next()) {
            rowCount++;
      
            model.addRow(new Object[] {
                rs.getString("product_pk"),
                rs.getString("name"),
                rs.getString("quantity"),
                rs.getString("price"),
                rs.getString("description"), 
                rs.getString("category_id"), 
                rs.getString("category_name") 
            });
        }
        
        System.out.println("DEBUG - Loaded " + rowCount + " rows into table"); 
        conn.close();
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, "Error loading products: " + e.getMessage());
        e.printStackTrace();
    }
   
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {
int index = table.getSelectedRow();
    TableModel model = table.getModel();
    
    
    String id = model.getValueAt(index, 0).toString();
    productpk = Integer.parseInt(id);
    
  
    String name = model.getValueAt(index, 1).toString();
    nbox.setText(name);
    
   
    String quantity = model.getValueAt(index, 2).toString();
    qbox.setText(quantity); 
    totalquantity = Integer.parseInt(quantity);
    quantity1.setText("Add Quantity");
    
    
    String price = model.getValueAt(index, 3).toString();
    pbox.setText(price);
    
   
    String description = model.getValueAt(index, 4).toString();
    dbox.setText(description); 
    

    cbox.removeAllItems();
    String categoryid = model.getValueAt(index, 5).toString();
    String categoryname = model.getValueAt(index, 6).toString();
    cbox.addItem(categoryid + "-" + categoryname);
    
    try {
        Connection conn = dbconnect.getCon();
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("SELECT * FROM category");
        
        while (rs.next()) {
            if(Integer.parseInt(categoryid) != rs.getInt("category_pk")) {
                cbox.addItem(rs.getString("category_pk") + "-" + rs.getString("name"));
            }
        }
        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error loading categories: " + e.getMessage());
        e.printStackTrace();
    }
    
    save.setEnabled(false);
    update.setEnabled(true);
     
    }

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {
    String name = nbox.getText().trim();
    String quantityStr = qbox.getText().trim(); 
    String priceStr = pbox.getText().trim();    
    String description = dbox.getText().trim();
    String category = (String) cbox.getSelectedItem();
    
    if (category == null) {
        JOptionPane.showMessageDialog(null, "Please select a category");
        return;
    }
    
    String categoryId[] = category.split("-");

    if (validateFields("edit")) {  
        JOptionPane.showMessageDialog(null, "All fields are required");
        return;
    }

    try {
        if(!quantityStr.equals(""))
        {
         totalquantity = totalquantity + Integer.parseInt(quantityStr);
        }
        Connection conn = dbconnect.getCon();
        PreparedStatement ps = conn.prepareStatement("update product set name= ?,quantity=?,price=?,description=?,category_fk=? where product_pk=?");

        ps.setString(1, name);
        
        int quantity;
        if (quantityStr.isEmpty() || quantityStr.equalsIgnoreCase("null")) {
            quantity = 0;
        } else {
            quantity = Integer.parseInt(quantityStr);
        }
        ps.setInt(2, totalquantity);

        double price;
        if (priceStr.isEmpty() || priceStr.equalsIgnoreCase("null")) {
            price = 0.0; 
        } else {
            price = Double.parseDouble(priceStr);
        }
        ps.setDouble(3, price);

        ps.setString(4, description);
        ps.setInt(5, Integer.parseInt(categoryId[0]));
        ps.setInt(6,productpk);

        int rows = ps.executeUpdate();
        System.out.println("DEBUG - Inserted " + rows + " row(s)"); 

        JOptionPane.showMessageDialog(null, "Product update successfully!");
        
       
        formComponentShown(null);
        

        nbox.setText("");
        qbox.setText("");
        pbox.setText("");
        dbox.setText("");
        cbox.setSelectedIndex(0);
        
    } catch(NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Please enter valid numbers for Quantity and Price");
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        e.printStackTrace();
    }
    }

   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> new manageproduct().setVisible(true));
    }

    
    private javax.swing.JComboBox<String> cbox;
    private javax.swing.JButton close;
    private javax.swing.JTextField dbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nbox;
    private javax.swing.JTextField pbox;
    private javax.swing.JTextField qbox;
    private javax.swing.JLabel quantity1;
    private javax.swing.JButton reset;
    private javax.swing.JButton save;
    private javax.swing.JTable table;
    private javax.swing.JButton update;
   
}
