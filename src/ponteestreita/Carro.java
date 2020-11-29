/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponteestreita;

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
	
    
    private Double tempoEsperado;
    private Double tempoAtravessando;
    
    public Carro(Integer id, Double tempoEspera, Double tempoTravessia,Direcao direcaoCarro) {
	super();
	this.id = id;
	this.tempoEspera = tempoEspera;
	this.tempoTravessia = tempoTravessia;
	this.estado = Estado.Parado;
	this.direcaoCarro = direcaoCarro;
    }
    
    @Override
    public void run(){
        
        
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
    
}
