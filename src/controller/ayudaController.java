package controller;

import javafx.event.Event;
import javafx.scene.input.MouseEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import javafx.scene.image.ImageView;
import javafx.scene.control.Label;



public class ayudaController {

    @FXML
    private Label labelBack;

    @FXML
    private ImageView logoHome;

    

    @FXML
    void click(MouseEvent event) {

        if (event.getSource().equals(labelBack)) {
            loadStage("/view/viewStatus.fxml", event);
        } else {
            loadStage("/view/viewLandingPage.fxml", event);
        }
        
    }


    private void loadStage(String url, Event event){
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene oldScene = sourceAsNode.getScene();
            Window window = oldScene.getWindow();
            Stage stage = (Stage) window;
            stage.hide();
    
            Parent root = FXMLLoader.load(getClass().getResource(url));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();

        } catch (Exception e) {
            
        }
    }

}

