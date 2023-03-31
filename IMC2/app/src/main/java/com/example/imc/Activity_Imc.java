package com.example.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Activity_Imc extends AppCompatActivity {

    Double kg, alt;
    TextView tvPeso, tvAltura, tvImc;
    DecimalFormat decimalFormat = new DecimalFormat("##,###,###,##0.00");
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        Bundle bundle = getIntent().getExtras();

       kg = bundle.getDouble("kg");
        alt =bundle.getDouble("alt");

        tvImc=findViewById(R.id.tvImc);

        double imc = kg/(alt * alt);
        if(imc<18.5){
            tvImc.setText("Você está Abaixo do peso");
        }else if(imc<18.5 && imc <= 24.99){
            tvImc.setText("Seu Peso normal");
        }else if(imc >=25 && imc <= 29.99){
            tvImc.setText("Você está com Sobrepeso");
        }else if (imc >=30  && imc <= 34.99){
            tvImc.setText("Você está com Obesidade grau 1");
        }else if (imc>= 35  && imc <= 39.99){
            tvImc.setText("Você está com Obesidade grau 2");
        }else if (imc>40){
            tvImc.setText("Você está com Obesidade grau 3");
        }
    }
}
