/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponteestreita;

/**
 *
 * @author anaad
 */
public class Prioridade {
    
    private String lado;

    public Prioridade(String lado) {
        this.lado = lado;
    }

    
    
    public String getLado() {
        return lado;
    }

    public void setLado(String lado) {
        this.lado = lado;
    }

    @Override
    public String toString() {
        return getLado();
    }
    
    
}
