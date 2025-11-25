package infc;

import infc.code.dbconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class login extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(login.class.getName());

    public login() {
        initComponents();
        setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pbox = new javax.swing.JPasswordField();
        ubox = new javax.swing.JTextField();
        logbox = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 51));
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel3.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(390, 40, 120, 40);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("USERNAME");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(170, 210, 120, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PASSWORD");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(170, 410, 110, 20);

        pbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pboxActionPerformed(evt);
            }
        });
        jPanel3.add(pbox);
        pbox.setBounds(160, 480, 230, 30);
        jPanel3.add(ubox);
        ubox.setBounds(160, 280, 230, 30);

        logbox.setBackground(new java.awt.Color(102, 255, 51));
        logbox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logbox.setText("LOGIN");
        logbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logboxActionPerformed(evt);
            }
        });
        jPanel3.add(logbox);
        logbox.setBounds(540, 460, 110, 40);

        jButton1.setBackground(new java.awt.Color(102, 255, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("LEAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(530, 610, 80, 20);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(670, 0, 1740, 817);
        jPanel3.getAccessibleContext().setAccessibleName("LOGIN");

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 6, 36, 0);

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel4);
        jPanel4.setBounds(161, 6, 0, 0);

        jPanel1.setBackground(new java.awt.Color(102, 255, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 1000));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/infc/img/1.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 670, 820);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logboxActionPerformed
String email = ubox.getText().trim();
String password = new String(pbox.getPassword()).trim(); // Use getPassword() for JPasswordField

// Input validation
if (email.isEmpty() || password.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Please enter both email and password!");
    return;
}

try {
    Connection conn = (Connection) dbconnect.getCon();
    PreparedStatement ps = conn.prepareStatement(
        "select * from appuser1 where email=? and password=? and status='active'");
    ps.setString(1, email);
    ps.setString(2, password);
    
    ResultSet rs = ps.executeQuery();
    
    if (rs.next()) {
        JOptionPane.showMessageDialog(null, "Login Successful!");
        
        
        this.setVisible(false); 
        new home().setVisible(true);
        
    } else {
        JOptionPane.showMessageDialog(null, "Invalid email or password!");
    }
    
    
    rs.close();
    ps.close();
    conn.close();
    
} catch(Exception e) {
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    e.printStackTrace();
}      
    }//GEN-LAST:event_logboxActionPerformed

    private void pboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pboxActionPerformed

    }//GEN-LAST:event_pboxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
              int response = JOptionPane.showConfirmDialog(null, "Do You Want To Leave", "Select", JOptionPane.YES_NO_OPTION);
    
    if (response == JOptionPane.YES_OPTION) {
        
        System.exit(0);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) {
   
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> new login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton logbox;
    private javax.swing.JPasswordField pbox;
    private javax.swing.JTextField ubox;
    // End of variables declaration//GEN-END:variables
}
