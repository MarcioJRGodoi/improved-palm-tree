package com.example.minahanimacao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editSenha;
    private Button btnEntrar;
    private Button btnRegistro;
    private Switch switchLembrar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        switchLembrar = findViewById(R.id.editSwith);

        SharedPreferences sharedPreferences = getSharedPreferences("padrao", MODE_PRIVATE);

        editEmail.setText(sharedPreferences.getString("Email", ""));
        switchLembrar.setChecked(sharedPreferences.getBoolean("Lembrar", false));

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (
                        editEmail.getText().toString().isEmpty() ||
                                editSenha.getText().toString().isEmpty()
                ) {
                    // Trate o erro aqui
                } else {
                    if (
                            editEmail.getText().toString().equals("admin@gmail.com") &&
                                    editSenha.getText().toString().equals("admin")
                    ) {
                        Intent it = new Intent(LoginActivity.this, MainActivity.class);
                        it.putExtra("KEY_LEGENDA", editEmail.getText().toString());
                        it.putExtra("KEY_SENHA", editSenha.getText().toString());
                        startActivity(it);

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean("Lembrar", switchLembrar.isChecked());
                        if (switchLembrar.isChecked()) {
                            editor.putString("Email", editEmail.getText().toString());
                        } else {
                            editor.remove("Email");
                        }
                        editor.apply();
                    }
                }
            }
        });
    }
}
