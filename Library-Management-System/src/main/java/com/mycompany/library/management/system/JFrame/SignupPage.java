
package com.mycompany.library.management.system.JFrame;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class SignupPage extends javax.swing.JFrame {

    
    public SignupPage() {
        initComponents();
    }

    public void insertSignupDetails(){
        String name = txt_username.getText();
        String email = txt_email.getText();
        String password = txt_password.getText();
        String contact = txt_phone.getText();
        
       
        try{
            Connection con = DBConnection.getConnection();
            String sql = "insert into users(name,email,password,contact) values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setString(4, contact);
            
            int updatedRowAccount = pst.executeUpdate();
            
            if(updatedRowAccount>0){
            JOptionPane.showMessageDialog(this, "Inserted successfully");
            LoginPage login = new LoginPage();
            login.setVisible(true);
            this.dispose();
            } else {
             JOptionPane.showMessageDialog(this, "FAILURE");}
        } catch (HeadlessException | SQLException e) {
            e.getMessage();
            System.out.println("FALIRIRIR");
            System.out.println(e.getMessage());
        }
     
    }
    
        public boolean validationSignup(){
        String name = txt_username.getText();
        String email = txt_email.getText();
        String password = txt_password.getText();
        String contact = txt_phone.getText();
      
        if(name.equals("")){
            JOptionPane.showMessageDialog(this, "Please enter a valid name");
            return false;
        } 
             
        if(email.equals("") || !email.matches("^.+@.+\\..+$")){
            JOptionPane.showMessageDialog(this, "Please enter a valid email");
             return false;
        } 
             
        if(password.equals("") ){
            JOptionPane.showMessageDialog(this, "Please enter a valid password");
             return false;
        } 
             
        if(contact.equals("")){
            JOptionPane.showMessageDialog(this, "Please enter a valid phone number");
             return false;
        } 
        return true;
    } 
        
        public boolean checkDuplicateUsers(){
             String name = txt_username.getText();
             boolean alreadyExists = false;
             try {
                 Connection con = DBConnection.getConnection();
                 PreparedStatement statement = con.prepareStatement("select * from users where name=?");
                 statement.setString(1, name);
                 ResultSet result = statement.executeQuery();
                 if(result.next()){
                 alreadyExists = true;
                 } else {
                     alreadyExists = false;
                 }
                 
             }
             catch (Exception e){
             e.getMessage();
             System.out.println(e.getMessage());
             }
             return alreadyExists;
        }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_phone = new app.bolivia.swing.JCTextField();
        txt_username = new app.bolivia.swing.JCTextField();
        txt_email = new app.bolivia.swing.JCTextField();
        txt_password = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1010, 680));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1010, 660));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Vivaldi", 1, 90)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Library");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 570, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ponic\\OneDrive\\Dokumenty\\Projekty Java\\Library-Management-System\\Library-Management-System\\src\\main\\java\\MyIcons\\books2.jpg")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 300, 650, 350));

        jLabel14.setFont(new java.awt.Font("Vivaldi", 1, 55)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("The Quantum Quill");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 570, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 580, 630));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 30, 20));

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Password:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Sign up");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Username:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        jLabel9.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Phone number:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, -1, -1));

        jLabel10.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("E-mail:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, -1));

        txt_phone.setBackground(new java.awt.Color(204, 204, 204));
        txt_phone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, java.awt.Color.white));
        txt_phone.setForeground(java.awt.Color.gray);
        txt_phone.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        txt_phone.setPlaceholder("your password");
        jPanel2.add(txt_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, -1, -1));

        txt_username.setBackground(new java.awt.Color(204, 204, 204));
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, java.awt.Color.white));
        txt_username.setForeground(java.awt.Color.gray);
        txt_username.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        txt_username.setPlaceholder("your username");
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        txt_email.setBackground(new java.awt.Color(204, 204, 204));
        txt_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, java.awt.Color.white));
        txt_email.setForeground(java.awt.Color.gray);
        txt_email.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        txt_email.setPlaceholder("your e-mail address");
        jPanel2.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, -1));

        txt_password.setBackground(new java.awt.Color(204, 204, 204));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, java.awt.Color.white));
        txt_password.setForeground(java.awt.Color.gray);
        txt_password.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        txt_password.setPlaceholder("your password");
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(102, 102, 102));
        rSMaterialButtonCircle1.setText("Log in");
        rSMaterialButtonCircle1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 18)); // NOI18N
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 570, 190, 40));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(51, 51, 51));
        rSMaterialButtonCircle2.setText("Sign up");
        rSMaterialButtonCircle2.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, 220, 60));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\ponic\\OneDrive\\Dokumenty\\Projekty Java\\Library-Management-System\\Library-Management-System\\src\\main\\java\\icons\\phone.png")); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\ponic\\OneDrive\\Dokumenty\\Projekty Java\\Library-Management-System\\Library-Management-System\\src\\main\\java\\icons\\account.png")); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\ponic\\OneDrive\\Dokumenty\\Projekty Java\\Library-Management-System\\Library-Management-System\\src\\main\\java\\icons\\email.png")); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\ponic\\OneDrive\\Dokumenty\\Projekty Java\\Library-Management-System\\Library-Management-System\\src\\main\\java\\icons\\password.png")); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Create a new account");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 420, 640));

        setSize(new java.awt.Dimension(1019, 625));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
           if(validationSignup() == true){
               if(checkDuplicateUsers() == false){
                     insertSignupDetails();
               } else {
                   JOptionPane.showMessageDialog(this, "This username already exists.");
               }
         
           }
        
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
    
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
       if(checkDuplicateUsers() == true){
           JOptionPane.showMessageDialog(this, "This username already exists.");
       }
    }//GEN-LAST:event_txt_usernameFocusLost

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

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
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupPage().setVisible(true);
            }
        }) ;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_email;
    private app.bolivia.swing.JCTextField txt_password;
    private app.bolivia.swing.JCTextField txt_phone;
    private app.bolivia.swing.JCTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
