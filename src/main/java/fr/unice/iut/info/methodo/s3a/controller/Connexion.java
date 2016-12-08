package fr.unice.iut.info.methodo.s3a.controller;

import fr.unice.iut.info.methodo.s3a.model.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.rmi.CORBA.Util;
import javax.swing.*;
import java.io.IOException;

public class Connexion {

    private Stage homeStage;

    @FXML
    private Button btn_connect;

    @FXML
    private TextField tf_user;

    @FXML
    private PasswordField tf_pwd;

    @FXML
    void goToHomePage(ActionEvent event) {

        String connexion_id = tf_user.getText();
        String connexion_password = tf_pwd.getText();

        Utilisateur user = null;
        try {
            if (connexion_id.equals("") || connexion_password.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Veuillez entrer vos identifiants");
            }
            user = Utilisateur.read().get(connexion_id);
            if (user.getMdp().equals(connexion_password)) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(CreateItineraires.class.getClassLoader().getResource("Page d'acceuil.fxml"));
                    // Chargement du FXML.
                    Parent root = fxmlLoader.load();
                    // Création de la scène.
                    Scene scene = new Scene(root);
                    Stage stage = this.homeStage;
                    stage.setScene(scene);
                    ((HomePage)fxmlLoader.getController()).isConnected(user, (Stage) btn_connect.getScene().getWindow());
                    stage.show();
                } catch (IOException ex) {
                    System.err.println("Erreur au chargement: " + ex);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Nom de compte ou mot de passe incorrect");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void pipeline (Stage stage) {
        this.homeStage = stage;
    }

}
