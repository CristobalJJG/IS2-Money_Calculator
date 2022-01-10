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
import java.util.ArrayList;

public class Currencies {
    
    private static final ArrayList<String> currencies = new ArrayList<>();
    private static String sc = "";
    
    public Currencies(){
        sc = read();
        sc = sc.substring(1, sc.length()-2);
    }
    
    private static String read(){
        String url_str = "https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies.json";
        try{
            URL url_ = new URL(url_str);
        
            HttpURLConnection request = (HttpURLConnection) url_.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            return jsonobj.toString();
        }catch(JsonIOException | JsonSyntaxException | 
                IOException | NumberFormatException e){
            System.out.println(e);
        }
        return "0.";
    }

    private static void showCurrencies() {
        String[] sps = sc.split(",");
        for(String s : sps){System.out.println(s);}
    }
    
    public String[] getCurrencies(){
        String[] sps = sc.split(",");
        for(String s : sps){
            currencies.add(s.split("\"")[1]);
        }
        return toStringArray();
    }
    
    private String[] toStringArray(){
        String[] currenciesResult = new String[currencies.size()-1];
        for (int i = 0; i < currenciesResult.length; i++) {
            currenciesResult[i] = currencies.get(i).toLowerCase();
        }
        return currenciesResult;
    }
}
