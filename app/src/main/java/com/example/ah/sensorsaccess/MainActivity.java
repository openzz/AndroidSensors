package com.example.ah.sensorsaccess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShowSensorList = findViewById(R.id.button);
        btnShowSensorList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.button){
                    Intent intent = new Intent(MainActivity.this, SensorsActivity.class);
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }


}
