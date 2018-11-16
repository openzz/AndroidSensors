package com.example.ah.sensorsaccess;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

//import sensors
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.widget.ListView;

import com.example.ah.sensorsaccess.SensorActivities.*;


public class SensorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        final ListView myListView = (ListView)findViewById(R.id.sensors_list_view);

        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        final List<Sensor> listSensor = sensorManager.getSensorList(Sensor.TYPE_ALL);

        final List<String> listSensorType = new ArrayList<>();
        for(int i = 0; i < listSensor.size(); i++){
            listSensorType.add(listSensor.get(i).getName());
        }

        ArrayAdapter myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listSensorType);
        myListView.setAdapter(myArrayAdapter);
        myListView.setTextFilterEnabled(true);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String selectedItemString = listSensorType.get(position);
                //Long selectedItem = myListView.getItemIdAtPosition(position);
                Sensor selectedItemSensor = listSensor.get(position);
                Intent intent = new Intent();


                switch (selectedItemSensor.getName()){
                    case "ACCELEROMETER":
                        intent  = new Intent(SensorsActivity.this, SensAccelerometerActivity.class);
                        intent.putExtra("sensorType", Sensor.TYPE_ACCELEROMETER);
                        break;
                    case "PROXIMITY":
                        intent = new Intent(SensorsActivity.this, SensProximityActivity.class);
                        intent.putExtra("sensorType", Sensor.TYPE_PROXIMITY);
                        break;
                    case "LIGHT":
                        intent = new Intent(SensorsActivity.this, SensLightActivity.class);
                        intent.putExtra("sensorType", Sensor.TYPE_LIGHT);
                        break;
                    case "GYROSCOPE":
                        intent = new Intent(SensorsActivity.this, SensGyroscopeActivity.class);
                        intent.putExtra("sensorType", Sensor.TYPE_GYROSCOPE);
                        break;
                    case "ORIENTATION":
                        intent = new Intent(SensorsActivity.this, SensOrientationActivity.class);
                        intent.putExtra("sensorType", Sensor.TYPE_ORIENTATION);
                        break;
                    case "MAGNETOMETER":
                        intent = new Intent(SensorsActivity.this, SensMagnetometerActivity.class);
                        intent.putExtra("sensorType", Sensor.TYPE_MAGNETIC_FIELD);
                        break;
                    case "SIGNIFICANT_MOTION":
                        intent = new Intent(SensorsActivity.this, SensSignificantMotionActivity.class);
                        intent.putExtra("sensorType", Sensor.TYPE_SIGNIFICANT_MOTION);
                        break;
                    case "BMI160 Rotation Vector Sensor":
                        intent = new Intent(SensorsActivity.this, SensRotationVectorActivity.class);
                        intent.putExtra("sensorType", Sensor.TYPE_ROTATION_VECTOR);
                        break;
                    case "BMI160 Linear Accelerometer Sensor":
                        intent = new Intent(SensorsActivity.this, SensLinearAccelerometerActivity.class);
                        intent.putExtra("sensorType", Sensor.TYPE_LINEAR_ACCELERATION);
                        break;
                        default:
                            break;
                }
                startActivity(intent);
            }
        });
    }

}
