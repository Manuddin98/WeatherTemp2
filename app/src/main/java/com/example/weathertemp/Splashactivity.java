package com.example.weathertemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Splashactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);
        getSupportActionBar().hide();

        Thread thread=new Thread(){


            public void run(){
                try{
                   sleep(4000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent(Splashactivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };thread.start();

    }
}