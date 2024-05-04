package com.example.parcial2;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt_user, edt_pass;
    Button btn_ini;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static final String dataUser = "dataUser";
    private static final int modoPrivate = Context.MODE_PRIVATE;
    String dato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_user = findViewById(R.id.edt_user);
        edt_pass = findViewById(R.id.edt_pass);
        btn_ini = findViewById(R.id.btn_ini);

        sharedPreferences = getSharedPreferences(dataUser, modoPrivate);
        editor = sharedPreferences.edit();
        dato = getApplicationContext().getSharedPreferences(dataUser, modoPrivate).getString("user", "0");
        if(!dato.equalsIgnoreCase("0")){
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(i);
            finish();
        }
        btn_ini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usu = edt_user.getText().toString();
                String pass = edt_pass.getText().toString();
                if (usu.equals("") || pass.equals(""))
                    Toast.makeText(MainActivity.this, "Rellena los campos ", Toast.LENGTH_SHORT).show();
                else {
                    editor.putString("user", usu);
                    editor.commit();
                    Intent i = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(i);
                    finish();}
            }
        });
    }
}