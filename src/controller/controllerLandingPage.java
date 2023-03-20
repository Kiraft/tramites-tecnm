package controller;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.input.MouseEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;




public class controllerLandingPage {

    @FXML
    private Button btnService;

    @FXML
    private Button btnTitle;

    @FXML
    private ImageView logoHome;

    @FXML
    void clickBtn(ActionEvent event) {
        if (event.getSource().equals(btnService)) {
            loadStage("/view/viewStatus.fxml", event);
        } else {
            JOptionPane.showMessageDialog(null, "EN DESARROLLO, VUELVA MAS TARDE", null, JOptionPane.WARNING_MESSAGE);
        }
    }

    @FXML
    void clickLogo(MouseEvent event) {
        loadStage("/view/viewLandingPage.fxml", event);
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
