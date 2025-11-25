package infc;

import java.awt.Color;
import java.sql.Connection;
import infc.code.dbconnect;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import javax.swing.table.TableModel;

public class manageuse extends javax.swing.JFrame {

    private int appuser_pk = 0;

   public manageuse() {
    initComponents();
    setLocationRelativeTo(null); 
    
    tableuser.setDefaultEditor(Object.class, null);
}

    private boolean validateFields(String formType) {
         if (nbox.getText().trim().isEmpty() ||
        ebox.getText().trim().isEmpty() ||
        abox.getText().trim().isEmpty() ||
        mbox.getText().trim().isEmpty() ||
        (formType.equals("new") && new String(pbox.getPassword()).trim().isEmpty())) {
        return false;
    }
    return true;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableuser = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        nbox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ebox = new javax.swing.JTextField();
        abox = new javax.swing.JTextField();
        sbox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        pbox = new javax.swing.JPasswordField();
        save = new javax.swing.JButton();
        update = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        close = new javax.swing.JButton();
        mbox = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/infc/7713.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 0));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 0));
        jLabel1.setText("Manage User");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, -10, -1, 90));

        tableuser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Mobile Number", "Email", "Address", "Status"
            }
        ));
        jScrollPane1.setViewportView(tableuser);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 690, 730));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 70, 56, -1));

        nbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nboxActionPerformed(evt);
            }
        });
        getContentPane().add(nbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 100, 270, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Mobile Number");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Email");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 210, 47, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Address");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Status");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 430, 55, -1));
        getContentPane().add(ebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 240, 262, -1));

        abox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboxActionPerformed(evt);
            }
        });
        getContentPane().add(abox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 310, 262, -1));

        sbox.setBackground(new java.awt.Color(102, 255, 0));
        sbox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Not Active" }));
        sbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sboxActionPerformed(evt);
            }
        });
        getContentPane().add(sbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 460, 262, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Password");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 350, -1, -1));
        getContentPane().add(pbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 390, 262, -1));

        save.setBackground(new java.awt.Color(102, 255, 0));
        save.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 530, -1, -1));

        update.setBackground(new java.awt.Color(102, 255, 0));
        update.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 530, -1, -1));

        reset.setBackground(new java.awt.Color(102, 255, 0));
        reset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 530, -1, -1));

        close.setBackground(new java.awt.Color(102, 255, 0));
        close.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 530, -1, -1));

        mbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mboxActionPerformed(evt);
            }
        });
        getContentPane().add(mbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 170, 260, -1));

        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 790));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

        DefaultTableModel model = (DefaultTableModel) tableuser.getModel();
        model.setRowCount(0);

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = (Connection) dbconnect.getCon();
            st = conn.createStatement();
            rs = st.executeQuery("select * from appuser1 where userRole='Admin'");

            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getString("appuser_pk"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("address"),
                    rs.getString("status"),});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + ex.getMessage());
            }
        }

    }//GEN-LAST:event_formComponentShown

    private void aboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboxActionPerformed

    }//GEN-LAST:event_aboxActionPerformed

    private void mboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mboxActionPerformed

    }//GEN-LAST:event_mboxActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
    String name = nbox.getText();
    String mobilenumber = mbox.getText();
    String email = ebox.getText();
    String password = new String(pbox.getPassword());
    String address = abox.getText();
    String status = (String) sbox.getSelectedItem();
    

  if (!validateFields("new")) 
  {
    JOptionPane.showMessageDialog(this, "All fields are required");
    return;
}
  else {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = dbconnect.getCon();
       
            ps = conn.prepareStatement(
                "insert into appuser1 (userRole,name,mobileNumber,email,password,address,status) values ('admin',?,?,?,?,?,?)");
            
            ps.setString(1, name);
            ps.setString(2, mobilenumber);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setString(5, address);
            ps.setString(6, status);
            
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
              JOptionPane.showMessageDialog(this, "User added successfully");
                setVisible(false);
                new manageuse().setVisible(true);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        } finally {
          
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error closing resources: " + ex.getMessage());
            }
        }
    }
    
    }//GEN-LAST:event_saveActionPerformed
     
    private void nboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nboxActionPerformed

    }//GEN-LAST:event_nboxActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
       // setVisible(false);
        int confirm = JOptionPane.showConfirmDialog(
        this, 
        "Are you sure you want to close?", 
        "Confirm Close", 
        JOptionPane.YES_NO_OPTION
    );
    
    if (confirm == JOptionPane.YES_OPTION) {
        this.dispose();

    }
    }//GEN-LAST:event_closeActionPerformed

    private void sboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sboxActionPerformed
     
    }//GEN-LAST:event_sboxActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        int index = tableuser.getSelectedRow();
        TableModel model = tableuser.getModel();
        
        String id = model.getValueAt(index,0).toString();
        appuser_pk = Integer.parseInt(id);
        
        String name = model.getValueAt(index, 1).toString();
        nbox.setText(name);
        
        String mobilenumber = model.getValueAt(index, 2).toString();
        mbox.setText(mobilenumber);
        
        String email = model.getValueAt(index, 3).toString();
        ebox.setText(email);
        
         String address = model.getValueAt(index, 5).toString();
        abox.setText(address);
        
        String status = model.getValueAt(index, 4).toString();
        sbox.removeAllItems();
         pbox.setEditable(false);
        pbox.setBackground(Color.DARK_GRAY);
        
        save.setEnabled(false);    
        update.setEnabled(true);
        if(status.equals("Act"))
        {
        sbox.addItem("Active");
        sbox.addItem("Not Active");
        }
        else
        {
        sbox.addItem("Not Active");
        sbox.addItem("Active");        
        }
        
       
      
    }//GEN-LAST:event_jLabel9MouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
    String name = nbox.getText().trim();
    String mobilenumber = mbox.getText().trim();
    String email = ebox.getText().trim();
    String address = abox.getText().trim();
    String status = (String) sbox.getSelectedItem();


    if (name.isEmpty() || mobilenumber.isEmpty() || email.isEmpty() || address.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields are required");
        return;
    }

    Connection conn = null;
    PreparedStatement ps = null;

    try {
        conn = dbconnect.getCon();

    
        String sql = "UPDATE appuser1 SET name=?, mobileNumber=?, email=?, address=?, status=? WHERE appuser_pk=?";
        ps = conn.prepareStatement(sql);

  
        ps.setString(1, name);
        ps.setString(2, mobilenumber);
        ps.setString(3, email);
        ps.setString(4, address);
        ps.setString(5, status);
        ps.setInt(6, appuser_pk);

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "User updated successfully!");

            setVisible(false);
            new manageuse().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No record was updated. Please select a valid row.");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
    } finally {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error closing resources: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_updateActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
       setVisible(false);
       new manageuse().setVisible(true);
    }//GEN-LAST:event_resetActionPerformed

    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> {
            new manageuse().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField abox;
    private javax.swing.JButton close;
    private javax.swing.JTextField ebox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mbox;
    private javax.swing.JTextField nbox;
    private javax.swing.JPasswordField pbox;
    private javax.swing.JButton reset;
    private javax.swing.JButton save;
    private javax.swing.JComboBox<String> sbox;
    private javax.swing.JTable tableuser;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

}
