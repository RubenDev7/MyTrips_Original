package com.example.mytrips;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText user,pass;
    Button botonAcceso;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        main();
        
        
    }

    private void main() {
        controls();
        comprobarLogin();
    }

    private void controls() {
        user = findViewById(R.id.inputUser);
        pass = findViewById(R.id.inputPassword);
        botonAcceso = findViewById(R.id.buttonInicio);
        prefs = getSharedPreferences(getString(R.string.preferencia), Context.MODE_PRIVATE);
    }

    private void comprobarLogin() {
        botonAcceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getText().toString().equals("") || pass.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),"INTRODUCE USUARIO Y CONTRASEÑA", Toast.LENGTH_LONG).show();
                } else {
                        String u = user.getText().toString();
                        String p = pass.getText().toString();

                        if (u.toUpperCase().equals("RUBEN") && p.toUpperCase().equals("RUBEN")){
                            prefs.edit().putBoolean("logueado",true).commit();
                            Intent i = new Intent(login.this,MainActivity.class);
                            startActivity(i);
                    }
                }
            }
        });
    }

}