
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
            // Use the correct primary key column name
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        nbox = new javax.swing.JTextField();
        quantity1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        qbox = new javax.swing.JTextField();
        pbox = new javax.swing.JTextField();
        dbox = new javax.swing.JTextField();
        cbox = new javax.swing.JComboBox<>();
        save = new javax.swing.JButton();
        update = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Manage Product");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 0, 316, 71));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Quantity", "Price", "Description", "Category ID", "Category Name"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 510, 520));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 100, 30));

        nbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nboxActionPerformed(evt);
            }
        });
        getContentPane().add(nbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 180, -1));

        quantity1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        quantity1.setText("Quantity");
        getContentPane().add(quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Price");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Description");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Category");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, -1, -1));

        qbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qboxActionPerformed(evt);
            }
        });
        getContentPane().add(qbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 180, -1));
        getContentPane().add(pbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 180, -1));
        getContentPane().add(dbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, 180, 20));

        cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "test1", "test", "Item 3", "Item 4" }));
        cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxActionPerformed(evt);
            }
        });
        getContentPane().add(cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 210, -1));

        save.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 560, -1, -1));

        update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 560, -1, -1));

        reset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 560, -1, -1));

        close.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 560, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nboxActionPerformed
       
    }//GEN-LAST:event_nboxActionPerformed

    private void qboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qboxActionPerformed
        
    }//GEN-LAST:event_qboxActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
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

        ps.setString(4, description); // Parameter 4 - description
        ps.setInt(5, Integer.parseInt(categoryId[0])); // Parameter 5 - category_fk

        int rows = ps.executeUpdate();
        System.out.println("DEBUG - Inserted " + rows + " row(s)"); // Debug line

        JOptionPane.showMessageDialog(null, "Product added successfully!");
        
        // Refresh the table data without closing the form
        formComponentShown(null);
        
        // Clear form fields
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
    }//GEN-LAST:event_saveActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
    setVisible(false);
    }//GEN-LAST:event_closeActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
      setVisible(false);
      new manageproduct().setVisible(true);
    }//GEN-LAST:event_resetActionPerformed

    private void cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxActionPerformed
     
    }//GEN-LAST:event_cboxActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       getAllCategory();
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0); // Clear existing data

    try {
        Connection conn = dbconnect.getCon();
        Statement st = conn.createStatement();

        // Fixed query - select all necessary columns and join properly
        String query = "SELECT p.product_pk, p.name, p.quantity, p.price, p.description, " +
                      "c.category_pk as category_id, c.name as category_name " +
                      "FROM product p INNER JOIN category c ON p.category_fk = c.category_pk";

        System.out.println("DEBUG - Executing query: " + query); // Debug line
        
        ResultSet rs = st.executeQuery(query);

        int rowCount = 0;
        while (rs.next()) {
            rowCount++;
            // Add data to table - make sure order matches your column headers
            model.addRow(new Object[] {
                rs.getString("product_pk"),
                rs.getString("name"),
                rs.getString("quantity"),
                rs.getString("price"),
                rs.getString("description"), // Fixed: description should be 4th column
                rs.getString("category_id"), // 5th column: Category ID
                rs.getString("category_name") // 6th column: Category Name
            });
        }
        
        System.out.println("DEBUG - Loaded " + rowCount + " rows into table"); // Debug line
        conn.close();
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, "Error loading products: " + e.getMessage());
        e.printStackTrace(); // This will show the exact error
    }
   // save.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
int index = table.getSelectedRow();
    TableModel model = table.getModel();
    
    // Get product ID
    String id = model.getValueAt(index, 0).toString();
    productpk = Integer.parseInt(id);
    
    // Set Name
    String name = model.getValueAt(index, 1).toString();
    nbox.setText(name);
    
    // Set Quantity - FIXED: Use qbox instead of just storing the value
    String quantity = model.getValueAt(index, 2).toString();
    qbox.setText(quantity); // This line was missing!
    totalquantity = Integer.parseInt(quantity);
    quantity1.setText("Add Quantity");
    
    // Set Price - FIXED: Use pbox instead of nbox
    String price = model.getValueAt(index, 3).toString();
    pbox.setText(price); // This was incorrectly set to nbox
    
    // Set Description - FIXED: Use dbox instead of nbox
    String description = model.getValueAt(index, 4).toString();
    dbox.setText(description); // This was incorrectly set to nbox
    
    // Handle Category
    cbox.removeAllItems();
    String categoryid = model.getValueAt(index, 5).toString();
    String categoryname = model.getValueAt(index, 6).toString();
    cbox.addItem(categoryid + "-" + categoryname);
    
    try {
        Connection conn = dbconnect.getCon();
        Statement st = conn.createStatement();
        // FIXED: Query should be for category table, not product table
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
     
    }//GEN-LAST:event_tableMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
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
    }//GEN-LAST:event_updateActionPerformed

   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> new manageproduct().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    // End of variables declaration//GEN-END:variables
}
