package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.time.Instant;

public class MainActivity3 extends AppCompatActivity {

    Button btn_cerrar;
    public static final String dataUser = "dataUser";
    private static final int modoPrivate = Context.MODE_PRIVATE;
    TextView txt_nombre, txt_descripcion;
    ImageView img_deporte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn_cerrar = findViewById(R.id.btn_cerrar);
        txt_nombre = findViewById(R.id.txt_nombre);
        txt_descripcion = findViewById(R.id.txt_descripcion);
        img_deporte = findViewById(R.id.img_deporte);
        Intent intent = getIntent();
        if (intent != null) {
            String nombre = intent.getStringExtra("nombre");
            String descripcion = intent.getStringExtra("descripcion");
            String imagen = intent.getStringExtra("imagen");
            txt_nombre.setText(nombre);
            txt_descripcion.setText(descripcion);
            Picasso.get().load(imagen).into(img_deporte);
            btn_cerrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences configuration = getApplicationContext().getSharedPreferences(dataUser, modoPrivate);
                    configuration.edit().clear().commit();
                    Intent i = new Intent(MainActivity3.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            });
        }
    }
}