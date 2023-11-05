/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.text.SimpleDateFormat;
import Modele.*;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class GestionStagiaires extends javax.swing.JFrame {

    /**
     * Creates new form GestionStagiaires
     */
    ConnectFormation cf = new ConnectFormation();
    ConnectStagiaire cs = new ConnectStagiaire();
    Connexion co = new Connexion();
    PreparedStatement ps;
    DefaultTableModel dt = new DefaultTableModel();
    
    public GestionStagiaires() {
        initComponents();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        
        
        try {
            while (cf.rs.next()) {
                cbformation.addItem(cf.rs.getString("intitule"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionStagiaires.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualiser() {
        dt.setColumnCount(0);
        dt.setRowCount(0);
        dt.addColumn("matricule");
        dt.addColumn("Nom");
        dt.addColumn("Prenom");
        dt.addColumn("Date de naissance");
        dt.addColumn("Adress");
        dt.addColumn("Formation");
        dt.addColumn("Statut");
        dt.addColumn("Photo");
        dt.addColumn("Path");
        try {
            ps = co.conectBdd().prepareStatement("select * from stagiaires");
            cs.rs = ps.executeQuery();
            while (cs.rs.next()) {
                dt.addRow(new Object[]{cs.rs.getString("matricule"),
                    cs.rs.getString("nom"), cs.rs.getString("prenom"),
                    cs.rs.getDate("daten"), cs.rs.getString("adresse"),
                    cs.rs.getString("formation"), cs.rs.getString("statut"),
                    cs.rs.getBlob("photo"), cs.rs.getString("path")});
                
            }
            tablestagiaires.setModel(dt);
        } catch (SQLException ex) {
            Logger.getLogger(GestionStagiaires.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void reset() {
        lmat.setText(null);
        tnom.setText(null);
        tprenom.setText(null);
        dcdate.setDate(null);
        tadrs.setText(null);
        cbformation.setSelectedItem("Java Devloppeur");
        if (retud.isSelected()) {
            retud.setSelected(false);
        }
        if (rpro.isSelected()) {
            rpro.setSelected(false);
        }
        lphoto.setIcon(null);
        tpath.setText(null);
    }
    
    public void select(int numligne) {
        lmat.setText(tablestagiaires.getValueAt(numligne, 0).toString());
        tnom.setText(tablestagiaires.getValueAt(numligne, 1).toString());
        tprenom.setText(tablestagiaires.getValueAt(numligne, 2).toString());
        dcdate.setDate((java.util.Date) tablestagiaires.getValueAt(numligne, 3));
        tadrs.setText(tablestagiaires.getValueAt(numligne, 4).toString());
        cbformation.setSelectedItem(tablestagiaires.getValueAt(numligne, 5));
        if (tablestagiaires.getValueAt(numligne, 6).equals("Etudiant")) {
            retud.setSelected(true);
            rpro.setSelected(false);
        }
        if (tablestagiaires.getValueAt(numligne, 6).equals("Professionel")) {
            rpro.setSelected(true);
            retud.setSelected(false);
        }
        try {
            ps = co.conectBdd().prepareStatement("select photo from stagiaires where matricule=?");
            ps.setString(1, tablestagiaires.getValueAt(numligne, 0).toString());
            cs.rs = ps.executeQuery();
            while (cs.rs.next()) {
                byte tphoto[] = cs.rs.getBytes("photo");
                ImageIcon img = new ImageIcon(tphoto);
                Image ph = img.getImage().getScaledInstance(lphoto.getWidth(), lphoto.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imgf = new ImageIcon(ph);
                lphoto.setIcon(imgf);
            }
            tpath.setText(tablestagiaires.getValueAt(numligne, 8).toString());
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionStagiaires.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String matricul(char st) {
        String mat = null, daten;
        //recuperer la date et lui aplliquer un format 
        SimpleDateFormat sdate = new SimpleDateFormat("dd/MM/yyyy");
        daten = sdate.format(dcdate.getDate());
        mat = st + tnom.getText().substring(0, 3).toUpperCase()
                + (tprenom.getText().charAt(0) + "").toUpperCase() + daten.substring(8)
                + (tablestagiaires.getRowCount() + 1);
        
        return mat;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titre = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bafficher = new javax.swing.JButton();
        bajouter = new javax.swing.JButton();
        bsupprimer = new javax.swing.JButton();
        bmodifier = new javax.swing.JButton();
        bactulliser = new javax.swing.JButton();
        bimprimer = new javax.swing.JButton();
        bfermer = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lmat = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tnom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tprenom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dcdate = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        tadrs = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbformation = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        retud = new javax.swing.JRadioButton();
        rpro = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        lphoto = new javax.swing.JLabel();
        bcharger = new javax.swing.JButton();
        tpath = new javax.swing.JTextField();
        bnotes = new javax.swing.JButton();
        bsuiv = new javax.swing.JButton();
        bprec = new javax.swing.JButton();
        bdernier = new javax.swing.JButton();
        bpremier = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbchoix = new javax.swing.JComboBox<>();
        trech = new javax.swing.JTextField();
        brech = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablestagiaires = new javax.swing.JTable();
        fond = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titre.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        titre.setForeground(new java.awt.Color(255, 255, 255));
        titre.setText("GESTION DES STAGIAIRES");
        getContentPane().add(titre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bafficher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Ouvrir.png"))); // NOI18N
        bafficher.setText("Aficher");
        bafficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bafficherActionPerformed(evt);
            }
        });
        jPanel1.add(bafficher, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 140, -1));

        bajouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Ajouter.png"))); // NOI18N
        bajouter.setText("Ajouter");
        bajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajouterActionPerformed(evt);
            }
        });
        jPanel1.add(bajouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 140, -1));

        bsupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Supprimer.png"))); // NOI18N
        bsupprimer.setText("supprimer");
        bsupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsupprimerActionPerformed(evt);
            }
        });
        jPanel1.add(bsupprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 140, -1));

        bmodifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/modifier.png"))); // NOI18N
        bmodifier.setText("Modifier");
        jPanel1.add(bmodifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 140, -1));

        bactulliser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/actualiser.PNG"))); // NOI18N
        bactulliser.setText("Actualliser");
        bactulliser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bactulliserActionPerformed(evt);
            }
        });
        jPanel1.add(bactulliser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 140, -1));

        bimprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/imprimer.png"))); // NOI18N
        bimprimer.setText("Imprimer");
        jPanel1.add(bimprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 140, -1));

        bfermer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Fermer.png"))); // NOI18N
        bfermer.setText("Fermer");
        bfermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bfermerActionPerformed(evt);
            }
        });
        jPanel1.add(bfermer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 180, 370));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "veillez renseigner les chams", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 51, 51))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Matricul :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 35, -1, -1));

        lmat.setText("...........");
        jPanel2.add(lmat, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jLabel3.setText("Nom :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        jPanel2.add(tnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 220, -1));

        jLabel4.setText("Prenom :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        tprenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tprenomActionPerformed(evt);
            }
        });
        jPanel2.add(tprenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 220, -1));

        jLabel5.setText("Date de naissance :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));
        jPanel2.add(dcdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 140, -1));

        jLabel6.setText("Adresse :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));
        jPanel2.add(tadrs, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 200, -1));

        jLabel7.setText("Formation :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        cbformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbformationActionPerformed(evt);
            }
        });
        jPanel2.add(cbformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 200, -1));

        jLabel8.setText("Statut :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        retud.setText("Etudiant");
        retud.setOpaque(false);
        retud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retudActionPerformed(evt);
            }
        });
        jPanel2.add(retud, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        rpro.setText("Professionel");
        rpro.setOpaque(false);
        rpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rproActionPerformed(evt);
            }
        });
        jPanel2.add(rpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(lphoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 130));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 140, 150));

        bcharger.setText("charger la photo");
        bcharger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bchargerActionPerformed(evt);
            }
        });
        jPanel2.add(bcharger, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, -1, -1));

        tpath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpathActionPerformed(evt);
            }
        });
        jPanel2.add(tpath, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 150, -1));

        bnotes.setText("notes");
        bnotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnotesActionPerformed(evt);
            }
        });
        jPanel2.add(bnotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 560, 270));

        bsuiv.setText(">");
        bsuiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsuivActionPerformed(evt);
            }
        });
        getContentPane().add(bsuiv, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 60, -1));

        bprec.setText("<");
        bprec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprecActionPerformed(evt);
            }
        });
        getContentPane().add(bprec, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 60, -1));

        bdernier.setText(">>");
        bdernier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdernierActionPerformed(evt);
            }
        });
        getContentPane().add(bdernier, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, -1, -1));

        bpremier.setText("<<");
        bpremier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpremierActionPerformed(evt);
            }
        });
        getContentPane().add(bpremier, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, -1));

        jLabel2.setText("Rechercher par :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, 20));

        cbchoix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nom", "Matricule" }));
        cbchoix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbchoixActionPerformed(evt);
            }
        });
        getContentPane().add(cbchoix, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        trech.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                trechFocusGained(evt);
            }
        });
        getContentPane().add(trech, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 80, -1));

        brech.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rechercher.png"))); // NOI18N
        brech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brechActionPerformed(evt);
            }
        });
        getContentPane().add(brech, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 40, 30));

        tablestagiaires.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablestagiaires.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablestagiairesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablestagiaires);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 560, 120));

        fond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/FondPetit.png"))); // NOI18N
        getContentPane().add(fond, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bsupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsupprimerActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Voullez vous vraiment supprimer",
                "Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            
            try {
                ps = co.conectBdd().prepareStatement("delete from stagiaires where matricule=?");
                ps.setString(1, lmat.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Suppression faite avec succes");
                actualiser();
                reset();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionStagiaires.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bsupprimerActionPerformed

    private void tprenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tprenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tprenomActionPerformed

    private void bsuivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsuivActionPerformed
        if (tablestagiaires.getSelectedRow() == tablestagiaires.getRowCount() - 1) {
            JOptionPane.showMessageDialog(this, "Pas de stagiaire suivant");
            reset();
        } else {
            select(tablestagiaires.getSelectedRow() + 1);
        }
    }//GEN-LAST:event_bsuivActionPerformed

    private void bpremierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpremierActionPerformed
        select(0);
    }//GEN-LAST:event_bpremierActionPerformed

    private void cbchoixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbchoixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbchoixActionPerformed

    private void retudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retudActionPerformed
        if (retud.isSelected()) {
            rpro.setSelected(false);
            lmat.setText(matricul('E'));
        }
    }//GEN-LAST:event_retudActionPerformed

    private void rproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rproActionPerformed
        if (rpro.isSelected()) {
            retud.setSelected(false);
            lmat.setText(matricul('P'));
        }
    }//GEN-LAST:event_rproActionPerformed

    private void bchargerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bchargerActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        //préciser le dossier ou se trouvent les images
        fileChooser.setCurrentDirectory(new File("C:\\Users\\LENOVO\\Desktop\\JAVA ADMIN INSTALLABLE\\Table avec images\\PHOTOS STAGIAIRES"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image", "jpg", "png", "gif");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fichierselectionne = fileChooser.getSelectedFile();
            String path = fichierselectionne.getAbsolutePath();
            ImageIcon img = new ImageIcon(path);
            Image imgrec = img.getImage();
            Image nimage = imgrec.getScaledInstance(lphoto.getWidth(),
                    lphoto.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imgfinal = new ImageIcon(nimage);
            lphoto.setIcon(imgfinal);
            tpath.setText(path);
        } else if (result == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Aucun choix effectué");
        }
    }//GEN-LAST:event_bchargerActionPerformed

    private void bajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajouterActionPerformed
        try {
            ps = co.conectBdd().prepareStatement("insert into stagiaires(matricule,nom,prenom,daten,adresse,formation,statut,photo,path)"
                    + " values (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, lmat.getText());
            ps.setString(2, tnom.getText());
            ps.setString(3, tprenom.getText());
            SimpleDateFormat sdat = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdat.format(dcdate.getDate());
            ps.setString(4, date);
            ps.setString(5, tadrs.getText());
            ps.setString(6, cbformation.getSelectedItem().toString());
            if (retud.isSelected()) {
                ps.setString(7, retud.getText());
            }
            if (rpro.isSelected()) {
                ps.setString(7, rpro.getText());
            }
            try {
                InputStream is = new FileInputStream(tpath.getText());
                ps.setBlob(8, is);
                ps.setString(9, tpath.getText());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GestionStagiaires.class.getName()).log(Level.SEVERE, null, ex);
            }
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Ajout fait avec succes ");
            actualiser();
            reset();
        } catch (SQLException ex) {
            Logger.getLogger(GestionStagiaires.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bajouterActionPerformed

    private void bafficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bafficherActionPerformed
        actualiser();
    }//GEN-LAST:event_bafficherActionPerformed

    private void tablestagiairesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablestagiairesMouseClicked
        select(tablestagiaires.getSelectedRow());
    }//GEN-LAST:event_tablestagiairesMouseClicked

    private void brechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brechActionPerformed
        dt.setRowCount(0);
        if (cbchoix.getSelectedItem().equals("Nom")) {
            try {
                ps = co.conectBdd().prepareStatement("select * from stagiaires where nom=?");
                ps.setString(1, trech.getText());
                cs.rs = ps.executeQuery();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionStagiaires.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            try {
                ps = co.conectBdd().prepareStatement("select * from stagiaires where matricule=?");
                ps.setString(1, trech.getText());
                cs.rs = ps.executeQuery();
                
            } catch (SQLException ex) {
                Logger.getLogger(GestionStagiaires.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        try {
            while (cs.rs.next()) {
                dt.addRow(new Object[]{cs.rs.getString("matricule"),
                    cs.rs.getString("nom"), cs.rs.getString("prenom"),
                    cs.rs.getDate("daten"), cs.rs.getString("adresse"),
                    cs.rs.getString("formation"), cs.rs.getString("statut"),
                    cs.rs.getBlob("photo"), cs.rs.getString("path")});
                
            }
            tablestagiaires.setModel(dt);
            if (dt.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Le stagiaire n'existe pas");
                reset();
                trech.setText(null);
                
            } else {
                JOptionPane.showMessageDialog(this, "stagiaire trouver");
                select(0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionStagiaires.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_brechActionPerformed

    private void trechFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_trechFocusGained
        actualiser();
    }//GEN-LAST:event_trechFocusGained

    private void bdernierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdernierActionPerformed
        select(tablestagiaires.getRowCount() - 1);
    }//GEN-LAST:event_bdernierActionPerformed

    private void bprecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprecActionPerformed
        if (tablestagiaires.getSelectedRow() == 0) {
            JOptionPane.showMessageDialog(this, "Pas de stagiaire precedent");
            reset();
            
        } else {
            select(tablestagiaires.getSelectedRow() - 1);
        }
    }//GEN-LAST:event_bprecActionPerformed

    private void bactulliserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bactulliserActionPerformed
       actualiser();
    }//GEN-LAST:event_bactulliserActionPerformed

    private void bfermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bfermerActionPerformed
       dispose();
    }//GEN-LAST:event_bfermerActionPerformed

    private void tpathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpathActionPerformed

    private void bnotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnotesActionPerformed
        //GestionDesNotes gn=new GestionDesNotes();
        //gn.setVisible(true);
        new GestionDesNotes().setVisible(true);
    }//GEN-LAST:event_bnotesActionPerformed

    private void cbformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbformationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbformationActionPerformed

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
            java.util.logging.Logger.getLogger(GestionStagiaires.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionStagiaires.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionStagiaires.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionStagiaires.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionStagiaires().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bactulliser;
    private javax.swing.JButton bafficher;
    private javax.swing.JButton bajouter;
    private javax.swing.JButton bcharger;
    private javax.swing.JButton bdernier;
    private javax.swing.JButton bfermer;
    private javax.swing.JButton bimprimer;
    private javax.swing.JButton bmodifier;
    private javax.swing.JButton bnotes;
    private javax.swing.JButton bprec;
    private javax.swing.JButton bpremier;
    private javax.swing.JButton brech;
    private javax.swing.JButton bsuiv;
    private javax.swing.JButton bsupprimer;
    private javax.swing.JComboBox<String> cbchoix;
    private javax.swing.JComboBox<String> cbformation;
    private com.toedter.calendar.JDateChooser dcdate;
    private javax.swing.JLabel fond;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lmat;
    private javax.swing.JLabel lphoto;
    private javax.swing.JRadioButton retud;
    private javax.swing.JRadioButton rpro;
    private javax.swing.JTable tablestagiaires;
    private javax.swing.JTextField tadrs;
    private javax.swing.JLabel titre;
    public static javax.swing.JTextField tnom;
    private javax.swing.JTextField tpath;
    public static javax.swing.JTextField tprenom;
    private javax.swing.JTextField trech;
    // End of variables declaration//GEN-END:variables
}
