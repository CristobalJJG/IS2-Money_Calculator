package money_calculator;

import Controlador.Controller;
import Interfaz.View;
import Modelo.Currencies;
import Modelo.Model;

public class Try_Class {
    public static void main(String[] args){
        //try_modelo();
        //try_view();
        //try_all();
        new Currencies();
    }
    
    private static void try_all(){
        Controller c = new Controller();
    }
        
    private static void try_view(){
        View i = new View();
    }
    
    private static void try_modelo(){
        Model m = new Model(1, "BTC", "EUR");
        show(1., "BTC", "EUR");m.calculateExchange();
        split();
        m = new Model(50, "USD", "EUR");
        show(50, "USD", "EUR");m.calculateExchange();
        split();
        m = new Model(50, "EUR", "USD");
        show(50, "EUR", "USD");m.calculateExchange();
        split();
        m = new Model(50, "GBP", "EUR");
        show(50, "GBP", "EUR");m.calculateExchange();
        split();
    }

    private static void show(double n, String m1, String m2) {
        System.out.print(n + " " + m1 + " -> " + m2 + ": ");
    }
    private static void split(){
        System.out.println("|-------------------------|\n");
    }
}
