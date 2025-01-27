package gui;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.MySQL;
import raven.toast.Notifications;

public class RegisterNewClass extends javax.swing.JDialog {

    private ClassPanel classPanel;

    HashMap<String, String> daysMap = new HashMap<>();
    HashMap<String, String> teacherMap = new HashMap<>();
    HashMap<String, String> subjectMap = new HashMap<>();

    public RegisterNewClass(java.awt.Frame parent, boolean modal, ClassPanel classPanel) {
        super(parent, modal);
        initComponents();
        this.classPanel = classPanel;
        loadTearchers();
        loadSubjects();
        loadWeekDays();
    }

    //Load Week Days
    private void loadWeekDays() {
        String quary = "SELECT * FROM `dates`";
        try {
            ResultSet result = MySQL.executeSelect(quary);
            Vector<String> vector = new Vector();
            vector.add("Select");
            while (result.next()) {
                vector.add(result.getString("dates.date"));
                daysMap.put(result.getString("dates.date"), result.getString("dates.id"));
            }
            jComboBox1.setModel(new DefaultComboBoxModel(vector));
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    //Load Week Days

    //Load Subjects
    private void loadSubjects() {
        String searchTxt = jTextField2.getText();

        String quary = "SELECT `subject`.`Subno`, `subject`.`name`,`subject`.`Description` FROM  `subject` "
                + "WHERE (`subject`.`name` LIKE ? AND `subject`.`status_id` = '1') OR (`subject`.`Subno` LIKE ? AND `subject`.`status_id` = '1') ";

        try {

            ResultSet result = MySQL.executeSelect(quary, "%" + searchTxt + "%", "%" + searchTxt + "%");

            DefaultListModel model = new DefaultListModel();

            while (result.next()) {
                model.addElement(result.getString("subject.Subno") + " / " + result.getString("subject.name") + " / " + result.getString("subject.Description"));
                subjectMap.put(result.getString("subject.Subno") + " / " + result.getString("subject.name") + " / " + result.getString("subject.Description"), result.getString("subject.Subno"));
            }
            jList2.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //Load Subjects

    //Load teachers To JList
    private void loadTearchers() {
        String searchText = jTextField1.getText();
        String quary = "SELECT `teacher`.`Tno`, `teacher`.`Name` FROM `teacher` WHERE "
                + "(`teacher`.`Tno` LIKE ? AND `teacher`.`status_id` = '1') OR (`teacher`.`Name` LIKE ? AND `teacher`.`status_id` = '1')";

        try {
            ResultSet result = MySQL.executeSelect(quary, "%" + searchText + "%", "%" + searchText + "%");

            DefaultListModel model = new DefaultListModel();

            while (result.next()) {
                model.addElement(result.getString("teacher.Tno") + " / " + result.getString("teacher.Name"));
                teacherMap.put(result.getString("teacher.Tno") + " / " + result.getString("teacher.Name"), result.getString("teacher.Tno"));
            }

            jList1.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//Load teachers To JList

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jTimeChooserDemo1 = new lu.tudor.santec.jtimechooser.demo.JTimeChooserDemo();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTimeChooser1 = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTimeChooser2 = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jButton1 = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Regisater New Class");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jList1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setText("Teacher");

        jTextField1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setText("Start Time :");

        jList2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setText("Subject");

        jTextField2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setText("Day :");

        jComboBox1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel6.setText("End Time :");

        jButton1.setText("Sava");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(357, 357, 357))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTimeChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTimeChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(14, 14, 14))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTimeChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTimeChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jButton1)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
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

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        loadTearchers();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased

        loadSubjects();

    }//GEN-LAST:event_jTextField2KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jComboBox1.getSelectedItem().equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select The Day in Class.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (jList2.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Please Select The Subject.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (jList1.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Please Select The Teacher.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (jTimeChooser1.getTimeField().getText().equals("00:00:00")) {
            JOptionPane.showMessageDialog(this, "Please Enter Tha Class Start Time.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (jTimeChooser2.getTimeField().getText().equals("00:00:00")) {
            JOptionPane.showMessageDialog(this, "Please Enter Tha Class End Time.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            String startTime = jTimeChooser1.getFormatedTime();
            String endTime = jTimeChooser2.getFormatedTime();
            String subjectID = subjectMap.get(jList2.getSelectedValue());
            String teacherID = teacherMap.get(jList1.getSelectedValue());
            String dateID = daysMap.get(jComboBox1.getSelectedItem());
            int timeSlotId = 0;
            String timeSlotQuary = "SELECT * FROM `timeslot` WHERE `timeslot`.`start` = ? AND `timeSlot`.`end` = ? AND `timeSlot`.`Dates_id` = ?";

            try {
                ResultSet result = MySQL.executeSelect(timeSlotQuary, startTime, endTime, dateID);

                if (result.next()) {
                    timeSlotId = result.getInt("timeSlot.id");
                } else {

                    String addTimeSlotQuary = "INSERT INTO `timeSlot` (`start`,`end`,`Dates_id`) VALUES (?,?,?)";
                    timeSlotId = MySQL.executeUpdate(addTimeSlotQuary, startTime, endTime, dateID);

                    Notifications.getInstance().setJFrame(SplashWindow.spalshWindow);
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, 10000, "New Time Slot Registed Success.");

                }
                System.out.println(timeSlotId);
                String searchQuary = "SELECT * FROM `class` WHERE `class`.`Subject_Subno` = ? AND `class`.`Teacher_Tno` = ? AND `class`.`TimeSlot_id` = ?";

                ResultSet classResult = MySQL.executeSelect(searchQuary, subjectID, teacherID, timeSlotId);

                if (classResult.next()) {
                    if (classResult.getInt("class.status_id") == 2) {
                        int condition = JOptionPane.showConfirmDialog(this, "This Class is Alredy in tha Database. But It Deactivated. Do You Need to Active It ?", "Alert", JOptionPane.INFORMATION_MESSAGE);
                        if (condition == JOptionPane.YES_OPTION) {
                            String activateClassQuary = "UPDATE `class` SET `class`.`status_id` = '1' WHERE `class`.`id` = ?";
                            try {
                                MySQL.executeUpdate(activateClassQuary, classResult.getString("class.id"));
                            } catch (SQLException e) {
                                if (e.getMessage().startsWith("Creating")) {
                                    Notifications.getInstance().setJFrame(SplashWindow.spalshWindow);
                                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, 10000, "Class Activated Successfull.");
                                    this.dispose();
                                } else {
                                    Notifications.getInstance().setJFrame(SplashWindow.spalshWindow);
                                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, 10000, "Class Activating Fail Please Try Again.");
                                    this.dispose();
                                }
                            }
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "This Class Alredy Registerd. Please Check Again.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    String addNewClassQuary = "INSERT INTO `class` (`Subject_Subno`,`Teacher_Tno`,`TimeSlot_id`,`status_id`) VALUES (?,?,?,'1')";
                    try {
                        MySQL.executeUpdate(addNewClassQuary, subjectID, teacherID, timeSlotId);

                        Notifications.getInstance().setJFrame(SplashWindow.spalshWindow);
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.BOTTOM_RIGHT, 10000, "Class Registed Success.");
                        this.dispose();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());

                        if (e.getMessage().startsWith("Creating")) {

                        } else {
                            Notifications.getInstance().setJFrame(SplashWindow.spalshWindow);
                            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, 10000, "Class registration fail. :" + e.getMessage());
                        }
                    }
                }

            } catch (SQLException e) {

                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private lu.tudor.santec.jtimechooser.JTimeChooser jTimeChooser1;
    private lu.tudor.santec.jtimechooser.JTimeChooser jTimeChooser2;
    private lu.tudor.santec.jtimechooser.demo.JTimeChooserDemo jTimeChooserDemo1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
