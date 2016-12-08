package fr.unice.iut.info.methodo.s3a.controller;

import fr.unice.iut.info.methodo.s3a.CurrentData;
import fr.unice.iut.info.methodo.s3a.model.Coordonee;
import fr.unice.iut.info.methodo.s3a.model.PointInteret;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class CreatePI {

    private Stage homeStage;

    @FXML
    private Button button_home;

    @FXML
    private TextField fieldPrixHaut;

    @FXML
    private TextField fieldPrixBas;

    @FXML
    private TextField fieldVille;

    @FXML
    private ImageView img_point;

    @FXML
    private ImageView img_home;

    @FXML
    private TextArea fieldDescription;

    @FXML
    private Label lb_title;

    @FXML
    private TextField fieldType;

    @FXML
    private TextField fieldNom;

    @FXML
    private Button buttonValidate;

    @FXML
    public void initialize(){
        Image image= new Image("home.png");
        img_home.setImage(image);
    }

    @FXML
    void toHome(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(CreateItineraires.class.getClassLoader().getResource("Page d'acceuil.fxml"));
            // Chargement du FXML.
            Parent root = fxmlLoader.load();
            // Création de la scène.
            Scene scene = new Scene(root);
            Stage stage = this.homeStage;
            stage.setScene(scene);
            ((HomePage)fxmlLoader.getController()).isConnected(CurrentData.currentUser, (Stage) button_home.getScene().getWindow());
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }
    }

    @FXML
    void savePI(ActionEvent event) throws IOException, ClassNotFoundException {
        String type = fieldType.getText();
        String ville = fieldVille.getText();
        String description = fieldDescription.getText();
        String nom = fieldNom.getText();
        int prix_b = Integer.parseInt(fieldPrixBas.getText());
        int prix_h = Integer.parseInt(fieldPrixHaut.getText());
        PointInteret currentPoint = new PointInteret(nom,description,type,prix_b,prix_h,new Coordonee(0,0,""));
        try {
            currentPoint.save();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,"Point d'interet enregistré");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HomePage.class.getClassLoader().getResource("Page d'acceuil.fxml"));
            // Chargement du FXML.
            Parent root = fxmlLoader.load();
            // Création de la scène.
            Scene scene = new Scene(root);
            Stage stage = this.homeStage;
            stage.setScene(scene);
            ((HomePage)fxmlLoader.getController()).reloadData((Stage) fieldDescription.getScene().getWindow());
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }
        PointInteret p = PointInteret.read().get("a");
        JOptionPane.showMessageDialog(null,p.getNom()+""+p.getType()+""+p.getDescription());


    }

    public void pipeline (Stage stage) {
        this.homeStage = stage;
    }



}
