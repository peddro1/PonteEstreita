/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponteestreita;

import java.util.ArrayList;
import java.util.List;
import ponteestreita.enums.Direcao;

/**
 *
 * @author anaad
 */
public class Controlador {
    private static Controlador instancia = null;
    private Integer maximoCarros;
    private List<Carro> carrosJuntos;
    
    private Controlador(Integer maximoCarros){
        this.maximoCarros = maximoCarros;
        this.carrosJuntos = new ArrayList<Carro>();
        
    }
    
    public static void novoControlador(Integer maximoCarros){
        if(instancia == null){
            instancia = new Controlador(maximoCarros);
        }
    }
    
    
    public void iniciarCarros(){
        for(Carro carro: carrosJuntos){
            carro.start();
            
        }
    }
    /*
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
    */
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