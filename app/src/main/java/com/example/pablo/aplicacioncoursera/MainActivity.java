package com.example.pablo.aplicacioncoursera;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private TextInputEditText tietNombre;
    private TextInputEditText tietFecha;
    private TextInputEditText tietTelefono;
    private TextInputEditText tietEMail;
    private TextInputEditText tietDescripcion;

    private Button irACalendario;
    private Button siguiente;

    private Intent activityDos;
    private Bundle reEdicion;

    private DatePickerDialog datePickerDialog;

    private String datoNombre;
    private String datoFecha;
    private String datoTelefono;
    private String datoEMail;
    private String datoDescripcion;

    private int dia;
    private int mes;
    private int anio;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tietNombre=(TextInputEditText) findViewById(R.id.tietNombre);
        tietFecha=(TextInputEditText) findViewById(R.id.tietFecha);
        tietTelefono=(TextInputEditText) findViewById(R.id.tietTelefono);
        tietEMail=(TextInputEditText) findViewById(R.id.tietEMail);
        tietDescripcion=(TextInputEditText) findViewById(R.id.tietDescripcion);

        irACalendario=(Button) findViewById(R.id.btnFecha);
        siguiente=(Button) findViewById(R.id.btnSiguiente);

        reEdicion=getIntent().getExtras();

        if(reEdicion!=null)
        {
            tietNombre.setText(reEdicion.getString(getResources().getText(R.string.editar_nombre).toString()));
            tietFecha.setText(reEdicion.getString(getResources().getText(R.string.editar_fecha).toString()));
            tietTelefono.setText(reEdicion.getString(getResources().getText(R.string.editar_telefono).toString()));
            tietEMail.setText(reEdicion.getString(getResources().getText(R.string.editar_e_mail).toString()));;
            tietDescripcion.setText(reEdicion.getString(getResources().getText(R.string.editar_descripcion).toString()));;
        }

        irACalendario.setOnClickListener(this);

        siguiente.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        if(v==irACalendario)
        {
            final Calendar calendar=Calendar.getInstance();
            dia=calendar.get(Calendar.DAY_OF_MONTH);
            mes=calendar.get(Calendar.MONTH);
            anio=calendar.get(Calendar.YEAR);

            datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener()
            {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
                {
                    tietFecha.setText(dayOfMonth+"/"+month+"/"+year);
                }
            },dia,mes,anio);

            datePickerDialog.show();
        }
        else if(v==siguiente)
        {
            activityDos= new Intent(MainActivity.this,DatosActivity.class);

            datoNombre= tietNombre.getText().toString();
            datoFecha= tietFecha.getText().toString();
            datoTelefono= tietTelefono.getText().toString();
            datoEMail= tietEMail.getText().toString();
            datoDescripcion= tietDescripcion.getText().toString();

            activityDos.putExtra(getResources().getString(R.string.parametro_nombre),datoNombre);
            activityDos.putExtra(getResources().getString(R.string.parametro_fecha),datoFecha);
            activityDos.putExtra(getResources().getString(R.string.parametro_telefono),datoTelefono);
            activityDos.putExtra(getResources().getString(R.string.parametro_e_mail),datoEMail);
            activityDos.putExtra(getResources().getString(R.string.parametro_descripcion),datoDescripcion);

            finish();
            startActivity(activityDos);
        }
        else
        {
            String error=getResources().getString(R.string.accion_desconocida);
            Snackbar.make(v,error,Snackbar.LENGTH_SHORT);
        }
    }
}
