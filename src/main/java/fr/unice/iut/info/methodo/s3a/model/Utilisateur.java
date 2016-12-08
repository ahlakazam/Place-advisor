package fr.unice.iut.info.methodo.s3a.model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
<<<<<<< HEAD
 * Created by axelm on 15/11/2016.
 */
public class Utilisateur implements Serializable {

    private String email;
    private String pseudo;
    private String mdp;
    private ArrayList<Itinineraire> tabIti;



    public Utilisateur (String email, String pseudo, String mdp){
        this.email = email;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.tabIti = new ArrayList<Itinineraire>();
    }


    public void creerFichier() throws IOException {
        File fichier =  new File("./Sauv/Utilisateur.ser");

        HashMap<String,Utilisateur> tab = new HashMap<String, Utilisateur>();

        ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
        oos.writeObject(tab);

    }

    public void save() throws IOException, ClassNotFoundException {

        File fichier =  new File("./Sauv/Utilisateur.ser");

        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(fichier));

        HashMap <String,Utilisateur> tab;
        tab = (HashMap<String, Utilisateur>) ooi.readObject();
        tab.put(this.getPseudo(),this);
        ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
        oos.writeObject(tab);

    }

    public static HashMap<String,Utilisateur> read() throws IOException, ClassNotFoundException {
        File fichier =  new File("./Sauv/Utilisateur.ser") ;

        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(fichier));

        HashMap <String,Utilisateur> tab;
        tab = (HashMap<String, Utilisateur>) ooi.readObject();
        return tab;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public ArrayList<Itinineraire> getTabIti() {
        return tabIti;
    }

    public void setTabIti(ArrayList<Itinineraire> tabIti) {
        this.tabIti = tabIti;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "email='" + email + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}
