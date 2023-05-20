package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import controller.util.MatriculaModel;
import controller.util.StageLoaderMatricula;

import javax.swing.JOptionPane;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.AlumnoDAO;
import model.ArchivosDAO;

public class controllerArchivo implements Initializable {

    @FXML
    private ImageView imgtrash1;

    @FXML
    private ImageView imgtrash2;

    @FXML
    private ImageView imgtrash3;

    @FXML
    private ImageView imgtrash4;

    @FXML
    private ImageView imgtrash5;

    @FXML
    private ImageView imgtrash6;

    @FXML
    private ImageView imgtrash7;

    @FXML
    private ImageView imgtrash8;


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
    private Button btnSubirArchivo1;

    @FXML
    private Button btnSubirArchivo2;

    @FXML
    private Button btnSubirArchivo3;

    @FXML
    private Button btnSubirArchivo4;

    @FXML
    private Button btnSubirArchivo5;

    @FXML
    private Button btnSubirArchivo6;

    @FXML
    private Button btnSubirArchivo7;

    @FXML
    private Button btnSubirArchivo8;

    @FXML
    private Label labelSubir1;

    @FXML
    private Label labelSubir2;

    @FXML
    private Label labelSubir3;

    @FXML
    private Label labelSubir4;

    @FXML
    private Label labelSubir5;

    @FXML
    private Label labelSubir6;

    @FXML
    private Label labelSubir7;

    @FXML
    private Label labelSubir8;

    @FXML
    private ImageView logoHome;

    private MatriculaModel matriculaModel;

    public void setMatriculaModel(MatriculaModel matriculaModel) {
        this.matriculaModel = matriculaModel;
    }

    private AlumnoDAO ADAO = new AlumnoDAO();

    private ArchivosDAO ARDAO = new ArchivosDAO();

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

    @FXML
    void cargarArchivo(ActionEvent event) {
        if (event.getSource().equals(btnSubirArchivo1)) {
            cargarArchivoEnHiloSecundario(imgtrash1, btnSubirArchivo1, labelSubir1, 1);

        } else if (event.getSource().equals(btnSubirArchivo2)) {
            cargarArchivoEnHiloSecundario(imgtrash2, btnSubirArchivo2, labelSubir2, 2);

        } else if (event.getSource().equals(btnSubirArchivo3)) {
            cargarArchivoEnHiloSecundario(imgtrash3, btnSubirArchivo3, labelSubir3, 3);

        } else if (event.getSource().equals(btnSubirArchivo4)) {
            cargarArchivoEnHiloSecundario(imgtrash4, btnSubirArchivo4, labelSubir4, 4);

        } else if (event.getSource().equals(btnSubirArchivo5)) {
            cargarArchivoEnHiloSecundario(imgtrash5, btnSubirArchivo5, labelSubir5, 5);

        } else if (event.getSource().equals(btnSubirArchivo6)) {
            cargarArchivoEnHiloSecundario(imgtrash6, btnSubirArchivo6, labelSubir6, 6);

        } else if (event.getSource().equals(btnSubirArchivo7)) {
            cargarArchivoEnHiloSecundario(imgtrash7, btnSubirArchivo7, labelSubir7, 7);

        } else if (event.getSource().equals(btnSubirArchivo8)) {
            cargarArchivoEnHiloSecundario(imgtrash8, btnSubirArchivo8, labelSubir8, 8);
        }
    }
    
    private void cargarArchivoEnHiloSecundario(ImageView imageView, Button botonSubirArchivo, Label labelSubir, int id_archivo) {

        Thread hiloCargaArchivo = new Thread(() -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Selecciona un archivo");
            Stage stage = (Stage) botonSubirArchivo.getScene().getWindow();
    
            
            Runnable fileChooserRunnable = () -> {
                File file = fileChooser.showOpenDialog(stage);
    
                if (file != null) {
                    
                    String NombreArchivo = file.getName();

                    String NombreAlumno = String.valueOf(ADAO.getNombre(matriculaModel.getMatricula()));
            
                    File CarpetaDestino = new File("C:/Users/Kiraft/Desktop/tramites-tecnm/docs/" + NombreAlumno + "/");
                    
                    if (!CarpetaDestino.exists()) {
                        CarpetaDestino.mkdir();
                    }
                    
                    File Destino = new File(CarpetaDestino.getAbsolutePath() + File.separator + NombreArchivo);
                    
                    if (file.renameTo(Destino)) {
                        labelSubir.setStyle("-fx-background-color: #5CCF52; -fx-text-fill: white;");
                        //Query de cargado de archivo
                        ARDAO.setArchivo(matriculaModel.getMatricula(), CarpetaDestino.getAbsolutePath(), id_archivo);

                        botonSubirArchivo.setDisable(true);
                        imageView.setVisible(true);
                        imageView.setDisable(false);


                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar archivo en bd", null, JOptionPane.WARNING_MESSAGE);
                    }

                    
                }
            };
    
            // Ejecuta el código en el hilo de eventos de JavaFX
            Platform.runLater(fileChooserRunnable);
        });
        hiloCargaArchivo.start();
    }

    private void BorrarArchivo(ImageView imageView, Label labelSubir, Button botonSubirArchivo, int idRegistro) {
        ARDAO.deleteArchivo(matriculaModel.getMatricula(), idRegistro);
        labelSubir.setStyle("-fx-background-color: #EB4545; -fx-text-fill: white;");
        botonSubirArchivo.setDisable(false);
        imageView.setVisible(false);
        imageView.setDisable(true);
    }

    @FXML
    void trashClic(MouseEvent event) {
        if (event.getSource().equals(imgtrash1)) {
            BorrarArchivo(imgtrash1, labelSubir1, btnSubirArchivo1, 1 );

        } else if (event.getSource().equals(imgtrash2)) {
            BorrarArchivo(imgtrash2, labelSubir2, btnSubirArchivo2, 2);

        } else if (event.getSource().equals(imgtrash3)) {
            BorrarArchivo(imgtrash3, labelSubir3, btnSubirArchivo3, 3 );

        } else if (event.getSource().equals(imgtrash4)) {
            BorrarArchivo(imgtrash4, labelSubir4, btnSubirArchivo4, 4);

        } else if (event.getSource().equals(imgtrash5)) {
            BorrarArchivo(imgtrash5, labelSubir5, btnSubirArchivo5, 5);

        } else if (event.getSource().equals(imgtrash6)) {
            BorrarArchivo(imgtrash6, labelSubir6, btnSubirArchivo6, 6);

        } else if (event.getSource().equals(imgtrash7)) {
            BorrarArchivo(imgtrash7, labelSubir7, btnSubirArchivo7, 7);

        } else if (event.getSource().equals(imgtrash8)) {
            BorrarArchivo(imgtrash8, labelSubir8, btnSubirArchivo8, 8);
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
            int matricula = matriculaModel.getMatricula();
            List<Button> buttons = Arrays.asList(btnSubirArchivo1, btnSubirArchivo2, btnSubirArchivo3, btnSubirArchivo4, btnSubirArchivo5, btnSubirArchivo6, btnSubirArchivo7, btnSubirArchivo8);
            List<Label> labels = Arrays.asList(labelSubir1, labelSubir2, labelSubir3, labelSubir4, labelSubir5, labelSubir6, labelSubir7, labelSubir8);
            List<ImageView> trashImages = Arrays.asList(imgtrash1, imgtrash2, imgtrash3, imgtrash4, imgtrash5, imgtrash6, imgtrash7, imgtrash8);

            for (int i = 1; i <= buttons.size(); i++) {
                boolean botonSubido = ARDAO.getStatusSubido(matricula, i);
                Button button = buttons.get(i - 1);
                Label label = labels.get(i - 1);
                ImageView trashImage = trashImages.get(i - 1);

                if (botonSubido) {
                    button.setDisable(true);
                    label.setStyle("-fx-background-color: #5CCF52; -fx-text-fill: white;");
                    trashImage.setVisible(true);
                    trashImage.setDisable(false);
                }
            }
        });
    });

    hilo.start();
}

}

