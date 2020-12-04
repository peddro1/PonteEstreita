/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponteestreita;


import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ponteestreita.enums.Direcao;
import ponteestreita.enums.Estado;

/**
 *
 * @author anaad
 */
public class Carro extends Thread{
    private Integer id;
    private Double tempoEspera;                 
    private Double tempoTravessia;              
    private Estado estado;                      
    private Direcao direcaoCarro;
    
    
    public Animations anime;
    public Image imagemCarroD;
    public Image imagemCarroE;
   
    public ImageView image;
    
    private Double tempoEsperado;
    private Double tempoAtravessando;
    
    public Carro(Integer id, Double tempoEspera, Double tempoTravessia,Direcao direcaoCarro,Animations anime) {
	super();
	
	this.tempoEspera = tempoEspera;
	this.tempoTravessia = tempoTravessia;
        this.id = id;
	this.estado = Estado.Parado;
	this.direcaoCarro = direcaoCarro;
        
        image = new ImageView();
        
        this.imagemCarroD = new Image("/imagens/carroD"+ ((this.id)+1) +".png");
        this.imagemCarroE = new Image("/imagens/carroE"+ ((this.id)+1) +".png");
        this.anime = anime;
      
    }
    
    @Override
    public void run(){
        double tempoAnterior, tempoAtual;
	tempoAtual = 0;
	tempoAnterior = System.currentTimeMillis();
	tempoEsperado = tempoAtravessando = 0.0;
	Double tempoTravessiaAtual;
        
        while(!isInterrupted()){
        
            try {
                
                carroEspera(this, tempoAtual, tempoAnterior);
                
                Ponte.getInstancia().getMutex().acquire();
                estado = Estado.Aguardando;
                
                //Log.doLog(ManuseadorDeCarros.manuseador().getCarros());
                if((Ponte.getInstancia().getDirecaoPonte()== Direcao.Nenhuma)||(direcaoCarro != Ponte.getInstancia().getDirecaoPonte())) {
                    if (direcaoCarro != Ponte.getInstancia().getDirecaoPonte() && Ponte.getInstancia().getDirecaoPonte() != Direcao.Nenhuma) {
                        Ponte.getInstancia().setCarrosDoOutroLado(Ponte.getInstancia().getCarrosDoOutroLado() + 1);
                    }
                    Ponte.getInstancia().getMutex().release();
                    
                    Ponte.getInstancia().getMutex().acquire();
                    Ponte.getInstancia().setDirecaoPonte(direcaoCarro);
                }
                Ponte.getInstancia().setCarros(Ponte.getCarros() + 1 );
                Ponte.getInstancia().getMutex().release();
                
                carroAtravessa(this, tempoAtual, tempoAnterior);
                
                Ponte.getInstancia().getMutex().acquire();
                Ponte.getInstancia().setCarros(Ponte.getCarros() - 1 );
                
                if(Ponte.getInstancia().getCarros() == 0){
                    if(Ponte.getInstancia().getCarrosDoOutroLado() == 0){
                        Ponte.getInstancia().setDirecaoPonte(Direcao.Nenhuma);
                        Ponte.getInstancia().getLiberaPonte().release();
                        Ponte.getInstancia().setCarrosDoOutroLado(0);
                        
                    }else{
                        Ponte.getInstancia().setDirecaoPonte(Direcao.Nenhuma);
                        Ponte.getInstancia().getLiberaPonte().release(Ponte.getInstancia().getCarrosDoOutroLado());
                        Ponte.getInstancia().setCarrosDoOutroLado(0);
                    }
                
                }
                Ponte.getInstancia().getMutex().release();
                
                
                Controlador.getInstancia().mudarDirecaoCarro(this);
                estado = Estado.Parado;
                
                if(this.isInterrupted()) throw new InterruptedException();
                
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
        
    }
    
    
    
    
    public Integer getIdCarro() {
        
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTempoEspera() {
        return tempoEspera;
    }

    public void setTempoEspera(Double tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public Double getTempoTravessia() {
        return tempoTravessia;
    }

    public void setTempoTravessia(Double tempoTravessia) {
        this.tempoTravessia = tempoTravessia;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Direcao getDirecaoCarro() {
        return direcaoCarro;
    }

    public void setDirecaoCarro(Direcao direcaoCarro) {
        this.direcaoCarro = direcaoCarro;
    }

    public Double getTempoEsperado() {
        return tempoEsperado;
    }

    public void setTempoEsperado(Double tempoEsperado) {
        this.tempoEsperado = tempoEsperado;
    }

    public Double getTempoAtravessando() {
        return tempoAtravessando;
    }

    public void setTempoAtravessando(Double tempoAtravessando) {
        this.tempoAtravessando = tempoAtravessando;
    }
    
    public void teste(Carro carro) throws InterruptedException{
        anime.paraEsquerda(this);
        
    }
    
    public void carroEspera(Carro carro, Double tempoAtual, Double tempoAnterior) throws InterruptedException{
        
        tempoAtual = Double.parseDouble(System.currentTimeMillis()+"");
        tempoAnterior = tempoAtual;
        
        
        
        if(carro.getDirecaoCarro() == Direcao.Direita){
            //anime.stopE(carro);
        }else{
            //anime.stopD(carro);
        }
        
        while((tempoAtual - tempoAnterior)/1000 < tempoEspera){
	
            tempoAtual = Double.parseDouble(System.currentTimeMillis()+"");
	
        }
        System.out.println("parado " +carro.id);
        
                    
        if(carro.isInterrupted())throw new InterruptedException();
    }
    
    public void carroAtravessa(Carro carro, Double tempoAtual,Double tempoAnterior) throws InterruptedException{
        
        tempoAtual = Double.parseDouble(System.currentTimeMillis()+"");
        tempoAnterior = tempoAtual;
    
        
        
        carro.setEstado(Estado.Atravessando);
        if(carro.getDirecaoCarro() == Direcao.Direita){
            //anime.paraDireita(carro);
        }else{
            //anime.paraEsquerda(carro);
        }
        
        while((tempoAtual - tempoAnterior)/1000 < tempoTravessia +2 ){
            //Log.doLog(ManuseadorDeCarros.manuseador().getCarros());
         
            tempoAtual = Double.parseDouble(System.currentTimeMillis()+"");
            
        }
             
        System.out.println("atravessa " + carro.id);
        
        
        if(carro.isInterrupted())throw new InterruptedException();
        
    }
   
}

