package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import controller.util.MatriculaModel;
import controller.util.StageLoader;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import model.UserDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class controllerLandingPage implements Initializable {

    @FXML
    private Label LabelCarrera;

    @FXML
    private Label LabelCorreo;
    
    @FXML
    private Button btnCerrar;

    @FXML
    private Label LabelControl;

    @FXML
    private Label LabelNombre;

    @FXML
    private Button btnService;

    @FXML
    private Button btnTitle;

    @FXML
    private ImageView logoHome;

    private MatriculaModel matriculaModel;

    private UserDAO UDAO = new UserDAO();

    public void setMatriculaModel(MatriculaModel matriculaModel) {
        this.matriculaModel = matriculaModel;
    }


    @FXML
    void clickBtn(ActionEvent event) {
        if (event.getSource().equals(btnService)) {
            System.out.println(matriculaModel.getMatricula());
            try {
                StageLoader.load("/view/viewStatus.fxml", event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (event.getSource().equals(btnCerrar)) {
            LabelControl.setText(String.valueOf(matriculaModel.getMatricula()));
        } else {
            JOptionPane.showMessageDialog(null, "EN DESARROLLO, VUELVA MAS TARDE", null, JOptionPane.WARNING_MESSAGE);
        }
    }

    @FXML
    void clickLogo(MouseEvent event) {
        try {
            StageLoader.load("/view/viewLandingPage.fxml", event);
        } catch (IOException e) {
            e.printStackTrace();
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
                LabelNombre.setText(String.valueOf(UDAO.getNombre(matriculaModel.getMatricula())));
                LabelControl.setText(String.valueOf(matriculaModel.getMatricula()));
                LabelCarrera.setText(String.valueOf(UDAO.getCarrera(matriculaModel.getMatricula())));
            });
        });
    
        hilo.start();
    }

}
