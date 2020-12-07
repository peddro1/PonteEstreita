/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponteestreita;

import java.util.concurrent.Semaphore;
import ponteestreita.enums.Direcao;

/**
 *
 * @author anaad
 */
public class Ponte {
    private static Ponte instancia = null;
    private Double tamanho;
    public static Semaphore liberaPonte = new Semaphore(1);   //controle da ponte
    public static Semaphore mutex = new Semaphore(1);        //controle da regiao critica
    public static int carros = 0;                                 //carros na ponte
    
    private Direcao direcaoPonte;
    private Direcao prioridade;
    
    public static int carrosDoOutroLado = 0;
    
    
    public Ponte( Direcao prioridade){
        super();
        
        
        this.direcaoPonte = Direcao.Nenhuma;
        this.prioridade = prioridade;
        this.liberaPonte = new Semaphore(1);
        
        this.mutex = new Semaphore(1);
        
    
    }
    
    
    public static Ponte novaPonte( Direcao prioridade){
        if(instancia == null){
            instancia = new Ponte( prioridade);
        }
        return instancia;
    }

    public static Ponte getInstancia() {
        return instancia;
    }

    public static void setInstancia(Ponte instancia) {
        Ponte.instancia = instancia;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }

    public static Semaphore getLiberaPonte() {
        return liberaPonte;
    }

    public static void setLiberaPonte(Semaphore liberaPonte) {
        Ponte.liberaPonte = liberaPonte;
    }

    public static Semaphore getMutex() {
        return mutex;
    }

    public static void setMutex(Semaphore mutex) {
        Ponte.mutex = mutex;
    }

    public static int getCarros() {
        return carros;
    }

    public static void setCarros(int carros) {
        Ponte.carros = carros;
    }

    public Direcao getDirecaoPonte() {
        return direcaoPonte;
    }

    public void setDirecaoPonte(Direcao direcaoPonte) {
        this.direcaoPonte = direcaoPonte;
    }

    public Direcao getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Direcao prioridade) {
        this.prioridade = prioridade;
    }

    public static int getCarrosDoOutroLado() {
        return carrosDoOutroLado;
    }

    public static void setCarrosDoOutroLado(int carrosDoOutroLado) {
        Ponte.carrosDoOutroLado = carrosDoOutroLado;
    }
    
    
    
}
