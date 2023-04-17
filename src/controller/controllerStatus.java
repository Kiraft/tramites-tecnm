package controller;

import java.io.IOException;
import javax.swing.JOptionPane;

import controller.util.StageLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class controllerStatus {

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
        try {
            StageLoader.load("/view/viewLandingPage.fxml", event);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void clickBtn(ActionEvent event) {
        
        if (event.getSource().equals(btnMenu)) {
            try {
                StageLoader.load("/view/viewLandingPage.fxml", event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if(event.getSource().equals(btnSubir)) {
            try {
                StageLoader.load("/view/viewArchivos.fxml", event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else if(event.getSource().equals(btnMyDocs)){
            try {
                StageLoader.load("/view/viewStatus.fxml", event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else if(event.getSource().equals(btnFinish)){
            JOptionPane.showMessageDialog(null, "HAZ FINALIZADO TU TRAMITE CON EXITO", null, JOptionPane.WARNING_MESSAGE);
            try {
                StageLoader.load("/view/viewLandingPage.fxml", event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else if(event.getSource().equals(btnHelp)){
            try {
                StageLoader.load("/view/viewAyuda.fxml", event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            try {
                StageLoader.load("/view/ViewLogin.fxml", event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
