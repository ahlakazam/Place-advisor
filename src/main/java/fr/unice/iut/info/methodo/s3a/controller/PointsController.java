package fr.unice.iut.info.methodo.s3a.controller;

/**
 * Created by ahlakazam on 18/11/16.
 */

import fr.unice.iut.info.methodo.s3a.CurrentData;
import fr.unice.iut.info.methodo.s3a.model.PointInteret;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class PointsController {

    private Stage homeStage;

    @FXML
    private Button button_home;

    @FXML
    private Label lb_city;

    @FXML
    private Label lb_description;

    @FXML
    private ImageView img_point;

    @FXML
    private ImageView img_home;

    @FXML
    private Label lb_title;

    @FXML
    private Label lb_price;

    @FXML
    private Button btn_update;

    @FXML
    private Label lb_type;

    @FXML
    private ImageView img_update;

    @FXML
    void updatePrice(ActionEvent event) {

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
            if (CurrentData.currentUser != null)
            {
                ((HomePage)fxmlLoader.getController()).isConnected(CurrentData.currentUser, (Stage) btn_update.getScene().getWindow());
            }
            else
            {
                ((HomePage)fxmlLoader.getController()).backHome((Stage) button_home.getScene().getWindow());
            }
            stage.show();
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }

    }

    @FXML
    public void initialize(){
        Image image= new Image("home.png");
        img_home.setImage(image);
    }

    public void pipeline (Stage stage, PointInteret pi) {
        this.homeStage = stage;
        lb_city.setText(pi.getCoordonee().getVille());
        lb_description.setText(pi.getDescription());
        lb_title.setText(pi.getNom());
        lb_type.setText(pi.getType());
        lb_price.setText("Entre "+pi.getPrixMin()+" et "+pi.getPrixMax());
    }
}


