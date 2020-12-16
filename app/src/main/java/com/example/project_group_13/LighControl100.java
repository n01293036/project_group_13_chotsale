package com.example.project_group_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class LighControl100 extends AppCompatActivity {

    ImageView congtac, threetia, left ,right;
    TextView note, nhietdo, doam, pressure;
    int count = 0;
    int pe = 0;
    double temp = 10.2;
    double humi = 60.5;
    double pres= 1031.4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ligh_control100);

        threetia = findViewById(R.id.threetia);
        congtac = findViewById(R.id.congtac);
        note = findViewById(R.id.note);
        nhietdo = findViewById(R.id.nhietdo);
        doam = findViewById(R.id.doam);
        pressure = findViewById(R.id.pressure);
        note.setText("Press to turn on");
        nhietdo.setText("Temperature:"+temp+"(C)temperature");
        doam.setText("Humidity:"+humi+"%");
        pressure.setText("Pressure:"+pres+"hPa");
        left = findViewById(R.id.leftlight);
        right = findViewById(R.id.rightlight);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LighControl100.this, MenuLeft.class);
                startActivity(intent);
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LighControl100.this, MenuRight.class);
                startActivity(intent);
            }
        });



        congtac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count%2!=0){
                    congtac.setImageResource(R.drawable.congtacxanh);
                    threetia.setImageResource(R.drawable._tia);
                    note.setText("Press to turn off");
                } else {
                    congtac.setImageResource(R.drawable.congtacdo);
                    threetia.setImageDrawable(null);
                    note.setText("Press to turn on");
                }
            }
        });

        new Timer().schedule(new TimerTask(){
            @Override
            public void run() {
                runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        pe++;
                        if(pe%3==0){
                            temp=temp+0.5;
                            humi=humi+1;
                            pres=pres+4;
                            nhietdo.setText(temp+"(C)");
                            doam.setText(humi+"%");
                            pressure.setText(pres+"hPa");
                        } else if(pe%3==1){
                            temp=temp-1;
                            humi=humi-1.5;
                            pres=pres-3;
                            nhietdo.setText(temp+"(C)");
                            doam.setText(humi+"%");
                            pressure.setText(pres+"hPa");
                        } else{
                            temp=temp+0.5;
                            humi=humi+0.5;
                            pres=pres-1;
                            nhietdo.setText(temp+"(C)");
                            doam.setText(humi+"%");
                            pressure.setText(pres+"hPa");
                        }
                    };
                });
            }
        }, 100, 1000);
    }
}