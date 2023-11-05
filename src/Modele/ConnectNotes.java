/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectNotes {
    Connexion co=new Connexion();
    PreparedStatement ps;
    public ResultSet rs;
    public ConnectNotes(String mat) {
        try {
            ps=co.conectBdd().prepareStatement
        ("select * from notes where matricule=?");
            ps.setString(1, mat);
            rs=ps.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectNotes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
