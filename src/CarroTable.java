
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anaad
 */
public class CarroTable {
    
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty estado;
    private final SimpleDoubleProperty tt;
    private final SimpleDoubleProperty tp;

    public CarroTable(Integer id,String estado, Double tt, Double tp) {
        this.id = new SimpleIntegerProperty(id);
        this.estado = new SimpleStringProperty(estado);
        this.tt = new SimpleDoubleProperty(tt);
        this.tp = new SimpleDoubleProperty(tp);
    }

    
}
