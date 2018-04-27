package jp.techacademy.son.postalcode;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by taiso on 2018/04/27.
 */

public class WeatherApi {

    private static final String API_ENDPOINT
            = "http://geoapi.heartrails.com/api/json?method=searchByPostal&postal=";

    public static WeatherForecast getWeather(String cityId)
            throws IOException, JSONException {

        URL uri = new URL(API_ENDPOINT + cityId);
        HttpURLConnection connection = (HttpURLConnection) uri.openConnection();

        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } finally {
            connection.disconnect();
        }

        return new WeatherForecast(new JSONObject(sb.toString()));
    }
}
