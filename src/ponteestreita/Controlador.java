/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponteestreita;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.Animation;
import ponteestreita.enums.Direcao;
import ponteestreita.enums.Estado;

/**
 *
 * @author anaad
 */
public class Controlador {
    private static Controlador instancia = null;
    private Integer maximoCarros;
    private List<Carro> carrosJuntos;
    
    public Controlador(Integer maximoCarros){
        this.maximoCarros = maximoCarros;
        this.carrosJuntos = new ArrayList<Carro>();
        
    }
    
    public static Controlador novoControlador(Integer maximoCarros){
        if(instancia == null){
            instancia = new Controlador(maximoCarros);
            
        }
        return instancia;
    }
    
    
    public void iniciarCarros(){
        for(Carro carro: carrosJuntos){
            carro.start();
            
        }
    }
    
    public void eliminarCarro(List<Carro> carrosJuntos, Integer id){
        
        carrosJuntos.get(id).setId(-1);
        carrosJuntos.get(id).setTempoEspera(-1.0);
        carrosJuntos.get(id).setTempoTravessia(-1.0);
        carrosJuntos.get(id).setEstado(Estado.Eliminado);
        carrosJuntos.get(id).anime.elimina(carrosJuntos.get(id));
        carrosJuntos.set(id,carrosJuntos.get(id)).interrupt();
        
        //System.out.println(carrosJuntos.get(id).getIdCarro());
        
    }
    
    public void addCarro(Carro carro){
	carrosJuntos.add(carro);
        
    }
    
    
    
    public void mudarDirecaoCarro(Carro carro){
	Direcao nova;
	if(carro.getDirecaoCarro() == Direcao.Direita){
            nova = Direcao.Esquerda;
	}
	else{
            nova = Direcao.Direita;
	}
	carro.setDirecaoCarro(nova);
	System.out.println("Mudou "+nova);
    }
    
    public static Controlador getInstancia() {
        return instancia;
    }

    public static void setInstancia(Controlador instancia) {
        Controlador.instancia = instancia;
    }

    public Integer getMaximoCarros() {
        return maximoCarros;
    }

    public void setMaximoCarros(Integer maximoCarros) {
        this.maximoCarros = maximoCarros;
    }

    public List<Carro> getCarrosJuntos() {
        return carrosJuntos;
    }

    public void setCarrosJuntos(List<Carro> carrosJuntos) {
        this.carrosJuntos = carrosJuntos;
    }
    
}
