package com.example.mytrips.fragments;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.mytrips.R;
import com.example.mytrips.sqlite.adminsqlite;

import java.util.ArrayList;

public class nuevoViaje extends Fragment {
    private static final int CODIGO_ABRIR_GALERIA = 0;
    Button seleccionarFoto;
    EditText pais;
    EditText ciudad;
    EditText desplazamiento;
    EditText fechaIda;
    EditText fechaVuelta;
    EditText alojamiento;
    Switch favoritos;
    Button crearViaje;
    Button borrarDatos;
    Boolean swFavoritos = true;
    ActivityResultLauncher <Intent> activityResultLauncher;
    private SQLiteDatabase db;

    public nuevoViaje() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_nuevo_viaje, container, false);
        seleccionarFoto = vista.findViewById(R.id.inputFoto);
        pais = vista.findViewById(R.id.inputPais);
        ciudad = vista.findViewById(R.id.inputCiudad);
        desplazamiento = vista.findViewById(R.id.inputDesplazamiento);
        fechaIda = vista.findViewById(R.id.inputFechaIda);
        fechaVuelta = vista.findViewById(R.id.inputFechaVuelta);
        alojamiento = vista.findViewById(R.id.inputAlojamiento);
        favoritos = vista.findViewById(R.id.switchInputFavoritos);
        crearViaje = vista.findViewById(R.id.buttonCrearViaje);
        borrarDatos = vista.findViewById(R.id.buttonBorrarDatosViaje);
        main();
        // Inflate the layout for this fragment
        return vista;
    }

    private void main() {
        getActivityResult();
        validarDatos();
        abrirGaleria();
        
    }

    private void comprobarPermisos() {
        int check_permisos = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE);

        if (check_permisos!= PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String [] {Manifest.permission.READ_EXTERNAL_STORAGE},CODIGO_ABRIR_GALERIA);
        } else {
            abrirGaleria();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case CODIGO_ABRIR_GALERIA: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    abrirGaleria();
                } else {
                    Log.e("Error","No se pudo abrir la camara");
                }
            }
        }
        return;
    }

    private void getActivityResult() {
        activityResultLauncher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() ==Activity.RESULT_OK) {
                            Intent intentCamara = result.getData();
                        } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                            Toast.makeText(getContext(),"ACCION CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void abrirGaleria () {
        seleccionarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fotoViaje = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                activityResultLauncher.launch(fotoViaje);
                comprobarPermisos();
            }
        });
    }

    private void validarDatos() {

        crearViaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"PRUEBA", Toast.LENGTH_LONG).show();
                if (    pais.getText().toString().equals("") ||
                        ciudad.getText().toString().equals("") ||
                        desplazamiento.getText().toString().equals("") ||
                        fechaIda.getText().toString().equals("") ||
                        fechaVuelta.getText().toString().equals("") ||
                        alojamiento.getText().toString().equals("")

                ) {
                    Toast.makeText(getContext(),"Introduce todos los datos", Toast.LENGTH_SHORT).show();
                } else {
                    favoritos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                            if (favoritos.isChecked()) {
                                swFavoritos = true;
                            } else {
                                swFavoritos = false;
                            }
                        }
                    });

                    if (swFavoritos) {
                        adminsqlite bbdd = new adminsqlite(getContext(),"DBViajesFAVS",null,1);
                        db = bbdd.getWritableDatabase();
                        if (db!=null) {
                         String p = pais.getText().toString();
                         String c = ciudad.getText().toString();
                         String d = desplazamiento.getText().toString();
                         String fi = fechaIda.getText().toString();
                         String fv = fechaVuelta.getText().toString();
                         String a = alojamiento.getText().toString();
                         String sqlInsert;
                         sqlInsert = "INSERT INTO viajes_favoritos values ('"+p+"','"+c+"','"+d+"','"+fi+"','"+fv+"','"+a+"');";
                         db.execSQL(sqlInsert);
                        }
                        Toast.makeText(getContext(),"Viaje creado en favoritos ❤  ", Toast.LENGTH_LONG).show();
                        limpiarInputs();
                    } else {
                        Toast.makeText(getContext(),"Viaje creado", Toast.LENGTH_LONG).show();
                        limpiarInputs();
                    }
                    db.close();
                }
            }
            private void limpiarInputs() {
                pais.setText("");
                ciudad.setText("");
                desplazamiento.setText("");
                fechaIda.setText("");
                fechaVuelta.setText("");
                alojamiento.setText("");
            }

        });
    }
}