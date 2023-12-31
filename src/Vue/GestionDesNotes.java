/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.ConnectNotes;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Contoleur.*;
import java.text.*;

/**
 *
 * @author LENOVO
 */
public class GestionDesNotes extends javax.swing.JFrame {
    
    ConnectNotes cn;
    DefaultTableModel dt = new DefaultTableModel();
    
    public GestionDesNotes() {
        initComponents();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        lnom.setText(GestionStagiaires.tnom.getText()
                + "  " + GestionStagiaires.tprenom.getText());
        lmat.setText(GestionStagiaires.lmat.getText());
        cn = new ConnectNotes(lmat.getText());
        dt.addColumn("langage");
        dt.addColumn("note");
        dt.addColumn("coefficient");
        try {
            while (cn.rs.next()) {
                dt.addRow(new Object[]{cn.rs.getString("langage"),
                    cn.rs.getFloat("note"), cn.rs.getInt("coefficient")});
                
            }
            tablenote.setModel(dt);
            float n1 = (float) tablenote.getValueAt(0, 1), n2 = (float) tablenote.getValueAt(1, 1);
            int c1 = (int) tablenote.getValueAt(0, 2), c2 = (int) tablenote.getValueAt(1, 2);
            DecimalFormat df = new DecimalFormat("#.##");
            lmoy.setText(df.format(Calcul.moy(n1, c1, n2, c2)) + "");
            lmention.setText(Calcul.mention(Calcul.moy(n1, c1, n2, c2)));
            ldc.setText(Calcul.decision(Calcul.moy(n1, c1, n2, c2)));
        } catch (SQLException ex) {
            Logger.getLogger(GestionDesNotes.class.getName()).log(Level.SEVERE, null, ex);
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

        lmr = new javax.swing.JLabel();
        lnom = new javax.swing.JLabel();
        lmat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablenote = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lmoy = new javax.swing.JLabel();
        lmention = new javax.swing.JLabel();
        ldc = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lmr.setText("Mr / Mme :");
        getContentPane().add(lmr, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        lnom.setText("........");
        getContentPane().add(lnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 110, -1));

        lmat.setText(".........");
        getContentPane().add(lmat, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 120, 20));

        tablenote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablenote);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 290, 100));

        jLabel2.setText("Moyenne :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel3.setText("Mention :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel4.setText("Decision :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        lmoy.setText("...........");
        getContentPane().add(lmoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 90, -1));

        lmention.setText("..........");
        getContentPane().add(lmention, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 90, -1));

        ldc.setText("..........");
        getContentPane().add(ldc, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 80, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AuthentificationFond.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GestionDesNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionDesNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionDesNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionDesNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionDesNotes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel ldc;
    private javax.swing.JLabel lmat;
    private javax.swing.JLabel lmention;
    private javax.swing.JLabel lmoy;
    private javax.swing.JLabel lmr;
    private javax.swing.JLabel lnom;
    private javax.swing.JTable tablenote;
    // End of variables declaration//GEN-END:variables
}
