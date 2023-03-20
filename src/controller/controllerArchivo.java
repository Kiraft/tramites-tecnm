package controller;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

public class controllerArchivo {

    @FXML
    private Button btnClose;

    @FXML
    private Button btnFinish;

    @FXML
    private Button btnHelp;

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnMyDocs;

    @FXML
    private Button btnSubir;

    @FXML
    private ImageView logoHome;

    @FXML
    void MouseClicked(MouseEvent event) {
        loadStage("/view/viewLandingPage.fxml", event);
    }

    @FXML
    void clickBtn(ActionEvent event) {
        if (event.getSource().equals(btnMenu)) {
            loadStage("/view/viewLandingPage.fxml", event);
        } else if(event.getSource().equals(btnSubir)) {
            loadStage("/view/viewArchivos.fxml", event);
        }else if(event.getSource().equals(btnMyDocs)){
            loadStage("/view/viewStatus.fxml", event);
        }else if(event.getSource().equals(btnFinish)){
            JOptionPane.showMessageDialog(null, "HAZ FINALIZADO TU TRAMITE CON EXITO", null, JOptionPane.WARNING_MESSAGE);
            loadStage("/view/viewLandingPage.fxml", event);
        }else if(event.getSource().equals(btnHelp)){
            loadStage("/view/viewAyuda.fxml", event);
        }else{
            loadStage("/view/ViewLogin.fxml", event);
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

