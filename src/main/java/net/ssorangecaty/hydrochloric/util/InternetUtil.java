package net.ssorangecaty.hydrochloric.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.ssorangecaty.hydrochloric.Hydrochloric;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class InternetUtil {
    public static String getWeather(String city) throws Exception {
        String key = "96eaaa391966051eae3350146a332878";
        String urlString = "https://restapi.amap.com/v3/weather/weatherInfo?key=" + key + "&city=" + URLEncoder.encode(city, StandardCharsets.UTF_8);

        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();


        String jsonString = content.toString();
        JsonElement rootElement = JsonParser.parseString(jsonString);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonArray lives = rootObject.getAsJsonArray("lives");
        JsonObject weatherInfo = lives.get(0).getAsJsonObject();
        String weather = weatherInfo.get("weather").getAsString();
        Hydrochloric.LOGGER.info("通过橘子的API访问到了当前存档绑定城市的天气"+city+"的天气为 "+weather);
        return weather;
    }

}
