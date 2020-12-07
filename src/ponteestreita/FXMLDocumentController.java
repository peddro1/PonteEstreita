/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponteestreita;

import java.util.List;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import ponteestreita.enums.Direcao;
import ponteestreita.enums.Estado;

/**
 *
 * @author anaad
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane anchor;

    
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
    private ComboBox<Prioridade> prioridade;

    private List<Prioridade> prioridades = new ArrayList<>();
    
    private ObservableList<Prioridade> obsPrioridades;
    
    @FXML
    private ComboBox<LadoPonte> ladoPonte;
    
    private List<LadoPonte> lados = new ArrayList<>();
    
    private ObservableList<LadoPonte> obsLados;
    
    @FXML
    private TableView<Carro> table;

    
    @FXML
    private TableColumn<Carro, Integer> ID;

    @FXML
    private TableColumn<Carro, Estado> ESTADO;

    @FXML
    private TableColumn<Carro, Double> TT;        //tempo de travessia

    @FXML
    private TableColumn<Carro, Double> TP;        // tempo de permanencia

    private static Integer i = 0;
    
    
    private Direcao direcaoCarro;
    
    private Direcao prioridadePonte;
    
   
    public Controlador control = Controlador.novoControlador(10);
    
    
    @FXML
    private void startButton(ActionEvent event) {
      
        Prioridade prio = prioridade.getSelectionModel().getSelectedItem();
        
        if(prio.getLado().equals("Direita")){
            prioridadePonte = Direcao.Direita;
        }else if(prio.getLado().equals("Esquerda")){
            prioridadePonte = Direcao.Esquerda;
        }else{
            prioridadePonte = Direcao.Nenhuma;
        }
        
        if(i==0){
            Ponte.novaPonte(prioridadePonte);
            
            System.out.println("Criou Ponte");
        }
        
       
        LadoPonte lado = ladoPonte.getSelectionModel().getSelectedItem();
        
        
        
        if(lado.getLado().equals("Direita")){
            direcaoCarro = Direcao.Esquerda;
       
        }else{
            direcaoCarro = Direcao.Direita;
        }
        
        Carro car = new Carro(
                i,
                Double.parseDouble(tempoPermanencia.getText()), 
                Double.parseDouble(tempoTravessia.getText()), 
                direcaoCarro,
                anime);
        
        
        
        
        car.start();
        
        
        control.addCarro(car);
      
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        ESTADO.setCellValueFactory(new PropertyValueFactory<>("estado"));
        TT.setCellValueFactory(new PropertyValueFactory<>("tempoTravessia"));
        TP.setCellValueFactory(new PropertyValueFactory<>("tempoEspera"));
        
        table.setEditable(true);
        
        table.setItems(atualizaTabela());
      
        
        i++;
        
    }
    
    public ObservableList<Carro> atualizaTabela(){
        return FXCollections.observableArrayList(control.getCarrosJuntos());
    }
    
   
    @FXML
    void eliminaCarro(ActionEvent event) {
        //table.setEditable(true);
        control.eliminarCarro(control.getCarrosJuntos(), Integer.parseInt(eliminaCarroId.getText()));
        table.setItems(atualizaTabela());

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarLadoPonte();
        carregarPrioridade();
    }    
    
    public void carregarLadoPonte(){
        
        LadoPonte lado1 = new LadoPonte("Direita");
        LadoPonte lado2 = new LadoPonte("Esquerda");
        
        lados.add(lado1);
        lados.add(lado2);
        
        obsLados = FXCollections.observableArrayList(lados);
        
        ladoPonte.setItems(obsLados);
        
    }
    
    public void carregarPrioridade(){
        
        Prioridade p1 = new Prioridade("Direita");
        Prioridade p2 = new Prioridade("Esquerda");
        Prioridade p3 = new Prioridade("Nenhuma");
        
        prioridades.add(p1);
        prioridades.add(p2);
        prioridades.add(p3);
        
        obsPrioridades = FXCollections.observableArrayList(prioridades);
        
        prioridade.setItems(obsPrioridades);
    }
    
    
    
    private Animations anime = new Animations() {
       
        Timeline playtime0 = new Timeline();
        Timeline playtime1 = new Timeline();
        Timeline playtime2 = new Timeline();
        Timeline playtime3 = new Timeline();
        Timeline playtime4 = new Timeline();
        Timeline playtime5 = new Timeline();
        Timeline playtime6 = new Timeline();
        Timeline playtime7 = new Timeline();
        Timeline playtime8 = new Timeline();
        Timeline playtime9 = new Timeline();
        Timeline playtime10 = new Timeline();
        Timeline playtime11 = new Timeline();
        Timeline playtime12 = new Timeline();
        Timeline playtime13 = new Timeline();
        Timeline playtime14 = new Timeline();
        Timeline playtime15 = new Timeline();
        Timeline playtime16 = new Timeline();
        Timeline playtime17 = new Timeline();
        Timeline playtime18 = new Timeline();
        Timeline playtime19 = new Timeline();
        Timeline playtime20 = new Timeline();
        Timeline playtime21 = new Timeline();
        Timeline playtime22 = new Timeline();
        Timeline playtime23 = new Timeline();
        Timeline playtime24 = new Timeline();
        Timeline playtime25 = new Timeline();
        Timeline playtime26 = new Timeline();
        Timeline playtime27 = new Timeline();
        Timeline playtime28 = new Timeline();
        Timeline playtime29 = new Timeline();
        Timeline playtime30 = new Timeline();
        Timeline playtime31 = new Timeline();
        Timeline playtime32 = new Timeline();
        Timeline playtime33 = new Timeline();
        Timeline playtime34 = new Timeline();
        Timeline playtime35 = new Timeline();
        Timeline playtime36 = new Timeline();
        Timeline playtime37 = new Timeline();
        Timeline playtime38 = new Timeline();
        Timeline playtime39 = new Timeline();
        Timeline playtime40 = new Timeline();
        Timeline playtime41 = new Timeline();
        Timeline playtime42 = new Timeline();
        Timeline playtime43 = new Timeline();
        Timeline playtime44 = new Timeline();
        Timeline playtime45 = new Timeline();
        Timeline playtime46 = new Timeline();
        Timeline playtime47 = new Timeline();
        Timeline playtime48 = new Timeline();
        Timeline playtime49 = new Timeline();
        
        @Override
        public void move(Carro carro,int x1,int y1, int x2, int y2, Image image, Integer flag) {	
          
            anchor.getChildren().add(carro.image);
            
            carro.image.setImage(image);
            
			
            Path path = new Path();
            path.getElements().add(new MoveTo(x1,y1));
            path.getElements().add(new LineTo(x2,y2));
           
            PathTransition pathTransition = new PathTransition();
            switch(flag){
                case 0:
                    pathTransition.setDuration(Duration.millis(1000));
                    
                    break;
                case 1:
                    pathTransition.setDuration(Duration.millis(carro.getTempoTravessia()*1000));
                    break;
                case 2:
                    pathTransition.setDuration(Duration.millis(carro.getTempoEspera()*1000));
                    break;
                case 3:
                    pathTransition.setDuration(Duration.millis(1000));
            }
            
            pathTransition.setPath(path);
            
            pathTransition.setNode(carro.image);
            //pathTransition.setOrientation();
            pathTransition.setCycleCount(1);
            
            if(flag == 3)
                pathTransition.setCycleCount(1000);
            
            pathTransition.setAutoReverse(false);
            
            pathTransition.play();
           
           
        }
        
        
        @Override
        public void stopE(Carro carro) {
            carro.image.setImage(null);
            
            switch(carro.getIdCarro()){
                case 0:
                    
                    playtime20.getKeyFrames().setAll(
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,35,40,35,carro.imagemCarroD, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                       );
                    playtime20.play();  
                    break;
                case 1:
                    playtime21.getKeyFrames().setAll(
                        new KeyFrame(Duration.seconds(0), event ->move(carro,61,70,40,70,carro.imagemCarroD, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        );
                    playtime21.play();  
                    break;
                   
                case 2:
                    playtime22.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,61,100,40,100,carro.imagemCarroD, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                        );
                    playtime22.play();  
                    break;
                    
                case 3:
                    playtime23.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,61,140,40,140,carro.imagemCarroD, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                       );
                    playtime23.play();  
                    break;
                case 4:
                    playtime24.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,61,200,40,200,carro.imagemCarroD, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                        );
                    playtime24.play();  
                    break;
                    
                case 5:
                    playtime25.getKeyFrames().setAll(
                        new KeyFrame(Duration.seconds(0), event ->move(carro,61,230,40,230,carro.imagemCarroD, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        );
                    playtime25.play();  
                    break;
                case 6:
                    playtime26.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,61,265,40,265,carro.imagemCarroD, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                        );
                    playtime26.play();  
                    break;
                   
                case 7:
                    playtime27.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,61,295,40,295,carro.imagemCarroD, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                        );
                    playtime27.play();  
                    break;
                    
                case 8:
                    playtime28.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,61,330,40,330,carro.imagemCarroD, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                        );
                    playtime28.play();  
                    break;
                case 9:
                    playtime29.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,61,360,40,360,carro.imagemCarroD, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                        );
                    playtime29.play();  
                    break;
                    
            }
            
        }
        
        @Override
        public void stopD(Carro carro) {
            switch(carro.getIdCarro()){
                case 0:
                    playtime30.getKeyFrames().setAll(
                        new KeyFrame(Duration.seconds(0), event ->move(carro,620,35,640,35,carro.imagemCarroE, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                       );
                    playtime30.play();  
                    break;
                case 1:
                    playtime31.getKeyFrames().setAll(
                        new KeyFrame(Duration.seconds(0), event ->move(carro,621,70,641,70,carro.imagemCarroE, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        );
                    playtime31.play();  
                    break;
                   
                case 2:
                    playtime32.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,621,100,641,100,carro.imagemCarroE, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                        );
                    playtime32.play();  
                    break;
                    
                case 3:
                    playtime33.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,621,140,641,140,carro.imagemCarroE, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                       );
                    playtime33.play();  
                    break;
                case 4:
                    playtime34.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,621,200,641,200,carro.imagemCarroE, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                        );
                    playtime34.play();  
                    break;
                    
                case 5:
                    playtime35.getKeyFrames().setAll(
                        new KeyFrame(Duration.seconds(0), event ->move(carro,621,230,641,230,carro.imagemCarroE, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        );
                    playtime35.play();  
                    break;
                case 6:
                    playtime36.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,621,265,641,265,carro.imagemCarroE, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                        );
                    playtime36.play();  
                    break;
                   
                case 7:
                    playtime37.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,621,295,641,295,carro.imagemCarroE, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                        );
                    playtime37.play();  
                    break;
                    
                case 8:
                    playtime38.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,621,330,641,330,carro.imagemCarroE, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                        );
                    playtime38.play();  
                    break;
                case 9:
                    playtime39.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,621,360,641,360,carro.imagemCarroE, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                        );
                    playtime39.play();  
                    break;
            }
        }

        @Override
        public void aguarda(Carro carro) {
            switch(carro.getIdCarro()){
                case 0:
                    playtime40.getKeyFrames().setAll(
                        new KeyFrame(Duration.seconds(0), event ->move(carro,321,35,341,35,carro.imagemCarroE, 3)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image))
                       );
                    playtime40.play();  
                    break;
                case 1:
                    playtime41.getKeyFrames().setAll(
                        new KeyFrame(Duration.seconds(0), event ->move(carro,321,70,341,70,carro.imagemCarroE, 3)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        );
                    playtime41.play();  
                    break;
                   
                case 2:
                    playtime42.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,321,100,341,100,carro.imagemCarroE, 3)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                        );
                    playtime42.play();  
                    break;
                    
                case 3:
                    playtime43.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,621,140,641,140,carro.imagemCarroE, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                       );
                    playtime43.play();  
                    break;
                case 4:
                    playtime44.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,621,200,641,200,carro.imagemCarroE, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                        );
                    playtime44.play();  
                    break;
                    
                case 5:
                    playtime45.getKeyFrames().setAll(
                        new KeyFrame(Duration.seconds(0), event ->move(carro,621,230,641,230,carro.imagemCarroE, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        );
                    playtime45.play();  
                    break;
                case 6:
                    playtime46.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,621,265,641,265,carro.imagemCarroE, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                        );
                    playtime46.play();  
                    break;
                   
                case 7:
                    playtime47.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,621,295,641,295,carro.imagemCarroE, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                        );
                    playtime47.play();  
                    break;
                    
                case 8:
                    playtime48.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,621,330,641,330,carro.imagemCarroE, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                        );
                    playtime48.play();  
                    break;
                case 9:
                    playtime49.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,621,360,641,360,carro.imagemCarroE, 2)),
                        new KeyFrame(Duration.seconds(carro.getTempoEspera()), event ->anchor.getChildren().remove(carro.image))
                        
                        );
                    playtime49.play();  
                    break;
            }
            
            
        }
   
       
        
        @Override
        public void paraEsquerda(Carro carro) {
           
            switch(carro.getIdCarro()){
                case 0:
                    //61,35,40,35,
                    playtime0.getKeyFrames().setAll(
                        new KeyFrame(Duration.seconds(0), event ->move(carro,620,34,620,155,carro.imagemCarroE, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,620,155,60,155,carro.imagemCarroE, 1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,60,155,60,34,carro.imagemCarroD,0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))
                	);
                    playtime0.play(); 
                    //playtime0.getKeyFrames().removeAll();
                    break;
                case 1:
                    playtime1.getKeyFrames().setAll(
                        new KeyFrame(Duration.seconds(0), event ->move(carro,620,69,620,165,carro.imagemCarroE, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,620,165,60,165,carro.imagemCarroE, 1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,60,165,60,69,carro.imagemCarroD, 0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))
                	);
                    playtime1.play();  
                    break;
                   
                case 2:
                    playtime2.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,620,99,620,160,carro.imagemCarroE, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,620,160,60,160,carro.imagemCarroE, 1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,60,160,60,99,carro.imagemCarroD,0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))
                	
                        );
                    playtime2.play();  
                    break;
                    
                case 3:
                    playtime3.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,620,139,620,155,carro.imagemCarroE, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,620,155,60,155,carro.imagemCarroE,1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,60,155,60,139,carro.imagemCarroD,0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))
                	
                       );
                    playtime3.play();  
                    break;
                case 4:
                    playtime4.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,620,199,620,170,carro.imagemCarroE, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,620,170,60,170,carro.imagemCarroE,1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,60,170,60,199,carro.imagemCarroD,0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))
                	
                        );
                    playtime4.play();  
                    break;
                    
                case 5:
                    playtime5.getKeyFrames().setAll(
                        new KeyFrame(Duration.seconds(0), event ->move(carro,620,229,620,155,carro.imagemCarroE, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,620,155,60,155,carro.imagemCarroE, 1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,60,155,60,229,carro.imagemCarroD,0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))
                    );
                    playtime5.play();  
                    break;
                case 6:
                    playtime6.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,620,264,620,165,carro.imagemCarroE, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,620,165,60,165,carro.imagemCarroE, 1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,60,165,60,264,carro.imagemCarroD,0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))
                	
                        );
                    playtime6.play();  
                    break;
                   
                case 7:
                    playtime7.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,620,294,620,160,carro.imagemCarroE, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,620,160,60,160,carro.imagemCarroE, 1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,60,160,60,294,carro.imagemCarroD,0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))
                	
                        );
                    playtime7.play();  
                    break;
                    
                case 8:
                    playtime8.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,620,329,620,155,carro.imagemCarroE, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,620,155,60,155,carro.imagemCarroE, 1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,60,155,60,329,carro.imagemCarroD,0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))
                	
                        );
                    playtime8.play();  
                    break;
                case 9:
                    playtime9.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,620,359,620,170,carro.imagemCarroE, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,620,170,60,170,carro.imagemCarroE, 1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,60,170,60,359,carro.imagemCarroD,0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))
                	
                        );
                    playtime9.play();  
                    break;
                
            }
         
        }
        
        @Override
        public void paraDireita(Carro carro) {
            
            switch(carro.getIdCarro()){
                case 0:
                    //621,35,600,35
                    playtime10.getKeyFrames().setAll(
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,34,60,155,carro.imagemCarroD, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,155,620,155,carro.imagemCarroD, 1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,155,620,34,carro.imagemCarroE,0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))
                	);
                    playtime10.play();  
                    
                    break;
                case 1:
                    playtime11.getKeyFrames().setAll(
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,69,60,165,carro.imagemCarroD, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,165,620,165,carro.imagemCarroD, 1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,165,620,69,carro.imagemCarroE, 0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))
                	);
                    playtime11.play();  
                    break;
                   
                case 2:
                    playtime12.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,99,60,160,carro.imagemCarroD, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,160,620,160,carro.imagemCarroD, 1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,160,620,99,carro.imagemCarroE,0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))
                	
                        );
                    playtime12.play();  
                    break;
                    
                case 3:
                    playtime13.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,139,60,155,carro.imagemCarroD, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,155,620,155,carro.imagemCarroD,1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,155,620,139,carro.imagemCarroE,0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))
                	
                       );
                    playtime13.play();  
                    break;
                case 4:
                    playtime14.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,199,60,170,carro.imagemCarroD, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,170,620,170,carro.imagemCarroD,1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,170,620,199,carro.imagemCarroE,0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))
                	
                        );
                    playtime14.play();  
                    break;
                    
                case 5:
                    playtime15.getKeyFrames().setAll(
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,230,60,155,carro.imagemCarroD, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,155,620,155,carro.imagemCarroD, 1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,155,620,230,carro.imagemCarroE,0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image))
                	);
                    playtime15.play();  
                    break;
                case 6:
                    playtime16.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,264,60,165,carro.imagemCarroD, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,165,620,165,carro.imagemCarroD, 1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,165,620,264,carro.imagemCarroE,0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))
                	
                        );
                    playtime16.play();  
                    break;
                   
                case 7:
                    playtime17.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,294,60,160,carro.imagemCarroD, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,160,620,160,carro.imagemCarroD, 1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,160,620,294,carro.imagemCarroE,0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))
                	
                        );
                    playtime17.play();  
                    break;
                    
                case 8:
                    playtime18.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,329,60,155,carro.imagemCarroD, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,155,620,155,carro.imagemCarroD, 1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,155,620,329,carro.imagemCarroE,0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))
                	
                        );
                    playtime18.play();  
                    break;
                case 9:
                    playtime19.getKeyFrames().setAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,359,60,170,carro.imagemCarroD, 0)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,170,620,170,carro.imagemCarroD, 1)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,170,620,359,carro.imagemCarroE,0)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))
                	
                        );
                    playtime19.play();  
                    break;
                default:
                    
                    break;
                
            }
        }

        @Override
        public void elimina(Carro carro) {
            
            
            switch(carro.getIdCarro()){
                case 0:
                    playtime0.stop();
                    playtime10.stop();
                    playtime20.stop();
                    playtime30.stop();
                    
                    break;
                case 1:
                    playtime1.stop();
                    playtime11.stop();
                    playtime21.stop();
                    playtime31.stop();
                    break;
                case 2:
                    playtime2.stop();
                    playtime12.stop();
                    playtime22.stop();
                    playtime32.stop();
                    break;
                case 3:
                    playtime3.stop();
                    playtime13.stop();
                    playtime23.stop();
                    playtime33.stop();
                    break;
                case 4:
                    playtime4.stop();
                    playtime14.stop();
                    playtime24.stop();
                    playtime34.stop();
                    break;
                case 5:
                    playtime5.stop();
                    playtime15.stop();
                    playtime25.stop();
                    playtime35.stop();
                    break;
                case 6:
                    playtime6.stop();
                    playtime16.stop();
                    playtime26.stop();
                    playtime36.stop();
                    break;
                case 7:
                    playtime7.stop();
                    playtime17.stop();
                    playtime27.stop();
                    playtime37.stop();
                    break;
                case 8:
                    playtime8.stop();
                    playtime18.stop();
                    playtime28.stop();
                    playtime38.stop();
                    break;
                case 9:
                    playtime9.stop();
                    playtime19.stop();
                    playtime29.stop();
                    playtime39.stop();
                    break;
                            
            }
            
            carro.image.setImage(null);
            
      
           
        }

        
    };
}
