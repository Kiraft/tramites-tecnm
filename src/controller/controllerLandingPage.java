package controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.util.MatriculaModel;
import controller.util.StageLoader;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;




public class controllerLandingPage {
    @FXML
    private Button btnCerrar;

    @FXML
    private Label LabelControl;

    @FXML
    private Button btnService;

    @FXML
    private Button btnTitle;

    @FXML
    private ImageView logoHome;

    private MatriculaModel matriculaModel;

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
        } else if (event.getSource().equals(btnCerrar)){
            LabelControl.setText(String.valueOf(matriculaModel.getMatricula()));
        }else {
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



}
