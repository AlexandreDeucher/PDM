package br.com.ifsc.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    SensorManager sensorManager;
    Sensor sensorGy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager =(SensorManager) getSystemService(Context.SENSOR_SERVICE);
            sensorGy = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        sensorManager.registerListener(this, sensorGy,SensorManager.SENSOR_DELAY_FASTEST);


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d("Sensor", "x"+sensorEvent.values[0]+";"+
        "y"+sensorEvent.values[1]+";"+
        "z"+sensorEvent.values[2]+";");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}