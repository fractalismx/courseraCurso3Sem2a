package com.example.pablo.aplicacioncoursera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DatosActivity extends AppCompatActivity
{
    Bundle recibir;

    TextView tvMostrarNombre;
    TextView tvMostrarFecha;
    TextView tvMostrarTelefono;
    TextView tvMostrarEMail;
    TextView tvMostrarDescripcion;

    Button btneditar;

    String recibirNombre;
    String recibirFecha;
    String recibirTelefono;
    String recibirEMail;
    String recibirDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        tvMostrarNombre=(TextView) findViewById(R.id.tvMostrarNombre);
        tvMostrarFecha=(TextView) findViewById(R.id.tvMostrarFecha);
        tvMostrarTelefono=(TextView) findViewById(R.id.tvMostrarTelefono);
        tvMostrarEMail=(TextView) findViewById(R.id.tvMostrarEMail);
        tvMostrarDescripcion=(TextView) findViewById(R.id.tvMostrarDescripcion);

        btneditar=(Button) findViewById(R.id.btnEditar);

        recibir=getIntent().getExtras();

        recibirNombre=recibir.getString(getResources().getString(R.string.parametro_nombre));
        recibirFecha=recibir.getString(getResources().getString(R.string.parametro_fecha));
        recibirTelefono=recibir.getString(getResources().getString(R.string.parametro_telefono));
        recibirEMail=recibir.getString(getResources().getString(R.string.parametro_e_mail));
        recibirDescripcion=recibir.getString(getResources().getString(R.string.parametro_descripcion));

        tvMostrarNombre.setText(recibirNombre);
        tvMostrarFecha.setText(recibirFecha);
        tvMostrarTelefono.setText(recibirTelefono);
        tvMostrarEMail.setText(recibirEMail);
        tvMostrarDescripcion.setText(recibirDescripcion);
    }


    public void editar(View view)
    {
        Intent intent=new Intent(DatosActivity.this,MainActivity.class);

        intent.putExtra(getResources().getString(R.string.editar_nombre),recibirNombre);
        intent.putExtra(getResources().getString(R.string.editar_fecha),recibirFecha);
        intent.putExtra(getResources().getString(R.string.editar_telefono),recibirTelefono);
        intent.putExtra(getResources().getString(R.string.editar_e_mail),recibirEMail);
        intent.putExtra(getResources().getString(R.string.editar_descripcion),recibirDescripcion);

        finish();

        startActivity(intent);
    }
}
