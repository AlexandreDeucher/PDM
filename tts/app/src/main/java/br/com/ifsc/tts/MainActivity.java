package br.com.ifsc.tts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etTextInput;
    private Button buttonSpeak;
    private TextToSpeechHelper textToSpeechHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTextInput = findViewById(R.id.editText);
        buttonSpeak = findViewById(R.id.buttonSpeak);

        textToSpeechHelper = new TextToSpeechHelper(this);

        buttonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = etTextInput.getText().toString();
                if (!text.isEmpty()) {
                    textToSpeechHelper.speak(text);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}