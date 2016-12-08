package fr.unice.iut.info.methodo.s3a.controller;

/**
 * Created by ahlakazam on 18/11/16.
 */


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;


public class SavedItineraires {

    @FXML
    private TableColumn<?, ?> tableau_favoris_nom;

    @FXML
    private TableView<?> tableau_favoris;

    @FXML
    private TableColumn<?, ?> tableau_favoris_budget;

    @FXML
    private ImageView image_home;

    @FXML
    void toHome(ActionEvent event) {
        ((Stage)tableau_favoris.getScene().getWindow()).close();
    }

    @FXML
    public void initialize(){
        Image image= new Image("home.png");
        image_home.setImage(image);
    }
}
