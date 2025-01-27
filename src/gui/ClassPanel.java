package gui;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class ClassPanel extends javax.swing.JPanel {

    private HomePanel perent;

    HashMap<String, String> subjectPriceMap = new HashMap<>();

    static boolean haveThread = false;

    /**
     * Creates new form ClassPanel
     */
    public ClassPanel(HomePanel perent) {
        this.perent = perent;
        initComponents();
        loadStudentsToJList();
        loadAllClass();
        loadTodayClasses();
        startWorkerUpdateTable();
    }

    ///Create Worker for update Live Class Table
    private void startWorkerUpdateTable() {
        if (!haveThread) {
            Thread updateWorker = new Thread(new Runnable() {
                @Override
                public void run() {
                    haveThread = true;
                    while (perent.classTreadWorking) {

                        if (String.valueOf(jComboBox1.getSelectedItem()).equals("Active Class")) {

                            // Get the current time 
                            LocalTime currentTime = LocalTime.now();
                            // Format the time (optional) 
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                            String formattedTime = currentTime.format(formatter);
                            // Print the current time 
                            System.out.println("Current time is: " + formattedTime);

                            String quary = "SELECT * FROM `class` INNER JOIN `teacher` ON `class`.`Teacher_Tno` = `teacher`.`Tno` "
                                    + "INNER JOIN `timeslot` ON `class`.`TimeSlot_id` = `timeslot`.`id` "
                                    + "INNER JOIN `subject` ON `class`.`Subject_Subno` = `subject`.`Subno` "
                                    + "INNER JOIN `dates` ON `timeslot`.`Dates_id` = `dates`.`id` "
                                    + "WHERE `timeslot`.`start` < STR_TO_DATE(?, '%H:%i:%s') AND `timeslot`.`end` > STR_TO_DATE(?, '%H:%i:%s')  ";

                            try {
                                ResultSet result = MySQL.executeSelect(quary, formattedTime, formattedTime);

                                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                                model.setRowCount(0);
                                while (result.next()) {

                                    Vector<String> vector = new Vector();
                                    vector.add(result.getString("class.ClassNo"));
                                    vector.add(result.getString("subject.name"));
                                    vector.add(result.getString("teacher.Name"));
                                    vector.add(result.getString("dates.date") + " / " + result.getString("timeslot.start") + " - " + result.getString("timeslot.end"));
                                    model.addRow(vector);

                                }
                                jTable1.setModel(model);
                                System.out.println("NO");

                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            loadTodayClasses();
                        }
//                + "WHERE (`subject`.`name` LIKE ? AND `class`.`status_id` = '1' AND `dates`.`date` LIKE ? ) OR "
//                + "(`class`.`ClassNo` = ? AND `class`.`status_id` = '1' AND `dates`.`date` LIKE ? ) OR (`teacher`.`Name` LIKE ? AND `class`.`status_id` = '1' AND `dates`.`date` LIKE ? )";
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            System.out.println(ex.getMessage());
                        }

                    }
                }
            }
            );

            updateWorker.start();
        }
    }
    ///Create Worker for update Live Class Table

    //load Today Classes
    private void loadTodayClasses() {
// Get the current date 
        LocalDate currentDate = LocalDate.now();
// Get the day of the week 
        String dayOfWeek = currentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        String searchTxt = jTextField2.getText();

        String quary = "SELECT * FROM `class` INNER JOIN `teacher` ON `class`.`Teacher_Tno` = `teacher`.`Tno` "
                + "INNER JOIN `timeslot` ON `class`.`TimeSlot_id` = `timeslot`.`id` "
                + "INNER JOIN `subject` ON `class`.`Subject_Subno` = `subject`.`Subno` "
                + "INNER JOIN `dates` ON `timeslot`.`Dates_id` = `dates`.`id` "
                + "WHERE (`subject`.`name` LIKE ? AND `class`.`status_id` = '1' AND `dates`.`date` LIKE ? ) OR "
                + "(`class`.`ClassNo` = ? AND `class`.`status_id` = '1' AND `dates`.`date` LIKE ? ) OR (`teacher`.`Name` LIKE ? AND `class`.`status_id` = '1' AND `dates`.`date` LIKE ? )";

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        try {
            ResultSet result = MySQL.executeSelect(quary, "%" + searchTxt + "%", "%" + dayOfWeek + "%", searchTxt, "%" + dayOfWeek + "%", "%" + searchTxt + "%", "%" + dayOfWeek + "%");

            while (result.next()) {
                Vector<String> vector = new Vector();
                vector.add(result.getString("class.ClassNo"));
                vector.add(result.getString("subject.name"));
                vector.add(result.getString("teacher.Name"));
                vector.add(result.getString("dates.date") + " / " + result.getString("timeslot.start") + " - " + result.getString("timeslot.end"));
                model.addRow(vector);
            }
            jTable1.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //load Today Classes

    //Load All Class
    private void loadAllClass() {

        String searchTxt = jTextField3.getText();

        String quary = "SELECT * FROM `class` INNER JOIN `teacher` ON `class`.`Teacher_Tno` = `teacher`.`Tno` "
                + "INNER JOIN `timeslot` ON `class`.`TimeSlot_id` = `timeslot`.`id` "
                + "INNER JOIN `subject` ON `class`.`Subject_Subno` = `subject`.`Subno` "
                + "INNER JOIN `dates` ON `timeslot`.`Dates_id` = `dates`.`id` "
                + "WHERE (`subject`.`name` LIKE ? AND `class`.`status_id` = '1') OR "
                + "(`class`.`ClassNo` = ? AND `class`.`status_id` = '1') OR (`teacher`.`Name` LIKE ? AND `class`.`status_id` = '1')";

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        try {
            ResultSet result = MySQL.executeSelect(quary, "%" + searchTxt + "%", searchTxt, "%" + searchTxt + "%");

            while (result.next()) {
                Vector<String> vector = new Vector();
                vector.add(result.getString("class.ClassNo"));
                vector.add(result.getString("subject.name"));
                vector.add(result.getString("teacher.Name"));
                vector.add(result.getString("dates.date") + " / " + result.getString("timeslot.start") + " - " + result.getString("timeslot.end"));
                model.addRow(vector);
                subjectPriceMap.put(result.getString("subject.name"), result.getString("subject.Price"));
            }
            jTable2.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
//Load All Class

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 48)); // NOI18N
        jLabel1.setText("Class");

        jButton1.setText("Register New Class");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jList1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel2.setText("Students");

        jTextField1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ClassNo", "Subject", "Teacher", "TimeSlot"
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
        jScrollPane2.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel3.setText("All Class");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ClassNo", "Subject", "Teacher", "TimeSlot"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel4.setText("Today Class");

        jLabel5.setText("Search :");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jLabel6.setText("Search :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active Class", "Today Class" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(95, 95, 95)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        RegisterNewClass registerNewClass = new RegisterNewClass(SplashWindow.spalshWindow, true, this);
        registerNewClass.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        loadAllClass();
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        loadTodayClasses();
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        int row = jTable2.getSelectedRow();

        if (evt.getClickCount() == 2) {

            if (jList1.getSelectedIndex() < 0) {
                JOptionPane.showMessageDialog(this, "Please Select Student first", "Warnning", JOptionPane.WARNING_MESSAGE);
            } else if (row < 0) {
                JOptionPane.showMessageDialog(this, "Class not Selected.", "Warnning", JOptionPane.WARNING_MESSAGE);
            } else {
                AddStudentToClass addStudentToClass = new AddStudentToClass(SplashWindow.spalshWindow, true, this);
                addStudentToClass.setVisible(true);
            }

        }

    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        if (evt.getClickCount() == 2) {
            perent.classTreadWorking = false;
            System.out.println(Thread.currentThread().getName());

            MarkAttendancePanel markAttendance = new MarkAttendancePanel(SplashWindow.spalshWindow, false, this);
            markAttendance.setVisible(true);

        } else {
            perent.classTreadWorking = true;
            haveThread = false;
            startWorkerUpdateTable();
        }

    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    javax.swing.JTable jTable1;
    javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
