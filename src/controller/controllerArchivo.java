package controller;

import java.io.File;
import java.io.IOException;

import controller.util.MatriculaModel;
import controller.util.StageLoaderMatricula;

import javax.swing.JOptionPane;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.AlumnoDAO;
import model.ArchivosDAO;

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
            cargarArchivoEnHiloSecundario(btnSubirArchivo1, labelSubir1, 1);
        } else if (event.getSource().equals(btnSubirArchivo2)) {
            cargarArchivoEnHiloSecundario(btnSubirArchivo2, labelSubir2, 2);
        } else if (event.getSource().equals(btnSubirArchivo3)) {
            cargarArchivoEnHiloSecundario(btnSubirArchivo3, labelSubir3, 3);
        } else if (event.getSource().equals(btnSubirArchivo4)) {
            cargarArchivoEnHiloSecundario(btnSubirArchivo4, labelSubir4, 4);
        } else if (event.getSource().equals(btnSubirArchivo5)) {
            cargarArchivoEnHiloSecundario(btnSubirArchivo5, labelSubir5, 5);
        } else if (event.getSource().equals(btnSubirArchivo6)) {
            cargarArchivoEnHiloSecundario(btnSubirArchivo6, labelSubir6, 6);
        } else if (event.getSource().equals(btnSubirArchivo7)) {
            cargarArchivoEnHiloSecundario(btnSubirArchivo7, labelSubir7, 7);
        } else if (event.getSource().equals(btnSubirArchivo8)) {
            cargarArchivoEnHiloSecundario(btnSubirArchivo8, labelSubir8, 8);
        }
    }
    
    private void cargarArchivoEnHiloSecundario(Button botonSubirArchivo, Label labelSubir, int id_archivo) {

        Thread hiloCargaArchivo = new Thread(() -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Selecciona un archivo");
            Stage stage = (Stage) botonSubirArchivo.getScene().getWindow();
    
            
            Runnable fileChooserRunnable = () -> {
                File file = fileChooser.showOpenDialog(stage);
    
                if (file != null) {
                    // JOptionPane.showMessageDialog(null, "Archivo cargado", null, JOptionPane.WARNING_MESSAGE);
                    
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


}

