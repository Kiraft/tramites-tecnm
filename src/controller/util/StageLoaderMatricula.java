package controller.util;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.IOException;

import controller.controllerLandingPage;

public class StageLoaderMatricula {

    public static void load(String url, Event event, MatriculaModel matriculaModel) throws IOException {
        Object eventSource = event.getSource();
        Node sourceAsNode = (Node) eventSource;
        Scene oldScene = sourceAsNode.getScene();
        Window window = oldScene.getWindow();
        Stage stage = (Stage) window;
        stage.hide();

        FXMLLoader loader = new FXMLLoader(StageLoaderMatricula.class.getResource(url));
        Parent root = loader.load();


        if (matriculaModel != null) {
            controllerLandingPage controller = loader.getController();
            controller.setMatriculaModel(matriculaModel);
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}