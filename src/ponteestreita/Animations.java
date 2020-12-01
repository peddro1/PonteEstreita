/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponteestreita;

import java.util.List;
import javafx.scene.image.Image;

/**
 *
 * @author anaad
 */
public interface Animations {
    void paraEsquerda(Carro carro);
    void paraDireita(Carro carro);
    void stop(Carro carro, Image image);
    void aguarda(Carro carro);
    void move(Carro carro, int x1, int y1, int x2, int y2, Image image, boolean flag);
    void elimina(Carro carro);
    
}
