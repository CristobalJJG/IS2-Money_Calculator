package Controlador;

import Interfaz.View;
import Modelo.Model;

public class Controller {
    private View vista;
    
    public Controller(){
        this.vista = new View();
    }
    
    public static double update(double amount,String from,String to){
        try {
            Model modelo = new Model(amount, from, to);
            modelo.calculateExchange();
            return modelo.getExchange();
        }catch(Exception e){
            System.out.println(e);
        }
        return 0.0;
    }
}
