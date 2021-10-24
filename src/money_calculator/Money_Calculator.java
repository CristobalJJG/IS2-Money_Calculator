package money_calculator;

import Interfaz.*;
import Modelo.*;

public class Money_Calculator {

    public static void main(String[] args){
        //View i = new View();
        Modelo m = new Modelo(1, "BTC", "EUR");
        m.calculateExchange();
    }
}
