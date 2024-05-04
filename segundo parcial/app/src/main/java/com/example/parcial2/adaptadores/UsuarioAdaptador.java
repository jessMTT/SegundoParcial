package com.example.parcial2.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2.R;
import com.example.parcial2.clases.Deporte;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UsuarioAdaptador extends RecyclerView.Adapter<UsuarioAdaptador.ViewHolder> {

    private List<Deporte> datos;
    public UsuarioAdaptador(List<Deporte> datos){
        this.datos = datos;
    }
    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adaptador,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Deporte dato = datos.get(position);
        holder.bind(dato);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(dato);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_nombre, txt_descripcion;
        ImageView img_deporte;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_nombre = itemView.findViewById(R.id.txt_nombre);
            txt_descripcion = itemView.findViewById(R.id.txt_descripcion);
            img_deporte = itemView.findViewById(R.id.img_deporte);
        }
        public void bind (Deporte dato){
            txt_nombre.setText(dato.getNombre());
            txt_descripcion.setText(dato.getDescripcion());
            // imagen libreria
            Picasso.get().load(dato.getImagen()).into(img_deporte);
        }
    }
    public interface OnItemClickListener {
        void onItemClick(Deporte deporte);
    }

}
