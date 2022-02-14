package com.example.mytrips.recyclerAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytrips.R;
import com.example.mytrips.viaje;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class miAdaptador extends RecyclerView.Adapter<miAdaptador.ViewHolder> {
    private ArrayList<viaje> arrayViajes;
    private LayoutInflater mInflater;
    private Context context;
    public miAdaptador(ArrayList<viaje> arrayViajes, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.arrayViajes = arrayViajes;
        this.context = context;
    }

    @NonNull
    @Override
    public miAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_element_mis_viajes,null);
        return new miAdaptador.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull miAdaptador.ViewHolder holder, int position) {
        holder.bindData(arrayViajes.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayViajes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconViaje;
        TextView pais;
        TextView ciudad;
        TextView desplazamiento;
        TextView fechaIda;
        TextView fechaVuelta;
        TextView alojamiento;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconViaje = itemView.findViewById(R.id.imagenViaje);
            pais = itemView.findViewById(R.id.paisDestinoViaje);
            ciudad = itemView.findViewById(R.id.ciudadDestinoViaje);
            desplazamiento = itemView.findViewById(R.id.desplazamientoViaje);
            fechaIda = itemView.findViewById(R.id.fechaIdaViaje);
            fechaVuelta = itemView.findViewById(R.id.fechaVueltaViaje);
            alojamiento = itemView.findViewById(R.id.alojamientoViaje);

        }

        @SuppressLint("ResourceType")
        public void bindData(final viaje itemViaje) {
        iconViaje = itemView.findViewById(R.drawable.avion_maletas);
        pais.setText(itemViaje.getPais());
        ciudad.setText(itemViaje.getCiudad());
        desplazamiento.setText(itemViaje.getDesplazamiento());
        fechaIda.setText(itemViaje.getFecha_ida());
        fechaVuelta.setText(itemViaje.getFecha_vuelta());
        alojamiento.setText(itemViaje.getTipo_alojamiento());


        }
    }
}
