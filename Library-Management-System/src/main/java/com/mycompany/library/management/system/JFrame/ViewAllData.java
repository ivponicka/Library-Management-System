/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.library.management.system.JFrame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ponic
 */
public class ViewAllData extends javax.swing.JFrame {

    DefaultTableModel model;
    /**
     * Creates new form ViewAllData
     */
    public ViewAllData() {
        initComponents();
        displayData();
    }

    public void displayData(){
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details ";
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery(sql);
            while(results.next()){
                int id = results.getInt("issue_ID");
                String bookName = results.getString("book_name");
                String studentName = results.getString("student_name");
                String issueDate = results.getString("issue_date");
                String dueDate = results.getString("due_date");
                String status = results.getString("status");
                
                Object[] obj = {id, bookName, studentName, issueDate,dueDate, status};
                model = (DefaultTableModel) table_details_issues.getModel();
                model.addRow(obj);
            }
        } catch (Exception e){
            System.out.print(e);
        }
    }
    
    public void clearData(){
        DefaultTableModel model = (DefaultTableModel) table_details_issues.getModel();
        model.setRowCount(0);
    }
    
    public void datesSearch(){
        Date fromDate = date_from.getDatoFecha();
        Date toDate = date_to.getDatoFecha();
        
        long time1 = fromDate.getTime();
        long time2 = toDate.getTime();
        
        java.sql.Date fDate = new java.sql.Date(time1);
        java.sql.Date tDate = new java.sql.Date(time2);
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where issue_date BETWEEN ? and ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setDate(1, fDate);
            statement.setDate(2, tDate);
            ResultSet results = statement.executeQuery();
           
            if(results.next()==false){
                JOptionPane.showMessageDialog(this, "No data found. Date out of range");
            } else {
                  while(results.next()){
                   int id = results.getInt("issue_ID");
                String bookName = results.getString("book_name");
                String studentName = results.getString("student_name");
                String issueDate = results.getString("issue_date");
                String dueDate = results.getString("due_date");
                String status = results.getString("status");
                
                         
                Object[] obj = {id, bookName, studentName, issueDate,dueDate, status};
                model = (DefaultTableModel) table_details_issues.getModel();
                model.addRow(obj);
            }
            }
      
            
        } catch (Exception e){
            System.out.print(e);
        }
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
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        date_from = new rojeru_san.componentes.RSDateChooser();
        date_to = new rojeru_san.componentes.RSDateChooser();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_details_issues = new rojerusan.RSTableMetro();
        showalldata_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1240, 200));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 34)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\ponic\\OneDrive\\Dokumenty\\Projekty Java\\Library-Management-System\\Library-Management-System\\src\\main\\java\\AddNewBookIcons\\icons8_Literature_100px_1.png")); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, -1));

        jLabel8.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 34)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("All book data");
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

        date_from.setColorBackground(new java.awt.Color(102, 102, 102));
        date_from.setColorButtonHover(new java.awt.Color(102, 102, 102));
        date_from.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        date_from.setFuente(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        date_from.setPlaceholder("Choose the date");
        jPanel1.add(date_from, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        date_to.setColorBackground(new java.awt.Color(102, 102, 102));
        date_to.setColorButtonHover(new java.awt.Color(102, 102, 102));
        date_to.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        date_to.setFuente(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        date_to.setPlaceholder("Until");
        jPanel1.add(date_to, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, -1, -1));

        jLabel23.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("To:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, -1, -1));

        jLabel24.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("From:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 140, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 250));

        jPanel2.setPreferredSize(new java.awt.Dimension(1240, 100));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_details_issues.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book name", "Student name", "Issue Date", "Due Date", "Status"
            }
        ));
        table_details_issues.setColorBackgoundHead(new java.awt.Color(102, 102, 102));
        table_details_issues.setColorFilasForeground1(new java.awt.Color(102, 102, 102));
        table_details_issues.setColorFilasForeground2(new java.awt.Color(102, 102, 102));
        table_details_issues.setColorSelBackgound(new java.awt.Color(102, 102, 102));
        jScrollPane4.setViewportView(table_details_issues);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 990, 230));

        showalldata_button.setBackground(new java.awt.Color(102, 102, 102));
        showalldata_button.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        showalldata_button.setForeground(new java.awt.Color(255, 255, 255));
        showalldata_button.setText("Show all data");
        showalldata_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showalldata_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(showalldata_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 230, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 230, 1380, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showalldata_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showalldata_buttonActionPerformed
        clearData();   
        displayData();
          

    }//GEN-LAST:event_showalldata_buttonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       clearData(); 
       datesSearch();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAllData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAllData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_from;
    private rojeru_san.componentes.RSDateChooser date_to;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton showalldata_button;
    private rojerusan.RSTableMetro table_details_issues;
    // End of variables declaration//GEN-END:variables
}
