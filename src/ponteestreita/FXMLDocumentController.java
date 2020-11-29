/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponteestreita;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

/**
 *
 * @author anaad
 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
    private Button start;

   
    @FXML
    private TextField tempoPermanencia;

    @FXML
    private TextField tempoTravessia;

    @FXML
    private TextField eliminaCarroId;

    @FXML
    private Button eliminarCarro;

    @FXML
    private ComboBox<?> prioridade;

    @FXML
    private ComboBox<?> ladoPonte;
    
    @FXML
    private TableColumn<?, ?> ID;

    @FXML
    private TableColumn<?, ?> ESTADO;

    @FXML
    private TableColumn<?, ?> TT;        //tempo de travessia

    @FXML
    private TableColumn<?, ?> TP;        // tempo de permanencia

    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        
    }
    
    @FXML
    void eliminaCarro(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
