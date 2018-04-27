package jp.techacademy.son.postalcode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taiso on 2018/04/27.
 */

public class WeatherForecast {

    public final List<Location> locationList = new ArrayList<>();
    public WeatherForecast(JSONObject jsonObject) throws JSONException {

        JSONObject response = jsonObject.getJSONObject("response");

        JSONArray forecastArray = response.getJSONArray("location");
        int len = forecastArray.length();
        for (int i = 0; i < len; i++) {
            JSONObject forecastJson = forecastArray.getJSONObject(i);
            Location location = new Location(forecastJson);
            locationList.add(location);
        }

    }

    public static class Location {

        public final String city;
        public final String prefecture;

        public Location(JSONObject jsonObject) throws JSONException {
            city = jsonObject.getString("city");
            prefecture = jsonObject.getString("prefecture");
        }
    }
}
