/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contoleur;

public class Calcul {

    public static float moy(float note1, int coef1, float note2, int coef2) {
        float m = ((note1 * coef1) + (note2 * coef2)) / (coef1 + coef2);
        return m;
    }

    public static String mention(float moy) {
        String m = null;
        if (moy < 10) {
            m = "Insuffisant";

        } else if (moy >= 10 && moy < 12) {
            m = "Passable";
        } else if (moy >= 12 && moy < 14) {
            m = "Assez bien";

        } else if (moy >= 14 && moy < 16) {
            m = "Bien";
        } else if (moy >= 16 && moy < 18) {
            m = "Tres bien";
        } else if (moy >= 18 && moy < 20) {
            m = "Excellent";
        }

        return m;
    }

    public static String decision(float moy) {
        String d = null;
        if (moy >= 10) {
            d = "Admis";
        } else {
            d = "Ajourné";
        }
        return d;
    }

}
