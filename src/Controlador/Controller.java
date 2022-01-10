package Controlador;

import Interfaz.View;
import Modelo.Model;

public class Controller {
    
    public Controller(){
        new View();
    }
    
    public static double update(double amount,String from,String to){
        try {
            if(amount != 0. && !from.equals(to)){
                Model modelo = new Model(amount, from, to);
                modelo.calculateExchange();
                return modelo.getExchange();
            }else if(from.equals(to)){
                return amount;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return 0.0;
    }
}
