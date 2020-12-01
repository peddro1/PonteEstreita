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
        
        this.imagemCarroD = new Image("/imagens/carroD"+ (this.id+1) +".png");
        this.imagemCarroE = new Image("/imagens/carroE"+ (this.id+1) +".png");
        this.anime = anime;
      
    }
    
    @Override
    public void run(){
        try {
            this.teste(this);
        } catch (InterruptedException ex) {
            Logger.getLogger(Carro.class.getName()).log(Level.SEVERE, null, ex);
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
        anime.paraDireita(this);
    }
}

