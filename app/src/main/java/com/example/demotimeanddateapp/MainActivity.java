package com.example.demotimeanddateapp;

import static java.time.format.DateTimeFormatter.ofPattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp =  (DatePicker) findViewById(R.id.dateP);
        tp =  (TimePicker) findViewById(R.id.timeP);
        btnDisplayDate = (Button) findViewById(R.id.ButtonDisplayDate);
        btnDisplayTime = (Button) findViewById(R.id.ButtonDisplayTIme);
        tvDisplay = (TextView) findViewById(R.id.textView) ;
        btnReset = (Button) findViewById(R.id.btnRe);

        btnDisplayTime.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String hour = tp.getCurrentHour().toString();
                String minute = tp.getCurrentMinute().toString();
                String output = "Time is "+hour+" : "+minute;
                tvDisplay.setText(output);
            }
        });


        btnDisplayDate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String day = Integer.toString(dp.getDayOfMonth());
                String month = Integer.toString(dp.getMonth());
                String year = Integer.toString(dp.getYear());
                String output = "Date is "+day+"/"+month+"/"+year;
                tvDisplay.setText(output);
            }
        });

        btnReset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                    tp.setCurrentHour(12);
                    tp.setCurrentMinute(0);

                    String hour = tp.getCurrentHour().toString();
                    String minute = tp.getCurrentMinute().toString();
                    String output1 = "Time is "+hour+" : "+minute;


                    dp.updateDate(2020,01,01);

                    String day = Integer.toString(dp.getDayOfMonth());
                    String month = Integer.toString(dp.getMonth());
                    String year = Integer.toString(dp.getYear());
                    String output2 = output1+ "\nDate is "+day+"/"+month+"/"+year;

                    tvDisplay.setText(output2);

                }
        });

    }






}