package jp.techacademy.son.postalcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView result;

    public class ApiTask extends GetWeatherForecastTask {
        @Override
        protected void onPostExecute(WeatherForecast data) {
            super.onPostExecute(data);

            if (data != null) {
                result.append(data.locationList.get(0).prefecture + " " + data.locationList.get(0).city);
            } else if (exception != null) {
                Toast.makeText(getApplicationContext(), exception.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.tv_result);

        new ApiTask().execute("2570002");
    }
}
