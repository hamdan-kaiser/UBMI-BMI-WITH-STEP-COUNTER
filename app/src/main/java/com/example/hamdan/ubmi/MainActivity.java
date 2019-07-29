package com.example.hamdan.ubmi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
/**
 * Project name: UBMI
 * Objectives: An app that calculates BMI,
 * keeps the history and keep track of your daily walking via connecting with a wristband.
 *
 * Project API’s:
 * 1.	Socket
 * 2.	Alter Dialog
 * 3.	Bluetooth Adapter
 * 4.	Bluetooth Socket
 * 5.	Dialog Interface
 * 6.	BroadcastReciever
 * 7.	InterFilter
 * 8.	RegisterReciver
 * 9.	createRfcommSocketToServiceRecord
 * 10.	Inflate
 * 11.	Hashmap
 *
 *
 * Bugs to fix:
 * 1.	For our projects, there were too little online reference because we are working both with the software and hardware.
 * 2.	It was a tough work to connect the Arduino with the app. It was easy to send data to Arduino but receiving data was too tough.
 * 3.	Another task was tough, that is the data coming from Arduino was on bytes,
 * the conversion bytes to string was a little bit tough.
 *
 * Our Team Members:
 * 1. MARJANA RAHMAN
 * 2. MD. RIFATUL ISLAM RIFAT
 * 3. HAMDAN KAISER */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    Button BMITest, database, dietChart,exercise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BMITest = findViewById(R.id.testBMI);
        database = findViewById(R.id.database);
        dietChart = findViewById(R.id.dietchart);
        exercise = findViewById(R.id.exercise);

        BMITest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),BMICategory.class);
                startActivity(i);
            }
        });

        database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ListDataActivity.class);
                startActivity(intent);
            }
        });

        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new Class
                Intent intent = new Intent(MainActivity.this, Excercise.class);
                startActivity(intent);
            }
        });

    }
}
