package br.com.ifsc.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<String> listaPalavras;
    ListView listView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaPalavras=new ArrayList<>();
        listaPalavras.add("Abacaxi");
        listaPalavras.add("Alexandre");
        listaPalavras.add("Junior");

        listView=findViewById(R.id.listView);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaPalavras.add(editText.getText().toString());
                atualizaLista();
            }
        });
    }
    public void atualizaLista(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                listaPalavras);
        listView.setAdapter(adapter);
    }
}