
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moklet
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        signin = new javax.swing.JButton();
        signup1 = new javax.swing.JButton();
        exit1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("USERNAME");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(160, 40, 110, 30);
        jPanel1.add(user);
        user.setBounds(110, 80, 220, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("PASSWORD");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(170, 130, 110, 30);
        jPanel1.add(pass);
        pass.setBounds(110, 170, 220, 40);

        signin.setText("Sign In");
        signin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinActionPerformed(evt);
            }
        });
        jPanel1.add(signin);
        signin.setBounds(290, 230, 110, 40);

        signup1.setText("Sign Up");
        signup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup1ActionPerformed(evt);
            }
        });
        jPanel1.add(signup1);
        signup1.setBounds(50, 230, 110, 40);

        exit1.setText("Exit");
        exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit1ActionPerformed(evt);
            }
        });
        jPanel1.add(exit1);
        exit1.setBounds(170, 230, 110, 40);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 440, 330);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 440, 330);

        setSize(new java.awt.Dimension(455, 364));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signup1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup1ActionPerformed
       String username = user.getText();
       String password = pass.getText();
       
       try{
           try(Statement statement = (Statement) file_koneksi.getConnection().createStatement()){
            statement.executeUpdate("INSERT INTO `tb_akun`(`username`, `password`) VALUES ('"+username+"', '"+password+"')") ;
           }
       }
       catch(Exception t){
           
       }
       
    }//GEN-LAST:event_signup1ActionPerformed

    private void exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit1ActionPerformed
        dispose();
    }//GEN-LAST:event_exit1ActionPerformed

    private void signinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinActionPerformed
       Connection connection;
       PreparedStatement ps;
       
       try{
           connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_testkoneksi?zeroDateTimeBehavior=convertToNull","root",""); ;
           ps = connection.prepareStatement("SELECT * FROM `tb_akun` WHERE username = ? AND password = ?");
           ps.setString(1, user.getText());
           ps.setString(2, pass.getText());
           ResultSet result = ps.executeQuery();
           if(result.next()){
               new frmMain().show();
               this.dispose();
           }
           else{
               JOptionPane.showMessageDialog(rootPane, "Salah!");
               pass.setText("");
               user.requestFocus();
           }}
           catch(SQLException ex){
                    JOptionPane.showMessageDialog(rootPane, "Salah!");
                   }
       
    }//GEN-LAST:event_signinActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField pass;
    private javax.swing.JButton signin;
    private javax.swing.JButton signup1;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
