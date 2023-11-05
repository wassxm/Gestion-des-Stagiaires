package Modele;

import javax.swing.JOptionPane;
import java.sql.*;

public class Connexion {

    Connection co;

    public Connexion() {
        //connexion au serveur de base de donnee 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //JOptionPane.showMessageDialog(null, "connexion au serveur faite avec succes");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Echec de connexion au serveur" + e.getMessage());
        }
        //connexion a la base de donnee
        try {
            co = DriverManager.getConnection("jdbc:mysql://localhost:3306/geststagiaire", "root", "");
            //JOptionPane.showMessageDialog(null, "connexion a la base de donnee est faite avec succes");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Echec de connexion a la base de donnee" + e.getMessage());

        }
    }

    public Connection conectBdd() {

        return co;
    }

    public static void main(String[] args) {
        Connexion cn = new Connexion();
        cn.conectBdd();
    }

}
