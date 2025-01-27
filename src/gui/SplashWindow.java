package gui;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SplashWindow extends javax.swing.JFrame {

    public static SplashWindow spalshWindow;

    /**
     * Creates new form SplashWindow
     */
    public SplashWindow() {
        initComponents();
        lodingProgressAnimation();
    }

    private void lodingProgressAnimation() {

        hedingPanel.setVisible(false);

        SpalshLogoPanel logo = new SpalshLogoPanel();
        jPanel1.add(logo, BorderLayout.NORTH);
        SwingUtilities.updateComponentTreeUI(jPanel1);

        Thread lodingThread = new Thread(new Runnable() {
            public void run() {
                for (int x = 0; x <= 100; x++) {

                    jProgressBar1.setValue(x);

                    switch (x) {

                        case 10:
                            LoadingTxt.setText("Connecting to Inernet . . .");
                            break;

                        case 15:
                            LoadingTxt.setText("Connected to the Inernet");
                            break;

                        case 18:
                            LoadingTxt.setText("Loding Files . . .");
                            break;

                        case 23:
                            LoadingTxt.setText("File Loaded");
                            break;

                        case 25:
                            LoadingTxt.setText("Finding Libraries . . . .");
                            break;

                        case 30:
                            LoadingTxt.setText("Loading Libraries . . . .");
                            break;

                        case 40:
                            LoadingTxt.setText("Libraries Completely Loaded.");
                            break;

                        case 45:
                            LoadingTxt.setText("Loding Resourses . . .");
                            break;

                        case 55:
                            LoadingTxt.setText("Resorses Loaded");
                            break;

                        case 60:
                            LoadingTxt.setText("Connectiong to Database . ");
                            break;

                        case 61:
                            LoadingTxt.setText("Connectiong to Database . . ");
                            break;

                        case 62:
                            LoadingTxt.setText("Connectiong to Database . . . ");
                            break;

                        case 63:
                            LoadingTxt.setText("Connectiong to Database . . . . ");
                            break;

                        case 64:
                            LoadingTxt.setText("Connectiong to Database . ");
                            break;

                        case 65:
                            LoadingTxt.setText("Connectiong to Database . . ");
                            break;

                        case 66:
                            LoadingTxt.setText("Connectiong to Database . . . ");
                            break;

                        case 67:
                            LoadingTxt.setText("Connectiong to Database . . . . ");
                            break;

                        case 68:
                            LoadingTxt.setText("Connectiong to Database . ");
                            break;

                        case 69:
                            LoadingTxt.setText("Connectiong to Database . . ");
                            break;

                        case 70:
                            LoadingTxt.setText("Connectiong to Database . . . ");
                            break;

                        case 71:
                            LoadingTxt.setText("Connectiong to Database . . . . ");
                            break;

                        case 72:
                            LoadingTxt.setText("Connectiong to Database . ");
                            break;

                        case 73:
                            LoadingTxt.setText("Connectiong to Database . . ");
                            break;

                        case 74:
                            LoadingTxt.setText("Connectiong to Database . . . ");
                            break;

                        case 75:
                            LoadingTxt.setText("Connectiong to Database . . . . ");
                            break;

                        case 76:
                            LoadingTxt.setText("Connectiong to Database . ");
                            break;

                        case 77:
                            LoadingTxt.setText("Connectiong to Database . . ");
                            break;

                        case 78:
                            LoadingTxt.setText("Connectiong to Database . . . ");
                            break;

                        case 79:
                            LoadingTxt.setText("Connectiong to Database . . . . ");
                            break;

                        case 80:
                            LoadingTxt.setText("Connectiong to Database . ");
                            break;

                        case 81:
                            LoadingTxt.setText("Connectiong to Database . . ");
                            break;

                        case 82:
                            LoadingTxt.setText("Connectiong to Database . . . ");
                            break;

                        case 83:
                            LoadingTxt.setText("Connectiong to Database . . . . ");
                            break;

                        case 84:
                            LoadingTxt.setText("Connectiong to Database . ");
                            break;

                        case 85:
                            LoadingTxt.setText("Connectiong to Database . . ");
                            break;

                        case 86:
                            LoadingTxt.setText("Connectiong to Database . . . ");
                            break;

                        case 87:
                            LoadingTxt.setText("Connectiong to Database . . . . ");
                            break;

                        case 88:
                            LoadingTxt.setText("Connectiong to Database . ");
                            break;

                        case 89:
                            LoadingTxt.setText("Connectiong to Database . . ");
                            break;

                        case 90:
                            LoadingTxt.setText("Connectiong to Database . . . ");
                            break;

                        case 91:
                            LoadingTxt.setText("Connectiong to Database . . . . ");
                            break;

                        case 92:
                            LoadingTxt.setText("Connectiong to Database . ");
                            break;

                        case 93:
                            LoadingTxt.setText("Connectiong to Database . . ");
                            break;

                        case 94:
                            LoadingTxt.setText("Connectiong to Database . . . ");
                            break;

                        case 95:
                            LoadingTxt.setText("Connectiong to Database . . . . ");
                            break;

                        case 96:
                            LoadingTxt.setText("Connectiong to Database . ");
                            break;

                        case 97:
                            LoadingTxt.setText("Connectiong to Database . . ");
                            break;

                        case 98:
                            LoadingTxt.setText("Successfully Connected to Database.");
                            break;

                        case 99:
                            LoadingTxt.setText("Done  ");
                            break;

                    }

                    try {
                        Thread.sleep(10);  ///// loading time
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                afterLoading();
            }

        });
        lodingThread.start();
    }

    private void afterLoading() {

        jPanel1.removeAll();
        hedingPanel.setVisible(true);
        SignInPanel signIn = new SignInPanel();
        jPanel1.add(signIn, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(jPanel1);

        jPanel3.setVisible(false);

    }
    
    
    public JPanel getPerentPanel(){
        return jPanel1;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        hedingPanel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        LoadingTxt = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        hedingPanel.setFont(new java.awt.Font("Poppins", 1, 48)); // NOI18N
        hedingPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hedingPanel.setText("Adyapana Institute");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hedingPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hedingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        LoadingTxt.setText("Loading . . . ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(LoadingTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 370, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(LoadingTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                spalshWindow = new SplashWindow();
                spalshWindow.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LoadingTxt;
    private javax.swing.JLabel hedingPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
