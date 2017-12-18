import java.net.*;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Parser {
    private String url;
    public Parser(String city){
        url = "http://api.openweathermap.org/data/2.5/weather?q=" +
                city + "&APPID=5496614f4ca95e6dcc0445c1e7f3916d";
    }

    //public static void main(String[] args) throws Exception {
    public JSONObject parse() throws Exception {
        URL oracle = new URL(url);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(in);
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;
    }

    public String get_city_name(JSONObject jo){
        return (String) jo.get("name");
    }

    public String get_weather(JSONObject jo){
        return (String) (((JSONObject) ((JSONArray) jo.get("weather")).get(0)).get("description"));
    }

    public double get_temp(JSONObject jo, TempType tt){
        return (Double) ((JSONObject) jo.get("main")).get("temp") - tt.toDouble();
    }
}