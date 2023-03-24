package com.example.slideshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private int image =0;
    private int [] images = {R.drawable.logo, R.drawable.onepiece, R.drawable.kaido,
    R.drawable.bigmom};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(images[image]);

        Button buttonNext = findViewById(R.id.button_next);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image++;
                if (image == images.length){
                    image = 0;
                }
                imageView.setImageResource(images[image]);
            }
        });

        Button buttonUntil = findViewById(R.id.button_until);
        buttonUntil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image--;
                if (image < 0 ){
                    image=images.length-1;
                }
                imageView.setImageResource(images[image]);
            }
        });

        Button buttonHome = findViewById(R.id.button_home);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image=0;
                imageView.setImageResource(images[image]);
            }
        });
    }
}