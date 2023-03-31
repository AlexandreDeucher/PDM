package com.example.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    EditText edPeso, edAltura;
    Button btnCalc;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         edPeso= findViewById(R.id.edPeso);
        edAltura= findViewById(R.id.edAltura);
    }
    public void calcular(View view){
        Intent i = new Intent(this, Activity_Imc.class);
        Double kg = Double.parseDouble(edPeso.getText().toString());
        Double alt = Double.parseDouble(edAltura.getText().toString());

        i.putExtra("peso", kg);
        i.putExtra("altura", alt);

        startActivity(i);
    }
}