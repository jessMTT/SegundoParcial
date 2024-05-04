package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.parcial2.adaptadores.UsuarioAdaptador;
import com.example.parcial2.clases.Deporte;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity implements UsuarioAdaptador.OnItemClickListener{

    public static final String dataUser = "dataUser";
    private static final int modoPrivate = Context.MODE_PRIVATE;
    TextView txt_usuario;
    String dato;
    RecyclerView rcv_deportes;
    List<Deporte> deporteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt_usuario = findViewById(R.id.txt_usuario);
        dato = getApplicationContext().getSharedPreferences(dataUser, modoPrivate).getString("user", "0");
        if (!dato.equals("0"))
            txt_usuario.setText(dato);
        else
            txt_usuario.setText("No encontrado");

        rcv_deportes = findViewById(R.id.rcv_deportes);

        Deporte dep1 = new Deporte("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRvOWn0Z8rO73oycrjH02b4ArcoW0XtTLpv5VAYstrlUA&s", "Natación", "Práctica y deporte consistentes en nadar.");
        Deporte dep2 = new Deporte("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEGBunUr2tJfND8lNtjD4bgrZBLUnpbvxapwzyaiB_EQ&s", "Básquet", "El objetivo del baloncesto es marcar más puntos que el equipo contrincante, encestando el balón en el cesto contrario e impidiendo a los jugadores contrincantes encestar en la propia.");
        Deporte dep3 = new Deporte("https://concepto.de/wp-content/uploads/2015/02/futbol-1-e1550783405750.jpg", "Fútbol", "El objetivo del juego es desplazar una pelota a través del campo para intentar ubicarla dentro de la meta contraria, acción que se denomina gol. El equipo que marque más goles al cabo del partido es el que resulta ganador.");
        Deporte dep4 = new Deporte("https://s1.significados.com/foto/voleibol-cancha-y-red.jpg?class=article", "Voleibol", "Es un deporte donde dos equipos se enfrentan sobre un terreno de juego liso separados por una red central, tratando de pasar el balón por encima de la red hacia el suelo del campo contrario.");
        Deporte dep5 = new Deporte("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLcL8eJHnYD1RtauieRQzcCSz0CNMz4dCO39-RQEoLww&s", "Béisbol", "El béisbol es un deporte de bate y pelota jugado en un campo por dos equipos uno contra el otro. En el béisbol, un jugador de un equipo lanza una pelota pequeña y redonda a un jugador del otro equipo, quien trata de golpearla con un bate. Luego, el jugador que golpea la pelota tiene que correr alrededor del campo.");

        deporteList.add(dep1);
        deporteList.add(dep2);
        deporteList.add(dep3);
        deporteList.add(dep4);
        deporteList.add(dep5);

        rcv_deportes.setLayoutManager(new LinearLayoutManager(this));
        rcv_deportes.setAdapter(new UsuarioAdaptador(deporteList));

        UsuarioAdaptador adaptador = new UsuarioAdaptador(deporteList);
        rcv_deportes.setAdapter(adaptador);
        adaptador.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(Deporte deporte) {
        Intent i = new Intent(MainActivity2.this, MainActivity3.class);
        i.putExtra("nombre", deporte.getNombre());
        i.putExtra("descripcion", deporte.getDescripcion());
        i.putExtra("imagen", deporte.getImagen());
        startActivity(i);
        finish();
    }
}