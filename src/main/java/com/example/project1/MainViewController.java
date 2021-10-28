package com.example.project1;

import Services.DepartmentService;
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
import java.util.function.Consumer;

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
        loadView("DepartmentList.fxml",(DepartmentListController controller) -> {
            controller.setDepartmentService(new DepartmentService());
            controller.UpdateTableView();
        });
    }

    @FXML
    public void OnMenuItemAboutAction (){
        loadView("AboutView.fxml", x -> {});
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private synchronized <T> void  loadView (String absolutename, Consumer<T> initializeAction) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutename));
            VBox newvbox = loader.load();

            Scene mainscene = HelloApplication.getMainscene();
            VBox mainVbox = (VBox) ((ScrollPane) mainscene.getRoot()).getContent();

            Node mainMenu = mainVbox.getChildren().get(0);
            mainVbox.getChildren().clear();
            mainVbox.getChildren().add(mainMenu);
            mainVbox.getChildren().addAll(newvbox.getChildren());

            T controller = loader.getController();
            initializeAction.accept(controller);
        }
        catch (IOException e){
            Alerts.showAlert("IOException","Error loading View",e.getMessage(), Alert.AlertType.ERROR);
        }
    }


}
