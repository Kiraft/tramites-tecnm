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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;



public class LoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUser;

    @FXML
    private void eventAction(ActionEvent event) {
        

        if (event.getSource().equals(btnLogin)) {
            
            if (!txtUser.getText().isEmpty() && !txtPassword.getText().isEmpty()) {
                
                String user = txtUser.getText();
                String pass = txtPassword.getText();

                if (user.equals("Admin") && pass.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Datos correctos", null, JOptionPane.WARNING_MESSAGE);
                    loadStage("/view/viewLandingPage.fxml", event);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al iniciar sesion, datos de acceso incorrectos XD", null, JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Esta vacio bro", null, JOptionPane.WARNING_MESSAGE);
            }

        }
    }



    @FXML
    private void eventKey(KeyEvent event){

        

        if(event.getSource().equals(txtUser)){

            if(event.getCharacter().equals(" ")){
                event.consume();
            }

        }else if(event.getSource().equals(txtPassword)){

            if(event.getCharacter().equals(" ")){
                event.consume();
            }

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
            // TODO: handle exception
        }

        
        
    }

}

