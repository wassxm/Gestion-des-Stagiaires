/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class ConnectStagiaire {
    
    Connexion co=new Connexion();
    PreparedStatement ps;
    public ResultSet rs;
    public ConnectStagiaire() {
        try {
            ps=co.conectBdd().prepareStatement("select * from stagiaires");
            rs=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectStagiaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
