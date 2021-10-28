package com.example.project1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import util.Alerts;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartment;

    @FXML
    private MenuItem menuItemAbout;

    @FXML
    public void OnMenuItemSellerAction (){
        System.out.println("Funcemina");
    }

    @FXML
    public void OnMenuItemDepartmentAction (){
        System.out.println("Funcemina");
    }

    @FXML
    public void OnMenuItemAboutAction (){
        loadView("AboutView.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void loadView (String absolutename) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AboutView.fxml"));
            VBox newvbox = loader.load();

            Scene mainscene = HelloApplication.getMainscene();
            VBox mainVbox = (VBox) ((ScrollPane) mainscene.getRoot()).getContent();

            Node mainMenu = mainVbox.getChildren().get(0);
            mainVbox.getChildren().clear();
            mainVbox.getChildren().add(mainMenu);
            mainVbox.getChildren().addAll(newvbox.getChildren());
        }
        catch (IOException e){
            Alerts.showAlert("IOException","Error loading View",e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
