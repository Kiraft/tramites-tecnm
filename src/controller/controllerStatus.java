package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import controller.util.MatriculaModel;
import controller.util.StageLoaderMatricula;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class controllerStatus implements Initializable{

    @FXML
    private Label LabelStatus1;

    @FXML
    private Label LabelStatus2;

    @FXML
    private Label LabelStatus3;

    @FXML
    private Label LabelStatus4;

    @FXML
    private Label LabelStatus5;

    @FXML
    private Label LabelStatus6;

    @FXML
    private Label LabelStatus7;

    @FXML
    private Label LabelStatus8;

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

    private MatriculaModel matriculaModel;

    public void setMatriculaModel(MatriculaModel matriculaModel) {
        this.matriculaModel = matriculaModel;
    }


    @FXML
    void MouseClicked(MouseEvent event) {
        try {
            StageLoaderMatricula.load("/view/viewLandingPage.fxml", event, matriculaModel);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void clickBtn(ActionEvent event) {
        
        if (event.getSource().equals(btnMenu)) {
            try {
                StageLoaderMatricula.load("/view/viewLandingPage.fxml", event, matriculaModel);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if(event.getSource().equals(btnSubir)) {
            try {
                StageLoaderMatricula.load("/view/viewArchivos.fxml", event, matriculaModel);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else if(event.getSource().equals(btnMyDocs)){
            try {
                StageLoaderMatricula.load("/view/viewStatus.fxml", event, matriculaModel);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else if(event.getSource().equals(btnFinish)){
            JOptionPane.showMessageDialog(null, "HAZ FINALIZADO TU TRAMITE CON EXITO", null, JOptionPane.WARNING_MESSAGE);
            try {
                StageLoaderMatricula.load("/view/viewLandingPage.fxml", event, matriculaModel);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            try {
                StageLoaderMatricula.load("/view/ViewLogin.fxml", event, null);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Thread hilo = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
            Platform.runLater(() -> {
    
            });
        });
    
        hilo.start();
    }

}
