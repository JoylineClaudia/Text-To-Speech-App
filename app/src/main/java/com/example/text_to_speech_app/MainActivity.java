package com.example.text_to_speech_app;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {

    Button btn_speak;
    EditText txt_speak;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_speak =(Button)findViewById(R.id.btn_speech);
        txt_speak =(EditText)findViewById(R.id.Edt_txt) ;
        btn_speak.setOnClickListener(this);
        textToSpeech = new TextToSpeech(getBaseContext(),this);
        textToSpeech.setLanguage(Locale.ENGLISH);
    }

    @Override
    public void onClick(View view) {
        String text = txt_speak.getText().toString();
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onInit(int Status) {
        if (Status!=TextToSpeech.ERROR)
        {
            Toast.makeText(getBaseContext(),"Success", Toast.LENGTH_LONG).show();
        }
    }
}