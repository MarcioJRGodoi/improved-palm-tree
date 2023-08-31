package com.example.minahanimacao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView legenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        legenda = findViewById(R.id.legenda);
        legenda.setText(getIntent().getStringExtra("KEY_LEGENDA"));
    }
}