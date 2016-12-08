package fr.unice.iut.info.methodo.s3a.controller;

import fr.unice.iut.info.methodo.s3a.CurrentData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateItineraires {

    private Stage homeStage;

    @FXML
    private Button button_home;

    @FXML
    private TextField tf_city;

    @FXML
    private ChoiceBox<?> mb_search_by;

    @FXML
    private ChoiceBox<?> mb_search_choice;

    @FXML
    private ListView<?> lv_iti;

    @FXML
    private Button btn_ok;

    @FXML
    private TableView<?> tv_pi;

    @FXML
    private ImageView image_home;

    @FXML
    void addToItineraire(ActionEvent event) {

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
    public void initialize(){
       Image image= new Image("home.png");
        image_home.setImage(image);
    }

    public void pipeline (Stage stage) {
        this.homeStage = stage;
    }

}
