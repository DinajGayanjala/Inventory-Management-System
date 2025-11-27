package infc;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import commen.openpdf;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import infc.code.dbconnect;
import infc.code.inventoryutils;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.PreparedStatement;
import java.util.Date;

public class mangeorder extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(mangeorder.class.getName());

    private int customerpk = 0;
    private int productpk = 0;
    private int finalTotalPrice = 0;
    private String orderid = "";

    public mangeorder() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void clearProductFields() {
        productpk = 0;
        pnbox.setText("");
        ppbox.setText("");
        pdbox.setText("");
        oqbox.setText("");
    }

    public String getUniqueId(String prefix) {
        return prefix + System.nanoTime();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        product = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        customer = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cart = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cnbox = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmnbox = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ebox = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pnbox = new javax.swing.JTextField();
        ppbox = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        pdbox = new javax.swing.JTextField();
        oqbox = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cartbox = new javax.swing.JButton();
        save = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        close = new javax.swing.JButton();
        tplb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 0));
        jLabel1.setText("Manage Lable");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 277, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Customer List");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 120, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Product List");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 110, -1));

        product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Description", "Category ID", "Category Name"
            }
        ));
        product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(product);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 360, 280));

        customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Mobile Name", "Email"
            }
        ));
        customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(customer);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 340, 270));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Cart");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 140, -1, -1));

        cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Quantity", "Price", "Description", "Sub Total"
            }
        ));
        cart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(cart);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 180, 360, 330));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Selected Customer :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Name");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, -1, -1));

        cnbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnboxActionPerformed(evt);
            }
        });
        getContentPane().add(cnbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 230, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Mobile Number ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, -1, -1));
        getContentPane().add(cmnbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, 230, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Email");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 720, -1, -1));
        getContentPane().add(ebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 750, 230, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Total Amount Rs :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 530, -1, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Select Product :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 480, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Product Name");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 520, -1, -1));
        getContentPane().add(pnbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 540, 230, -1));

        ppbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppboxActionPerformed(evt);
            }
        });
        getContentPane().add(ppbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 600, 230, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Product Price ");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 580, -1, -1));

        pdbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdboxActionPerformed(evt);
            }
        });
        getContentPane().add(pdbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 660, 230, -1));
        getContentPane().add(oqbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 720, 230, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Product Descriptin");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 640, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Order Quantity");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 700, -1, -1));

        cartbox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cartbox.setText("Add Cart");
        cartbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartboxActionPerformed(evt);
            }
        });
        getContentPane().add(cartbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 770, 230, -1));

        save.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        save.setText(" Save Order Details");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 580, 320, -1));

        reset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 650, 320, -1));

        close.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        close.setText("Close ");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 720, 320, -1));

        tplb.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tplb.setText("0000");
        getContentPane().add(tplb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 540, 60, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        cnbox.setEditable(false);
        cmnbox.setEditable(false);
        ebox.setEditable(false);

        pnbox.setEditable(false);
        ppbox.setEditable(false);
        pdbox.setEditable(false);

        DefaultTableModel customerModel = (DefaultTableModel) customer.getModel();
        DefaultTableModel productModel = (DefaultTableModel) product.getModel();

        try {
            Connection conn = dbconnect.getCon();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM customer");
            while (rs.next()) {
                customerModel.addRow(new Object[]{
                    rs.getString("customer_pk"),
                    rs.getString("name"),
                    rs.getString("mobilenumber"),
                    rs.getString("email")
                });
            }

            rs = st.executeQuery("SELECT * FROM product INNER JOIN category ON product.category_fk = category.category_pk");
            while (rs.next()) {
                productModel.addRow(new Object[]{
                    rs.getString("product_pk"),
                    rs.getString("name"),
                    rs.getString("price"),
                    rs.getString("quantity"),
                    rs.getString("description"),
                    rs.getString("category_fk"),
                    rs.getString(8)
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_formComponentShown

    private void cnboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnboxActionPerformed

    private void ppboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ppboxActionPerformed

    private void pdboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pdboxActionPerformed

    private void cartboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartboxActionPerformed
        String noOfUnits = oqbox.getText();
        if (!noOfUnits.equals("")) {
            String productname = pnbox.getText();
            String productprice = ppbox.getText();
            String productdescription = pdbox.getText();

            int totalprice = Integer.parseInt(oqbox.getText()) * Integer.parseInt(productprice);

            int checkStock = 0;
            int checkProductAlreadyExistInCart = 0;

            try {
                Connection conn = dbconnect.getCon();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select * from product where product_pk=" + productpk + "");
                while (rs.next()) {
                    if (rs.getInt("quantity") >= Integer.parseInt(noOfUnits)) {
                        checkStock = 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "product is out of stock. only" + rs.getInt("quantity") + "left");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            if (checkStock == 1) {
                DefaultTableModel model = (DefaultTableModel) cart.getModel();
                if (cart.getRowCount() != 1) {
                    for (int i = 0; i < cart.getRowCount(); i++) {
                        if (Integer.parseInt(model.getValueAt(i, 0).toString()) == productpk) {
                            checkProductAlreadyExistInCart = 1;
                            JOptionPane.showMessageDialog(null, "product already exist in cart");

                        }
                    }
                }
                if (checkProductAlreadyExistInCart == 0) {
                    model.addRow(new Object[]{productpk, productname, noOfUnits, productprice, productdescription, totalprice});
                    finalTotalPrice = finalTotalPrice + totalprice;
                    tplb.setText(String.valueOf(finalTotalPrice));
                    JOptionPane.showMessageDialog(null, "added successfully");
                }
                clearProductFields();

            }
        } else {
            JOptionPane.showMessageDialog(null, "no of quantity and product field is required");
        }
    }//GEN-LAST:event_cartboxActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if (finalTotalPrice != 0 && !cnbox.getText().equals("")) {
            orderid = getUniqueId("Bill-");

            DefaultTableModel dtm = (DefaultTableModel) cart.getModel();
            if (cart.getRowCount() != 0) {
                for (int i = 0; i < cart.getRowCount(); i++) {
                    try {
                        Connection conn = dbconnect.getCon();
                        Statement st = conn.createStatement();
                        st.executeUpdate("update product set quantity= quantity-" + Integer.parseInt(dtm.getValueAt(i, 2).toString()) + " where product_pk=" + Integer.parseInt(dtm.getValueAt(i, 0).toString()));

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
        try {
    SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
    Calendar cal = Calendar.getInstance();

    Connection conn = dbconnect.connect();  // or your correct method

    PreparedStatement ps = conn.prepareStatement(
        "INSERT INTO orderdetail(orderid, customer_fk, orderdate, totalpaid) VALUES (?, ?, ?, ?)"
    );

    ps.setString(1, orderid);
    ps.setInt(2, customerpk);
    ps.setString(3, myFormat.format(cal.getTime()));
    ps.setInt(4, finalTotalPrice);

    ps.executeUpdate();

}  catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
          // **************************************************
          
             com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            try {
                 SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                 Calendar cal = Calendar.getInstance();
                 PdfWriter.getInstance(doc, new FileOutputStream(inventoryutils.billpath+""+orderid+".pdf"));
                 doc.open();
                 Paragraph projectname = new Paragraph("                                                 Inventory Manegement System\n");
                 doc.add(projectname);
                 Paragraph starLine = new Paragraph("****************************************************************************************************************");
                  System.out.println("");
                  System.out.println("");
                 doc.add(starLine);
                 Paragraph details = new  Paragraph("\tOrder ID :" + orderid+ "\nDate : "+ myFormat.format(cal.getTime())+"\nTotal Paid : "+finalTotalPrice);
                 doc.add(details);
                 doc.add(starLine);
                  System.out.println("");
                  System.out.println("");
                 PdfPTable tb1 = new PdfPTable(5);
                 PdfPCell nameCell = new PdfPCell(new Phrase("Name"));
                 PdfPCell descriptionCell = new PdfPCell(new Phrase("Description"));
                 PdfPCell priceCell = new PdfPCell(new Phrase("Price per Unit"));
                 PdfPCell quantityCell = new PdfPCell(new Phrase("Quantity"));
                 PdfPCell subtotalpriceCell = new PdfPCell(new Phrase("Sub Toatal Price"));
                 
                 BaseColor backbgroundColor = new BaseColor(255,204,51);
                 nameCell.setBackgroundColor(backbgroundColor);
                 descriptionCell.setBackgroundColor(backbgroundColor);
                 priceCell.setBackgroundColor(backbgroundColor); 
                 quantityCell.setBackgroundColor(backbgroundColor);
                 subtotalpriceCell.setBackgroundColor(backbgroundColor);
                 
                 tb1.addCell(nameCell);
                 tb1.addCell(descriptionCell);
                 tb1.addCell(priceCell);
                 tb1.addCell(quantityCell);
                 tb1.addCell(subtotalpriceCell);
                 
                 for(int i=0; i<cart.getRowCount();i++)
                 {
                  tb1.addCell(cart.getValueAt(i,1).toString());
                  tb1.addCell(cart.getValueAt(i,4).toString());
                  tb1.addCell(cart.getValueAt(i,3).toString());
                  tb1.addCell(cart.getValueAt(i,2).toString());
                  tb1.addCell(cart.getValueAt(i,5).toString());
                   
                 }
                 doc.add(tb1);
                 doc.add(starLine);
                 Paragraph thankMsg = new Paragraph("Thank you, Please Visit Again");
                 doc.add(thankMsg);
                 openpdf.openById(orderid);
                 
                 
                 
                        
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            doc.close();
            setVisible(false);
            new mangeorder().setVisible(true);
        }
        else
        {
         JOptionPane.showMessageDialog(null, "please add some product to cart or select customer");
        }
    }//GEN-LAST:event_saveActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed

        setVisible(false);
        new mangeorder().setVisible(true);
    }//GEN-LAST:event_resetActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        setVisible(false);
    }//GEN-LAST:event_closeActionPerformed

    private void customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMouseClicked
        int index = customer.getSelectedRow();
        TableModel model = customer.getModel();

        String id = model.getValueAt(index, 0).toString();
        customerpk = Integer.parseInt(id);

        cnbox.setText(model.getValueAt(index, 1).toString());
        cmnbox.setText(model.getValueAt(index, 2).toString());
        ebox.setText(model.getValueAt(index, 3).toString());
    }//GEN-LAST:event_customerMouseClicked

    private void productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productMouseClicked
        int index = product.getSelectedRow();
        TableModel model = product.getModel();

        productpk = Integer.parseInt(model.getValueAt(index, 0).toString());
        pnbox.setText(model.getValueAt(index, 1).toString());
        ppbox.setText(model.getValueAt(index, 2).toString());
        pdbox.setText(model.getValueAt(index, 4).toString());
    }//GEN-LAST:event_productMouseClicked

    private void cartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartMouseClicked
        int index = cart.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do You wangt to remove this product ", "selected", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            TableModel model = cart.getModel();
            String total = model.getValueAt(index, 5).toString();
            tplb.setText(String.valueOf(finalTotalPrice));
            ((DefaultTableModel) cart.getModel()).removeRow(index);

        }
    }//GEN-LAST:event_cartMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new mangeorder().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cart;
    private javax.swing.JButton cartbox;
    private javax.swing.JButton close;
    private javax.swing.JTextField cmnbox;
    private javax.swing.JTextField cnbox;
    private javax.swing.JTable customer;
    private javax.swing.JTextField ebox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField oqbox;
    private javax.swing.JTextField pdbox;
    private javax.swing.JTextField pnbox;
    private javax.swing.JTextField ppbox;
    private javax.swing.JTable product;
    private javax.swing.JButton reset;
    private javax.swing.JButton save;
    private javax.swing.JLabel tplb;
    // End of variables declaration//GEN-END:variables
}
