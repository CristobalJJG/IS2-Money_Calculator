package Modelo;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Model {
    private final double amount;
    private double exchange;
    private final String from;
    private final String to;
    
    public Model(double amount, String from, String to){
        this.amount = amount;
        this.from = from;
        this.to = to;
    }
    
    public void calculateExchange(){
        double exchangeRate = getExchangeRate();
        exchange = amount * exchangeRate;
        System.out.println(exchange);
    }

    public double getExchange(){
        return exchange;
    }
    
    private double getExchangeRate(){
        String url_str = "https://api.exchangerate.host/convert?"
                + "from=" + from + "&to=" + to;
        URL url;
        try{
            url = new URL(url_str);
        
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            return Double.parseDouble(jsonobj.get("result").toString());
        }catch(JsonIOException | JsonSyntaxException | 
                IOException | NumberFormatException e){
            System.out.println(e);
        }
        return 0.;
    }
}
