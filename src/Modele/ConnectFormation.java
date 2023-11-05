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
public class ConnectFormation {
    Connexion co=new Connexion();
    PreparedStatement ps;
    public ResultSet rs;

    public ConnectFormation() {
        try {
            ps=co.conectBdd().prepareStatement("select intitule from formation");
            rs=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectFormation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
