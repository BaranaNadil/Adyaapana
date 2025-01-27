package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

public class PaymentPanel extends javax.swing.JPanel {

    private HomePanel perent;

    HashMap<String, String> monthsMap = new HashMap<>();
    HashMap<String, String> subjectPriceMap = new HashMap<>();

    boolean canPay;

    /**
     * Creates new form PaymentPanel
     */
    public PaymentPanel(HomePanel perent) {
        this.perent = perent;
        initComponents();
        loadStudentsToJList();
        loadMonths();
        loadStudentHasClassTable();
        loadStudentSpecificpcDuePayments();
    }

    //Load Student Due to payment
    void loadStudentSpecificpcDuePayments() {

        if (jList1.isSelectionEmpty()) {
            System.out.println("Not Selected");
        } else if (jComboBox1.getSelectedItem().equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select Month", "Alert", JOptionPane.WARNING_MESSAGE);
        } else {

            String studentDetais = jList1.getSelectedValue();
            String[] student = studentDetais.split("/");
            String studentID = student[0].trim();
            System.out.println(studentID);

            String month = String.valueOf(jComboBox1.getSelectedItem());

            String quary = "SELECT * FROM `student_has_class`"
                    + " INNER JOIN `invoice`  ON `student_has_class`.`id` = `invoice`.`Student_has_Class_id` "
                    + "INNER JOIN `student` ON `student_has_class`.`Student_Sno` = `student`.`Sno` "
                    + "INNER JOIN `class` ON `student_has_class`.`Class_ClassNo` = `class`.`ClassNo` "
                    + "INNER JOIN `teacher` ON `class`.`Teacher_Tno` = `teacher`.`Tno` "
                    + "INNER JOIN `subject` ON `class`.`Subject_Subno` = `subject`.`Subno` "
                    + "WHERE `student_has_class`.`status_id` = '1' AND `invoice`.`month_id` != ? AND `student_has_class`.`Student_Sno` = ?";
            System.out.println(month);
            try {
                ResultSet result = MySQL.executeSelect(quary, monthsMap.get(month), studentID);

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);

                while (result.next()) {
                    Vector<String> vector = new Vector();
                    vector.add(result.getString("class.ClassNo"));
                    vector.add(result.getString("subject.name"));
                    vector.add(result.getString("teacher.Name"));
                    vector.add(result.getString("student_has_class.status_id"));
                    model.addRow(vector);

                    subjectPriceMap.put(result.getString("subject.name"), result.getString("subject.Price"));

                }
                jTable1.setModel(model);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
    //Load Student Due to payment

    //load Students class table
    private void loadStudentHasClassTable() {

        // Get the current date 
        LocalDate currentDate = LocalDate.now();
        // Get the month 
        String month = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        String quary = "SELECT * FROM `student_has_class`"
                + " INNER JOIN `invoice`  ON `student_has_class`.`id` = `invoice`.`Student_has_Class_id` "
                + "INNER JOIN `student` ON `student_has_class`.`Student_Sno` = `student`.`Sno` "
                + "INNER JOIN `class` ON `student_has_class`.`Class_ClassNo` = `class`.`ClassNo` "
                + "INNER JOIN `teacher` ON `class`.`Teacher_Tno` = `teacher`.`Tno` "
                + "INNER JOIN `subject` ON `class`.`Subject_Subno` = `subject`.`Subno` "
                + "WHERE `student_has_class`.`status_id` = '1' AND `invoice`.`month_id` != ? ";

        try {
            ResultSet result = MySQL.executeSelect(quary, monthsMap.get(month));

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (result.next()) {
                Vector<String> vector = new Vector();
                vector.add(result.getString("class.ClassNo"));
                vector.add(result.getString("subject.name"));
                vector.add(result.getString("teacher.Name"));
                vector.add(result.getString("student.Name"));
                model.addRow(vector);

                subjectPriceMap.put(result.getString("subject.name"), result.getString("subject.Price"));

            }
            jTable1.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //load Students class table

    //Load Months
    private void loadMonths() {
        String quary = "SELECT * FROM `month`";

        Vector<String> vector = new Vector<>();
        vector.add("Select");
        try {
            ResultSet result = MySQL.executeSelect(quary);
            while (result.next()) {
                vector.add(result.getString("month.month"));
                monthsMap.put(result.getString("month.month"), result.getString("month.id"));

            }
            jComboBox1.setModel(new DefaultComboBoxModel(vector));

            // Get the current date 
            LocalDate currentDate = LocalDate.now();
            // Get the month 
            String month = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

            jComboBox1.setSelectedItem(month);

        } catch (SQLException e) {

        }
    }
    //Load Months

    // Load Students to JList
    private void loadStudentsToJList() {
        String seachTxt = jTextField1.getText();
        String quary = "SELECT `student`.`Sno`, `student`.`Name` FROM `student` WHERE (`student`.`Sno` LIKE ? AND `student`.`status_id` = '1') OR (`student`.`Name` LIKE ? AND `student`.`status_id` = '1')";

        try {
            ResultSet result = MySQL.executeSelect(quary, "%" + seachTxt + "%", "%" + seachTxt + "%");

            DefaultListModel model = new DefaultListModel();
            int index = 0;
            while (result.next()) {
                index++;
//            model.add(index, result.getString("student.Sno") +" / "+ result.getString("student.Name"));
                model.addElement(result.getString("student.Sno") + " / " + result.getString("student.Name"));
            }
            jList1.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Load Students to JList

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Payment");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(10, 10, 10))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Class ID", "Subject Name", "Teacher Name", "Student Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setText("Students");

        jTextField1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setText("Month");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        canPay = false;
        if (evt.getClickCount() == 2) {
            canPay = true;
            loadStudentSpecificpcDuePayments();
        }

    }//GEN-LAST:event_jList1MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        loadStudentSpecificpcDuePayments();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        if (evt.getClickCount() == 2) {

            if (!jList1.isSelectionEmpty() && canPay) {
                canPay = false;
                MakePaymentForMonth makePayement = new MakePaymentForMonth(SplashWindow.spalshWindow, true, this);
                makePayement.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Please Select Tha Student You Need to Get Payment.", "Alert", JOptionPane.WARNING_MESSAGE);
            }

        }

    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
