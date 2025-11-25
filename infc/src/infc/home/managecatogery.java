
package infc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import infc.code.dbconnect;
import java.sql.PreparedStatement;
import javax.swing.table.TableModel;



public class managecatogery extends javax.swing.JFrame {
    
    private int categorypk =0;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(managecatogery.class.getName());

  
    public managecatogery() {
        initComponents();
        setLocationRelativeTo(null);
    }
    private boolean validateFields()
    {
      if(!nbox.getText().equals(""))
      {
       return false;
      }
      else
      {
          return true;
      }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ctable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        sbox = new javax.swing.JButton();
        rbox = new javax.swing.JButton();
        ubox = new javax.swing.JButton();
        cbox = new javax.swing.JButton();
        nbox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 0));
        jLabel2.setText("MANGE CATOGERY");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 338, 96));

        ctable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ));
        ctable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ctableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ctable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, 460));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 0));
        jLabel1.setText("Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, 120, 50));

        sbox.setBackground(new java.awt.Color(102, 255, 0));
        sbox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sbox.setText("Save");
        sbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sboxActionPerformed(evt);
            }
        });
        getContentPane().add(sbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, -1, 30));

        rbox.setBackground(new java.awt.Color(102, 255, 0));
        rbox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rbox.setText("Reset");
        getContentPane().add(rbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 330, -1, 30));

        ubox.setBackground(new java.awt.Color(102, 255, 0));
        ubox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ubox.setText("Update");
        ubox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uboxActionPerformed(evt);
            }
        });
        getContentPane().add(ubox, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 330, -1, 30));

        cbox.setBackground(new java.awt.Color(102, 255, 0));
        cbox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbox.setText("Close");
        cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxActionPerformed(evt);
            }
        });
        getContentPane().add(cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 330, -1, 30));

        nbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nboxActionPerformed(evt);
            }
        });
        getContentPane().add(nbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 260, 290, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/infc/2.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -30, 1460, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
      DefaultTableModel model = (DefaultTableModel) ctable.getModel();
    model.setRowCount(0); 

    try {
        Connection conn = (Connection) dbconnect.getCon(); 
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM category");

     while (rs.next()) {
    model.addRow(new Object[]{
        rs.getString("category_pk"), // ✅ correct
        rs.getString("name")
    });
}

        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

    ubox.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

    private void nboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nboxActionPerformed
      
    }//GEN-LAST:event_nboxActionPerformed

    private void sboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sboxActionPerformed
    String name = nbox.getText().trim();

    if (name.isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields are required");
        return;
    }

    try {
        Connection conn = dbconnect.getCon(); 
        PreparedStatement ps = conn.prepareStatement("INSERT INTO category (name) VALUES (?)"); // ✅ correct SQL + method
        ps.setString(1, name);
        ps.executeUpdate(); 

        JOptionPane.showMessageDialog(null, "Category added successfully!");

       
        setVisible(false);
        new managecatogery().setVisible(true);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_sboxActionPerformed

    private void uboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uboxActionPerformed
     String name = nbox.getText().trim();

    if (name.isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields are required");
        return;
    }

    try {
        Connection conn = dbconnect.getCon(); 
        PreparedStatement ps = conn.prepareStatement("update category set name=? where category_pk=?"); 
        ps.setString(1, name);
        ps.setInt(2, categorypk);
        ps.executeUpdate(); 

        JOptionPane.showMessageDialog(null, "Category updated successfully!");

       
        setVisible(false);
        new managecatogery().setVisible(true);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_uboxActionPerformed

    private void cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxActionPerformed
     setVisible(false);
    }//GEN-LAST:event_cboxActionPerformed

    private void ctableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ctableMouseClicked
       int index = ctable.getSelectedRow();
    if (index == -1) return;

    TableModel model = ctable.getModel();

    String id = model.getValueAt(index, 0).toString();
    categorypk = Integer.parseInt(id);

    String name = model.getValueAt(index, 1).toString();
    nbox.setText(name);

    sbox.setEnabled(false);
    ubox.setEnabled(true);
    }//GEN-LAST:event_ctableMouseClicked

 
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> new managecatogery().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cbox;
    private javax.swing.JTable ctable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nbox;
    private javax.swing.JButton rbox;
    private javax.swing.JButton sbox;
    private javax.swing.JButton ubox;
    // End of variables declaration//GEN-END:variables
}
