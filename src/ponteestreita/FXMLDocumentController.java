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

    Integer i = 0;
    
    
    private Direcao direcaoCarro;
    
    private Direcao prioridadePonte;
    
   
    private Controlador control = new Controlador(10);
        
    private ObservableList<Carro> carroLista;
    
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
        
        System.out.println(prio.getLado());
        
        
        Ponte.novaPonte(prioridadePonte);
        
        
        LadoPonte lado = ladoPonte.getSelectionModel().getSelectedItem();
        
        
        System.out.println(lado.getLado());
        
        if(lado.getLado().equals("Direita")){
            direcaoCarro = Direcao.Esquerda;
       
        }else{
            direcaoCarro = Direcao.Direita;
        }
        
        Carro car = new Carro(i,Double.parseDouble(tempoPermanencia.getText()), 
                Double.parseDouble(tempoTravessia.getText()), 
                direcaoCarro,
                anime);
        
        car.start();
        
        control.addCarro(car);
        /*
        carroLista.add(car);
        
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        ESTADO.setCellValueFactory(new PropertyValueFactory<>("ID"));
        TT.setCellValueFactory(new PropertyValueFactory<>("TT"));
        TP.setCellValueFactory(new PropertyValueFactory<>("TP"));
        
        table.setItems(carroLista);
        */
        i++;
      
        
    }
   
    @FXML
    void eliminaCarro(ActionEvent event) {
        
        control.eliminarCarro(control.getCarrosJuntos(), Integer.parseInt(eliminaCarroId.getText()));

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
       

        @Override
        public void move(Carro carro,int x1,int y1, int x2, int y2, Image image, boolean flag) {	
          
            anchor.getChildren().add(carro.image);
            
            carro.image.setImage(image);
            
			
            Path path = new Path();
            path.getElements().add(new MoveTo(x1,y1));
            path.getElements().add(new LineTo(x2,y2));
           
            PathTransition pathTransition = new PathTransition();
            if(flag){
                pathTransition.setDuration(Duration.millis(carro.getTempoTravessia()*1000));
            
            }else{
                pathTransition.setDuration(Duration.millis(1000));
            }
            
            pathTransition.setPath(path);
            
            pathTransition.setNode(carro.image);
            //pathTransition.setOrientation();
            pathTransition.setCycleCount(1);
            pathTransition.setAutoReverse(false);
            
            pathTransition.play();
           
           
        }
        
        
        @Override
        public void stop(Carro carro, Image image) {
            System.out.println(carro.getIdCarro());
            
            anchor.getChildren().add(carro.image);
            carro.image.setFitHeight(70);
            carro.image.setFitWidth(70);
            
            if(carro.getDirecaoCarro() == Direcao.Direita ){
                carro.image.setImage(image);
            }else{
                carro.image.setImage(image);
            }
            
        }

        @Override
        public void aguarda(Carro carro) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        
        @Override
        public void paraEsquerda(Carro carro) {
            
         
        }
        
        Timeline playtime = new Timeline();
        Timeline playtime1 = new Timeline();
        Timeline playtime2 = new Timeline();
        Timeline playtime3 = new Timeline();
        Timeline playtime4 = new Timeline();
        Timeline playtime5 = new Timeline();
        Timeline playtime6 = new Timeline();
        Timeline playtime7 = new Timeline();
        Timeline playtime8 = new Timeline();
        Timeline playtime9 = new Timeline();
        
        @Override
        public void paraDireita(Carro carro) {
            System.out.println(carro.getIdCarro());
            switch(carro.getIdCarro()){
                case 0:
                    playtime.getKeyFrames().addAll(
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,35,60,155,carro.imagemCarroD, false)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,155,620,155,carro.imagemCarroD, true)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,155,620,35,carro.imagemCarroD, false)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->move(carro,620,36,620,35,carro.imagemCarroE,false))
                	);
                    playtime.play();  
                    break;
                case 1:
                    playtime1.getKeyFrames().addAll(
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,70,60,165,carro.imagemCarroD, false)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,165,620,165,carro.imagemCarroD, true)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,165,620,70,carro.imagemCarroD, false)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,165,620,70,carro.imagemCarroE, false))
                	);
                    playtime1.play();  
                    break;
                   
                case 2:
                    playtime2.getKeyFrames().addAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,100,60,160,carro.imagemCarroD, false)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,160,620,160,carro.imagemCarroD, true)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,160,620,100,carro.imagemCarroD,false)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,160,620,100,carro.imagemCarroE,false))
                	
                        );
                    playtime2.play();  
                    break;
                    
                case 3:
                    playtime3.getKeyFrames().addAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,140,60,155,carro.imagemCarroD, false)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,155,620,155,carro.imagemCarroD,true)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,155,620,140,carro.imagemCarroD,false)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,155,620,140,carro.imagemCarroE,false))
                	
                       );
                    playtime3.play();  
                    break;
                case 4:
                    playtime4.getKeyFrames().addAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,200,60,170,carro.imagemCarroD, false)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,170,620,170,carro.imagemCarroD,true)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,170,620,200,carro.imagemCarroD,false)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,170,620,200,carro.imagemCarroE,false))
                	
                        );
                    playtime4.play();  
                    break;
                    
                case 5:
                    playtime5.getKeyFrames().addAll(
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,230,60,155,carro.imagemCarroD, false)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,155,620,155,carro.imagemCarroD, true)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,155,620,230,carro.imagemCarroD, false)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,155,620,230,carro.imagemCarroE,false))
                	);
                    playtime5.play();  
                    break;
                case 6:
                    playtime6.getKeyFrames().addAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,265,60,165,carro.imagemCarroD, false)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,165,620,165,carro.imagemCarroD, true)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,165,620,265,carro.imagemCarroD, false)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,165,620,265,carro.imagemCarroE,false))
                	
                        );
                    playtime6.play();  
                    break;
                   
                case 7:
                    playtime7.getKeyFrames().addAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,295,60,160,carro.imagemCarroD, false)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,160,620,160,carro.imagemCarroD, true)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,160,620,295,carro.imagemCarroD, false)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,160,620,295,carro.imagemCarroE,false))
                	
                        );
                    playtime7.play();  
                    break;
                    
                case 8:
                    playtime8.getKeyFrames().addAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,330,60,155,carro.imagemCarroD, false)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,155,620,155,carro.imagemCarroD, true)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,155,620,330,carro.imagemCarroD, false)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,155,620,330,carro.imagemCarroE,false))
                	
                        );
                    playtime8.play();  
                    break;
                case 9:
                    playtime9.getKeyFrames().addAll(
                            
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,360,60,170,carro.imagemCarroD, false)),
                        new KeyFrame(Duration.seconds(1), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds(1), event ->move(carro,60,170,620,170,carro.imagemCarroD, true)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,170,620,360,carro.imagemCarroD, false)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->anchor.getChildren().remove(carro.image)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+1)), event ->move(carro,620,170,620,360,carro.imagemCarroE,false))
                	
                        );
                    playtime9.play();  
                    break;
                default:
                    Timeline playtime10 = new Timeline(
                        new KeyFrame(Duration.seconds(0), event ->move(carro,60,170,560,170,carro.imagemCarroD,true)),
                        new KeyFrame(Duration.seconds((carro.getTempoTravessia()+2)), event ->anchor.getChildren().remove(carro.image))  
                	);
                    playtime10.play();  
                    break;
                
            }
        }

        @Override
        public void elimina(Carro carro) {
            
            //System.out.println(carro.getIdCarro());
            
            switch(carro.getIdCarro()){
                case 0:
                    playtime.stop();
                    break;
                case 1:
                    playtime1.stop();
                    break;
                case 2:
                    playtime2.stop();
                    break;
                case 3:
                    playtime3.stop();
                    break;
                case 4:
                    playtime4.stop();
                    break;
                case 5:
                    playtime5.stop();
                    break;
                case 6:
                    playtime6.stop();
                    break;
                case 7:
                    playtime7.stop();
                    break;
                case 8:
                    playtime8.stop();
                    break;
                case 9:
                    playtime9.stop();
                    break;
                            
            }
            
            carro.image.setImage(null);
           
        }
    };
}
