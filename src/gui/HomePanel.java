package gui;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingUtilities;

/**
 *
 * @author User
 */
public class HomePanel extends javax.swing.JPanel {

    private int selectedPanel;

    boolean classTreadWorking;

    /**
     * Creates new form HomePanel
     */
    public HomePanel() {
        System.out.println("1");
        initComponents();
        System.out.println("2");
        rondEges();
        System.out.println("3");
    }

    private void rondEges() {
        jPanel3.putClientProperty(FlatClientProperties.STYLE, "arc:10");
        jPanel4.putClientProperty(FlatClientProperties.STYLE, "arc:10");
        jPanel5.putClientProperty(FlatClientProperties.STYLE, "arc:10");
        jPanel6.putClientProperty(FlatClientProperties.STYLE, "arc:10");
        jPanel7.putClientProperty(FlatClientProperties.STYLE, "arc:10");
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(5, 1, 0, 10));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sudents");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Subject");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Teacher");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Payments");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Class");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7);

        jPanel2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 216, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered

        selectStudent();

    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited

        unSelectStudent();
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        selectSubject();
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        unSelectSubject();
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered

        selectTeacher();

    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        unSelectTeacher();
    }//GEN-LAST:event_jPanel5MouseExited

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered

        selectPayments();

    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited

        unSelectPayments();
    }//GEN-LAST:event_jPanel6MouseExited

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered

        selectClass();

    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited

        unSelectClass();
    }//GEN-LAST:event_jPanel7MouseExited

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked

        loadStudentPanel();

    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked

        loadSubjectPanel();

    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        loadTeachertPanel();
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        loadPaymentPanel();
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked

        loadClassPanel();

    }//GEN-LAST:event_jPanel7MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    //Student
    void selectStudent() {
        jLabel1.setFont(new Font("poppins", Font.BOLD, 14));
        jPanel3.setBackground(Color.GRAY);
        jLabel1.setForeground(Color.WHITE);
    }

    private void unSelectStudent() {
        if (selectedPanel != 1) {
            jLabel1.setFont(new Font("poppins", Font.PLAIN, 14));
            jPanel3.setBackground(Color.WHITE);
            jLabel1.setForeground(Color.BLACK);
        }
    }

    private void loadStudentPanel() {

        System.out.println(selectedPanel);
        switch (selectedPanel) {
            case 0:

                break;

            case 2:
                jLabel3.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel4.setBackground(Color.WHITE);
                jLabel2.setForeground(Color.BLACK);
                break;

            case 3:
                jLabel3.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel5.setBackground(Color.WHITE);
                jLabel3.setForeground(Color.BLACK);
                break;

            case 4:
                jLabel4.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel6.setBackground(Color.WHITE);
                jLabel4.setForeground(Color.BLACK);
                break;

            case 5:
                jLabel5.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel7.setBackground(Color.WHITE);
                jLabel5.setForeground(Color.BLACK);
                break;

        }
        System.out.println(selectedPanel);
        selectedPanel = 0;

        jPanel2.removeAll();
        ClassPanel.haveThread = false;
        this.classTreadWorking = false;
        StudentsPanel studentPanel = new StudentsPanel(this);
        jPanel2.add(studentPanel, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel2);

        selectedPanel = 1;
    }
    //Student

    //Subject
    private void selectSubject() {
        jLabel2.setFont(new Font("poppins", Font.BOLD, 14));
        jPanel4.setBackground(Color.GRAY);
        jLabel2.setForeground(Color.WHITE);
    }

    private void unSelectSubject() {
        if (selectedPanel != 2) {
            jLabel2.setFont(new Font("poppins", Font.PLAIN, 14));
            jPanel4.setBackground(Color.WHITE);
            jLabel2.setForeground(Color.BLACK);
        }
    }

    private void loadSubjectPanel() {

        switch (selectedPanel) {
            case 0:

                break;

            case 1:
                jLabel1.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel3.setBackground(Color.WHITE);
                jLabel1.setForeground(Color.BLACK);
                break;

            case 3:
                jLabel3.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel5.setBackground(Color.WHITE);
                jLabel3.setForeground(Color.BLACK);
                break;

            case 4:
                jLabel4.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel6.setBackground(Color.WHITE);
                jLabel4.setForeground(Color.BLACK);
                break;

            case 5:
                jLabel5.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel7.setBackground(Color.WHITE);
                jLabel5.setForeground(Color.BLACK);
                break;

        }

        selectedPanel = 0;

        jPanel2.removeAll();
        this.classTreadWorking = false;
        ClassPanel.haveThread = false;
        SubjectPanel subjectPanel = new SubjectPanel(this);
        jPanel2.add(subjectPanel, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel2);

        selectedPanel = 2;
    }
//Subject

    //Teacher
    private void selectTeacher() {
        jLabel3.setFont(new Font("poppins", Font.BOLD, 14));
        jPanel5.setBackground(Color.GRAY);
        jLabel3.setForeground(Color.WHITE);
    }

    private void unSelectTeacher() {
        if (selectedPanel != 3) {
            jLabel3.setFont(new Font("poppins", Font.PLAIN, 14));
            jPanel5.setBackground(Color.WHITE);
            jLabel3.setForeground(Color.BLACK);
        }
    }

    private void loadTeachertPanel() {

        switch (selectedPanel) {
            case 0:

                break;

            case 1:
                jLabel1.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel3.setBackground(Color.WHITE);
                jLabel1.setForeground(Color.BLACK);
                break;

            case 2:
                jLabel3.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel4.setBackground(Color.WHITE);
                jLabel2.setForeground(Color.BLACK);
                break;

            case 4:
                jLabel4.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel6.setBackground(Color.WHITE);
                jLabel4.setForeground(Color.BLACK);
                break;

            case 5:
                jLabel5.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel7.setBackground(Color.WHITE);
                jLabel5.setForeground(Color.BLACK);
                break;

        }

        selectedPanel = 0;

        jPanel2.removeAll();
        this.classTreadWorking = false;
        ClassPanel.haveThread = false;
        TeacherPanel teacherPanel = new TeacherPanel(this);
        jPanel2.add(teacherPanel, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel2);

        selectedPanel = 3;
    }
//Teacher

    //Payment
    private void selectPayments() {
        jLabel4.setFont(new Font("poppins", Font.BOLD, 14));
        jPanel6.setBackground(Color.GRAY);
        jLabel4.setForeground(Color.WHITE);
    }

    private void unSelectPayments() {
        if (selectedPanel != 4) {
            jLabel4.setFont(new Font("poppins", Font.PLAIN, 14));
            jPanel6.setBackground(Color.WHITE);
            jLabel4.setForeground(Color.BLACK);
        }
    }

    private void loadPaymentPanel() {

        switch (selectedPanel) {
            case 0:

                break;

            case 1:
                jLabel1.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel3.setBackground(Color.WHITE);
                jLabel1.setForeground(Color.BLACK);
                break;

            case 2:
                jLabel3.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel4.setBackground(Color.WHITE);
                jLabel2.setForeground(Color.BLACK);
                break;

            case 3:
                jLabel3.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel5.setBackground(Color.WHITE);
                jLabel3.setForeground(Color.BLACK);
                break;

            case 5:
                jLabel5.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel7.setBackground(Color.WHITE);
                jLabel5.setForeground(Color.BLACK);
                break;

        }

        selectedPanel = 0;

        jPanel2.removeAll();
        this.classTreadWorking = false;
        ClassPanel.haveThread = false;
        PaymentPanel paymentPanel = new PaymentPanel(this);
        jPanel2.add(paymentPanel, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel2);

        selectedPanel = 4;
    }
//Payment

    //Class
    private void selectClass() {
        jLabel5.setFont(new Font("poppins", Font.BOLD, 14));
        jPanel7.setBackground(Color.GRAY);
        jLabel5.setForeground(Color.WHITE);
    }

    private void unSelectClass() {
        if (selectedPanel != 5) {
            jLabel5.setFont(new Font("poppins", Font.PLAIN, 14));
            jPanel7.setBackground(Color.WHITE);
            jLabel5.setForeground(Color.BLACK);
        }
    }

    private void loadClassPanel() {

        switch (selectedPanel) {
            case 0:

                break;

            case 1:
                jLabel1.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel3.setBackground(Color.WHITE);
                jLabel1.setForeground(Color.BLACK);
                break;

            case 2:
                jLabel3.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel4.setBackground(Color.WHITE);
                jLabel2.setForeground(Color.BLACK);
                break;

            case 3:
                jLabel3.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel5.setBackground(Color.WHITE);
                jLabel3.setForeground(Color.BLACK);
                break;

            case 4:
                jLabel4.setFont(new Font("poppins", Font.PLAIN, 14));
                jPanel6.setBackground(Color.WHITE);
                jLabel4.setForeground(Color.BLACK);
                break;

        }

        selectedPanel = 0;

        jPanel2.removeAll();
        this.classTreadWorking = true;
//        ClassPanel.haveThread = true;
        ClassPanel paymentPanel = new ClassPanel(this);
        jPanel2.add(paymentPanel, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel2);

        selectedPanel = 5;
    }
    //Class

}
