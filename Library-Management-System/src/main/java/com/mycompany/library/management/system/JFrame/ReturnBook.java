/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.library.management.system.JFrame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ponic
 */
public class ReturnBook extends javax.swing.JFrame {

    public ReturnBook() {
        initComponents();
    }

    
   public boolean getIssueDetals(){
     boolean getDetails = false;
     int bookID, studentID;
       
       try {
           bookID = Integer.parseInt(txt2_book_id.getText());
           studentID = Integer.parseInt(txt2_student_id.getText());
                   
           Connection con = DBConnection.getConnection();
           String sql = "select * from issue_book_details where book_id=? and student_id=? and status=?";
           PreparedStatement statement = con.prepareStatement(sql);
           statement.setInt(1, bookID);
           statement.setInt(2, studentID);
           statement.setString(3, "pending");
           ResultSet results = statement.executeQuery();
           
           if(results.next()){
               txt_issue_id.setText(results.getString("issue_ID"));
               txt_book_name.setText(results.getString("book_name"));
               txt_student_name.setText(results.getString("student_name"));
               txt_issue_date.setText(results.getString("issue_date"));
               txt_due_date.setText(results.getString("due_date"));
               txt_book_error.setText("");
               getDetails = true;
           } else {
               getDetails = false;
               txt_book_error.setText("No data found");
           }
         
       } catch (NumberFormatException | SQLException e){
           System.out.print(e);
       }
       return getDetails;
   } 
   
   
   public boolean returnBook(){
    boolean isReturned = false;
     int bookID, studentID;
   
        try {
           bookID = Integer.parseInt(txt2_book_id.getText());
           studentID = Integer.parseInt(txt2_student_id.getText());
                   
           Connection con = DBConnection.getConnection();
           String sql = "update issue_book_details set status=? where book_id=? and student_id=? and status=?";
           PreparedStatement statement = con.prepareStatement(sql);
           statement.setString(1, "returned");
           statement.setInt(2, bookID);
           statement.setInt(3, studentID);
            statement.setString(4, "pending");
          
           int rowCount = statement.executeUpdate();
            if(rowCount > 0){
             
               isReturned = true;
            } else {
               
               isReturned = false;
            } 
         
       } catch (NumberFormatException | SQLException e){
           System.out.print(e);
       }
       return isReturned;
     
   }
    
    
    
    public void updateBookCount(){
      int bookID = Integer.parseInt(txt2_book_id.getText());
       try {
            Connection con = DBConnection.getConnection();
            String sql =  "update book_details set quantity = quantity + 1 where book_id=? ";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, bookID);
            int rowCount = statement.executeUpdate();
              if(rowCount > 0){
                JOptionPane.showMessageDialog(this, "Book count updated");
               
            } else {
                 JOptionPane.showMessageDialog(this, "Something went wrong");
            } 
        } catch (SQLException e){
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

        panel_main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_issue_id = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_book_name = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_due_date = new app.bolivia.swing.JCTextField();
        jLabel25 = new javax.swing.JLabel();
        txt_book_error = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_issue_date = new app.bolivia.swing.JCTextField();
        txt_student_name = new app.bolivia.swing.JCTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt2_book_id = new app.bolivia.swing.JCTextField();
        jLabel22 = new javax.swing.JLabel();
        txt2_student_id = new app.bolivia.swing.JCTextField();
        jLabel2 = new javax.swing.JLabel();
        return_book_button = new javax.swing.JButton();
        return_book_button1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1040, 800));
        setUndecorated(true);
        setSize(new java.awt.Dimension(840, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(204, 204, 204));
        panel_main.setMinimumSize(new java.awt.Dimension(1040, 800));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Go BACK");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 34)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Issue Book details");
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 34)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\ponic\\OneDrive\\Dokumenty\\Projekty Java\\Library-Management-System\\Library-Management-System\\src\\main\\java\\AddNewBookIcons\\icons8_Literature_100px_1.png")); // NOI18N

        jLabel7.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Issue ID");

        txt_issue_id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, java.awt.Color.white));
        txt_issue_id.setForeground(java.awt.Color.gray);
        txt_issue_id.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        txt_issue_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_issue_idFocusLost(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Book name");

        txt_book_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, java.awt.Color.white));
        txt_book_name.setForeground(java.awt.Color.gray);
        txt_book_name.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        txt_book_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_txt_book_nameFocusLost(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Student Name");

        txt_due_date.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, java.awt.Color.white));
        txt_due_date.setForeground(java.awt.Color.gray);
        txt_due_date.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        txt_due_date.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_txt_due_dateFocusLost(evt);
            }
        });
        txt_due_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_due_dateActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("Issue Date");

        txt_book_error.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        txt_book_error.setForeground(new java.awt.Color(255, 0, 0));

        jLabel26.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
        jLabel26.setText("Due Date");

        txt_issue_date.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, java.awt.Color.white));
        txt_issue_date.setForeground(java.awt.Color.gray);
        txt_issue_date.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        txt_issue_date.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_txt_issue_dateFocusLost(evt);
            }
        });

        txt_student_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, java.awt.Color.white));
        txt_student_name.setForeground(java.awt.Color.gray);
        txt_student_name.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        txt_student_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_txt_student_nameFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_student_name, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(txt_book_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_issue_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_issue_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_due_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(txt_book_error, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(37, 37, 37)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_issue_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_book_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(txt_student_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(txt_issue_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(txt_due_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_book_error, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        panel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 800));

        jPanel3.setBackground(new java.awt.Color(147, 178, 147));

        jLabel19.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 34)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Return book");
        jLabel19.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel20.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 34)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\ponic\\OneDrive\\Dokumenty\\Projekty Java\\Library-Management-System\\Library-Management-System\\src\\main\\java\\AddNewBookIcons\\icons8_Student_Registration_100px_2.png")); // NOI18N

        jLabel21.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Book ID");

        txt2_book_id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, java.awt.Color.white));
        txt2_book_id.setForeground(java.awt.Color.gray);
        txt2_book_id.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        txt2_book_id.setPlaceholder("Enter book ID");
        txt2_book_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt2_book_idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt2_book_idFocusLost(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Student ID");

        txt2_student_id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, java.awt.Color.white));
        txt2_student_id.setForeground(java.awt.Color.gray);
        txt2_student_id.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        txt2_student_id.setPlaceholder("Enter student ID");
        txt2_student_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt2_student_idFocusLost(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        return_book_button.setBackground(new java.awt.Color(102, 102, 102));
        return_book_button.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        return_book_button.setForeground(new java.awt.Color(255, 255, 255));
        return_book_button.setText("Find Book");
        return_book_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_book_buttonActionPerformed(evt);
            }
        });

        return_book_button1.setBackground(new java.awt.Color(102, 102, 102));
        return_book_button1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        return_book_button1.setForeground(new java.awt.Color(255, 255, 255));
        return_book_button1.setText("Return book");
        return_book_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_book_button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel21))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel19)))
                .addContainerGap(136, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txt2_book_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(153, 153, 153)
                            .addComponent(txt2_student_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel22))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel20))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(return_book_button1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(return_book_button, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(215, 215, 215))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(txt2_book_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(txt2_student_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(return_book_button, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(return_book_button1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        panel_main.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 510, -1));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_issue_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_issue_idFocusLost

    }//GEN-LAST:event_txt_issue_idFocusLost

    private void txt_txt_book_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_txt_book_nameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_txt_book_nameFocusLost

    private void txt_txt_due_dateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_txt_due_dateFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_txt_due_dateFocusLost

    private void return_book_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_book_buttonActionPerformed
     
       getIssueDetals();
      

    }//GEN-LAST:event_return_book_buttonActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt2_student_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_student_idFocusLost
     
    }//GEN-LAST:event_txt2_student_idFocusLost

    private void txt2_book_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_book_idFocusLost
  
    }//GEN-LAST:event_txt2_book_idFocusLost

    private void txt2_book_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_book_idFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt2_book_idFocusGained

    private void txt_txt_issue_dateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_txt_issue_dateFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_txt_issue_dateFocusLost

    private void txt_txt_student_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_txt_student_nameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_txt_student_nameFocusLost

    private void return_book_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_book_button1ActionPerformed
          if(returnBook()==true){
             JOptionPane.showMessageDialog(this, "Book was returned");
       getIssueDetals();
       updateBookCount();
       } else {
         JOptionPane.showMessageDialog(this, "Ups! Somethings went wrong");}
        
    }//GEN-LAST:event_return_book_button1ActionPerformed

    private void txt_due_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_due_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_due_dateActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panel_main;
    private javax.swing.JButton return_book_button;
    private javax.swing.JButton return_book_button1;
    private app.bolivia.swing.JCTextField txt2_book_id;
    private app.bolivia.swing.JCTextField txt2_student_id;
    private javax.swing.JLabel txt_book_error;
    private app.bolivia.swing.JCTextField txt_book_name;
    private app.bolivia.swing.JCTextField txt_due_date;
    private app.bolivia.swing.JCTextField txt_issue_date;
    private app.bolivia.swing.JCTextField txt_issue_id;
    private app.bolivia.swing.JCTextField txt_student_name;
    // End of variables declaration//GEN-END:variables
}
