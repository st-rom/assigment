import java.net.*;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Parser {
    public static void main(String[] args) throws Exception {
        URL oracle = new URL("http://api.openweathermap.org/data/2.5/" +
                "weather?q=Lviv&APPID=5496614f4ca95e6dcc0445c1e7f3916d");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(in);
        JSONObject jsonObject = (JSONObject) obj;
        System.out.println(jsonObject);
        String weather = (String) (((JSONObject) ((JSONArray) jsonObject.get("weather")).get(0)).get("description"));
        double kel = (Double) ((JSONObject) jsonObject.get("main")).get("temp");
        double cel = kel - 273.15;
        System.out.println(weather);
        System.out.println(kel);
        System.out.println(cel);
    }
}