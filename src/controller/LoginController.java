package controller;
import controller.util.StageLoader;
import model.UserDAO;

import java.io.IOException;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;



public class LoginController {

    private UserDAO UDAO = new UserDAO();

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
                
                int matricula = Integer.parseInt(txtUser.getText());
                String pass = txtPassword.getText();

                int state = UDAO.login(matricula, pass);
                
                System.out.println(state);
                
                if (state != -1) {
                    if (state == 1) {
                        JOptionPane.showMessageDialog(null, "Datos correctos", null, JOptionPane.WARNING_MESSAGE);
                        try {
                            StageLoader.load("/view/viewLandingPage.fxml", event);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Datos correctos incorrectos", null, JOptionPane.WARNING_MESSAGE);
                    }
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

}

