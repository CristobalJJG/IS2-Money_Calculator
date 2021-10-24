package money_calculator;

import Interfaz.View;
import Modelo.Modelo;

public class Try_Class {
    public static void main(String[] args){
        try_modelo();
        //try_view();
    }
        
    private static void try_view(){
        View i = new View();
    }
    
    private static void try_modelo(){
        Modelo m = new Modelo(1, "BTC", "EUR");
        show(1., "BTC", "EUR");m.calculateExchange();
        split();
        m = new Modelo(50, "USD", "EUR");
        show(50, "USD", "EUR");m.calculateExchange();
        split();
        m = new Modelo(50, "EUR", "USD");
        show(50, "EUR", "USD");m.calculateExchange();
        split();
        m = new Modelo(50, "GBP", "EUR");
        show(50, "GBP", "EUR");m.calculateExchange();
        split();
    }

    private static void show(double n, String m1, String m2) {
        System.out.print(n + " " + m1 + " -> " + m2 + ": ");
    }
    private static void split(){
        System.out.println("<------------------------->\n");
    }
}
