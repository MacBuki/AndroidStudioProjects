package androidtown.org.may23th2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> arSensor = sm.getSensorList(Sensor.TYPE_ALL);

        String result = " 갯수 : " + arSensor.size() + "\n\n";
        for (Sensor s : arSensor) {
            result += (" 이름 = " + s.getName() + ",\n 형식 = " + s.getType() +
                    ",\n 제조사 = " + s.getVendor() +
                    ",\n 전원 = " + s.getPower() + ",\n 해상도 = " +
                    s.getResolution() + ",\n 범위 = " + s.getMaximumRange() + "\n\n");
        }
        TextView txtResult = findViewById(R.id.result);
        txtResult.setText(result);
    }
}
