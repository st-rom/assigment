import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) throws Exception {
        Parser p = new Parser("London");
        JSONObject jsonObject = p.parse();
        System.out.println(p.get_city_name(jsonObject));
        System.out.println(p.get_weather(jsonObject));
        System.out.println(p.get_temp(jsonObject, TempType.CELSIUM));
        System.out.println(p.get_temp(jsonObject, TempType.KELVIN));
    }
}
