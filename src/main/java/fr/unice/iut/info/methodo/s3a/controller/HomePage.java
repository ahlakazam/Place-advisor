package fr.unice.iut.info.methodo.s3a.controller;

import fr.unice.iut.info.methodo.s3a.CurrentData;
import fr.unice.iut.info.methodo.s3a.model.PointInteret;
import fr.unice.iut.info.methodo.s3a.model.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.IOException;

public class HomePage {
    public final ObservableList data = FXCollections.observableArrayList();

    @FXML
    private TextField recherche_ville;

    @FXML
    private Button buttonDeconnexion;

    @FXML
    private Button button_open;

    @FXML
    private Button buttonFavoris;

    @FXML
    private Button recherche_validation;

    @FXML
    private Button buttonConnexion;

    @FXML
    private Button buttonItineraires;

    @FXML
    private TextField recherche_nom;

    @FXML
    private TextField recherche_prix_bas;

    @FXML
    private TextField recherche_type;

    @FXML
    private ListView<?> tablePI;

    @FXML
    private Label label_username;

    @FXML
    private Button buttonPI;

    @FXML
    private TextField recherche_prix_haut;

    @FXML
    public void initialize () {
        buttonDeconnexion.setVisible(false);
        buttonFavoris.setVisible(false);
        buttonItineraires.setVisible(false);
        buttonPI.setVisible(false);
        try {
            data.setAll(PointInteret.read().keySet());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        tablePI.setItems(data);
    }

    @FXML
    void toItineraires(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(CreateItineraires.class.getClassLoader().getResource("Create Itineraire.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            ((CreateItineraires)fxmlLoader.getController()).pipeline((Stage) buttonPI.getScene().getWindow());
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }

    }

    @FXML
    void toFavoris(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SavedItineraires.class.getClassLoader().getResource("Page des favoris.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }

    }

    @FXML
    void toCreatePI(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(CreatePI.class.getClassLoader().getResource("CreatePI.fxml"));
            // Chargement du FXML.
            Parent root = fxmlLoader.load();
            // Création de la scène.
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            ((CreatePI)fxmlLoader.getController()).pipeline((Stage) buttonPI.getScene().getWindow());
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }
    }

    @FXML
    void toConnexion(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Connexion.class.getClassLoader().getResource("identification.fxml"));
            // Chargement du FXML.
            Parent root = fxmlLoader.load();
            // Création de la scène.
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            ((Connexion)fxmlLoader.getController()).pipeline((Stage) button_open.getScene().getWindow());
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }


    }

    @FXML
    void toDeconnexion(ActionEvent event) {
        CurrentData.currentUser = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HomePage.class.getClassLoader().getResource("Page d'acceuil.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) button_open.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }
        JOptionPane.showMessageDialog(null,"Vous avez été déconnecté");
    }

    @FXML
    void openPI(ActionEvent event) {
        try {
            PointInteret pi = PointInteret.read().get(tablePI.getSelectionModel().getSelectedItem().toString()) ;

            FXMLLoader fxmlLoader = new FXMLLoader(PointsController.class.getClassLoader().getResource("pi.fxml"));
            // Chargement du FXML.
            Parent root = fxmlLoader.load();
            // Création de la scène.
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            ((PointsController)fxmlLoader.getController()).pipeline((Stage) buttonPI.getScene().getWindow(), pi);
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void isConnected (Utilisateur currentUser, Stage previousStage) {
        previousStage.close();
        CurrentData.currentUser = currentUser;
        label_username.setText("Bonjour "+CurrentData.currentUser.getPseudo());
        buttonFavoris.setVisible(true);
        buttonItineraires.setVisible(true);
        buttonDeconnexion.setVisible(true);
        buttonConnexion.setVisible(false);
        buttonPI.setVisible(true);
    }

    public void backHome (Stage stage) {
        stage.close();
    }

    public void reloadData (Stage stage) {
        stage.close();
        try {
            data.setAll(PointInteret.read().keySet());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        tablePI.setItems(data);
    }
}



