/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.library.management.system.JFrame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ponic
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }

    
    public void getBookDetails(){
        int bookID = Integer.parseInt(txt2_book_id.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "select * from book_details where book_id=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, bookID);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                txt_book_id.setText(result.getString("book_id"));
                txt_book_name.setText(result.getString("book_name"));
                txt_book_author.setText(result.getString("book_author"));
                txt_book_quantity.setText(result.getString("quantity"));
              
            } else {
            txt_book_error.setText("Invalid student ID");
            }
        } catch (SQLException e){
            System.out.print(e);
        }
    }
    
    public void getStudentsDetails(){
        int studentID = Integer.parseInt(txt2_student_id.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from students where student_id=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, studentID);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                txt_student_id.setText(result.getString("student_id"));
                txt_student_name.setText(result.getString("student_name"));
                txt_student_course.setText(result.getString("student_course"));
                txt_student_faculty.setText(result.getString("student_faculty"));
              } else {
                txt_student_error.setText("Invalid student ID");
            }
            
        } catch (SQLException e) {
            System.out.print(e);
        }
    }
    
    public boolean issueBook(){
        boolean isIssued = false;
        int bookID = Integer.parseInt(txt_book_id.getText());
        int studentID = Integer.parseInt(txt_student_id.getText());
        String studentName = txt_student_name.getText();
        String bookName = txt_book_name.getText();
        Date issueDate = date_from.getDatoFecha();
        Date dueDate = date_to.getDatoFecha();
        
        Long l1 = issueDate.getTime();
        Long l2 = dueDate.getTime();
        java.sql.Date sIssueDate = new java.sql.Date(l1);
        java.sql.Date dDueDate = new java.sql.Date(l2);
        
        try {
            Connection con = DBConnection.getConnection();
            String sql =  "insert into issue_book_details(book_ID, book_name, student_ID, student_name, issue_date, due_date, status) values (?,?,?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, bookID);
            statement.setString(2, bookName);
            statement.setInt(3, studentID);
            statement.setString(4, studentName);
            statement.setDate(5, sIssueDate);
            statement.setDate(6, dDueDate);
            statement.setString(7, "pending");
            
            int rowCount = statement.executeUpdate();
            if(rowCount > 0){
                isIssued = true;
            } else {
                isIssued = false;
            }
        } catch (Exception e){
        System.out.print(e);
        }
        return isIssued;
    }
    
    public void updateBookCount(){
      int bookID = Integer.parseInt(txt_book_id.getText());
       try {
            Connection con = DBConnection.getConnection();
            String sql =  "update book_details set quantity = quantity - 1 where book_id=? ";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, bookID);
            int rowCount = statement.executeUpdate();
              if(rowCount > 0){
                JOptionPane.showMessageDialog(this, "Book count updated");
                int newBookCount = Integer.parseInt(txt_book_quantity.getText());
                txt_book_quantity.setText(Integer.toString(newBookCount-1));
            } else {
                 JOptionPane.showMessageDialog(this, "Something went wrong");
            } 
        } catch (SQLException e){
        System.out.print(e);
        }
    }
    
    public boolean checkIfAlreadyIssued(){
        boolean isAlreadyIssued = false;
        int bookID = Integer.parseInt(txt_book_id.getText());
        int studentID = Integer.parseInt(txt_student_id.getText());
         try {
            Connection con = DBConnection.getConnection();
            String sql =  "select * from issue_book_details where book_id=? and student_id=? and status=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, bookID);
            statement.setInt(2, studentID);
            statement.setString(3, "pending");
            ResultSet results = statement.executeQuery();
            if(results.next()){
                isAlreadyIssued = true;
            } else {
                isAlreadyIssued = false;
            }
             
          } catch (SQLException e){
        System.out.print(e);
        }
         return isAlreadyIssued;
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
        txt_book_id = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_book_name = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_book_author = new app.bolivia.swing.JCTextField();
        txt_book_quantity = new app.bolivia.swing.JCTextField();
        jLabel25 = new javax.swing.JLabel();
        txt_book_error = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_student_id = new app.bolivia.swing.JCTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_student_name = new app.bolivia.swing.JCTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_student_course = new app.bolivia.swing.JCTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_student_faculty = new app.bolivia.swing.JCTextField();
        txt_student_error = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt2_book_id = new app.bolivia.swing.JCTextField();
        jLabel22 = new javax.swing.JLabel();
        txt2_student_id = new app.bolivia.swing.JCTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        date_from = new rojeru_san.componentes.RSDateChooser();
        date_to = new rojeru_san.componentes.RSDateChooser();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1240, 800));
        setMinimumSize(new java.awt.Dimension(1240, 800));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1240, 800));
        setSize(new java.awt.Dimension(1240, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(204, 204, 204));
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
        jLabel8.setText("Book details");
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 34)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\ponic\\OneDrive\\Dokumenty\\Projekty Java\\Library-Management-System\\Library-Management-System\\src\\main\\java\\AddNewBookIcons\\icons8_Literature_100px_1.png")); // NOI18N

        jLabel7.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Book ID");

        txt_book_id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, java.awt.Color.white));
        txt_book_id.setForeground(java.awt.Color.gray);
        txt_book_id.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        txt_book_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_book_idFocusLost(evt);
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
        jLabel12.setText("Author name");

        txt_book_author.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, java.awt.Color.white));
        txt_book_author.setForeground(java.awt.Color.gray);
        txt_book_author.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        txt_book_author.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_txt_book_authorFocusLost(evt);
            }
        });

        txt_book_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, java.awt.Color.white));
        txt_book_quantity.setForeground(java.awt.Color.gray);
        txt_book_quantity.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("Quantity");

        txt_book_error.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        txt_book_error.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_book_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_book_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_book_author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_book_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(txt_book_error)))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(141, 141, 141)
                    .addComponent(jLabel25)
                    .addContainerGap(145, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_book_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_book_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(txt_book_author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(txt_book_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(txt_book_error)
                .addContainerGap(222, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(477, Short.MAX_VALUE)
                    .addComponent(jLabel25)
                    .addGap(296, 296, 296)))
        );

        panel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 800));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel13.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 34)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Students details");
        jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 34)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\ponic\\OneDrive\\Dokumenty\\Projekty Java\\Library-Management-System\\Library-Management-System\\src\\main\\java\\AddNewBookIcons\\icons8_Student_Registration_100px_2.png")); // NOI18N

        jLabel15.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Student ID");

        txt_student_id.setBackground(new java.awt.Color(204, 204, 204));
        txt_student_id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, java.awt.Color.white));
        txt_student_id.setForeground(java.awt.Color.gray);
        txt_student_id.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        txt_student_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_student_idFocusLost(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Name");

        txt_student_name.setBackground(new java.awt.Color(204, 204, 204));
        txt_student_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, java.awt.Color.white));
        txt_student_name.setForeground(java.awt.Color.gray);
        txt_student_name.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        txt_student_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_student_nameFocusLost(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Course");

        txt_student_course.setBackground(new java.awt.Color(204, 204, 204));
        txt_student_course.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, java.awt.Color.white));
        txt_student_course.setForeground(java.awt.Color.gray);
        txt_student_course.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        txt_student_course.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_student_courseFocusLost(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Faculty");

        txt_student_faculty.setBackground(new java.awt.Color(204, 204, 204));
        txt_student_faculty.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, java.awt.Color.white));
        txt_student_faculty.setForeground(java.awt.Color.gray);
        txt_student_faculty.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N

        txt_student_error.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        txt_student_error.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 61, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(30, 30, 30))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_student_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_student_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_student_course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_student_faculty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel16))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel17))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(txt_student_error)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_student_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_student_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(txt_student_course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_student_faculty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(txt_student_error)
                .addContainerGap(196, Short.MAX_VALUE))
        );

        panel_main.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 204, 102));

        jLabel19.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 34)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Issue book");
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

        jLabel23.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setText("Date from");

        jLabel24.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("Due Date");

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        date_from.setColorBackground(new java.awt.Color(102, 102, 102));
        date_from.setColorButtonHover(new java.awt.Color(102, 102, 102));
        date_from.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        date_from.setFuente(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        date_from.setPlaceholder("Choose the date");

        date_to.setColorBackground(new java.awt.Color(102, 102, 102));
        date_to.setColorButtonHover(new java.awt.Color(102, 102, 102));
        date_to.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        date_to.setFuente(new java.awt.Font("Copperplate Gothic Light", 1, 12)); // NOI18N
        date_to.setPlaceholder("Until");

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Issue Book");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel21))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txt2_student_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt2_book_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(date_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel22))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel23))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel24))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel20))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt2_book_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt2_student_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addGap(16, 16, 16)
                .addComponent(date_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        panel_main.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 430, -1));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_book_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_book_idFocusLost

    }//GEN-LAST:event_txt_book_idFocusLost

    private void txt_txt_book_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_txt_book_nameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_txt_book_nameFocusLost

    private void txt_txt_book_authorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_txt_book_authorFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_txt_book_authorFocusLost

    private void txt_student_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_student_idFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_student_idFocusLost

    private void txt_student_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_student_nameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_student_nameFocusLost

    private void txt_student_courseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_student_courseFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_student_courseFocusLost

    private void txt2_book_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_book_idFocusLost
        if(!txt2_book_id.getText().equals("")){
              getBookDetails(); 
        }
      
    }//GEN-LAST:event_txt2_book_idFocusLost

    private void txt2_student_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_student_idFocusLost
        getStudentsDetails();
    }//GEN-LAST:event_txt2_student_idFocusLost

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt2_book_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2_book_idFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt2_book_idFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if(txt_book_quantity.getText().equals("0")){
          JOptionPane.showMessageDialog(this, "There are no books to issue!");
      } else {
           if(checkIfAlreadyIssued()==false){
       if(issueBook()==true){
           JOptionPane.showMessageDialog(this, "Issued the book!");
           updateBookCount();
       } else {
       JOptionPane.showMessageDialog(this, "Ups! Something went wrong!");}
       
       } else {
           JOptionPane.showMessageDialog(this, "The book is already issued!");
       }
      }
   
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_from;
    private rojeru_san.componentes.RSDateChooser date_to;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panel_main;
    private app.bolivia.swing.JCTextField txt2_book_id;
    private app.bolivia.swing.JCTextField txt2_student_id;
    private app.bolivia.swing.JCTextField txt_book_author;
    private javax.swing.JLabel txt_book_error;
    private app.bolivia.swing.JCTextField txt_book_id;
    private app.bolivia.swing.JCTextField txt_book_name;
    private app.bolivia.swing.JCTextField txt_book_quantity;
    private app.bolivia.swing.JCTextField txt_student_course;
    private javax.swing.JLabel txt_student_error;
    private app.bolivia.swing.JCTextField txt_student_faculty;
    private app.bolivia.swing.JCTextField txt_student_id;
    private app.bolivia.swing.JCTextField txt_student_name;
    // End of variables declaration//GEN-END:variables
}
