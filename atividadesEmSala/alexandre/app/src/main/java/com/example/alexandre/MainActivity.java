package com.example.alexandre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void iniciaNovaActivity (View v){
        Intent i = new Intent(getApplicationContext(),Sorteio.class);
        startActivity(i);
    }
}