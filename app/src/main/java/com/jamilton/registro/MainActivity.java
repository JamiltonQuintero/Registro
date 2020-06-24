package com.jamilton.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bfecha;
    private TextView efecha;
    private TextInputEditText iNombre, iTel, iEmail, iDescripcion;

    private int dia,mes,ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bfecha = findViewById(R.id.bFecha);
        efecha = findViewById(R.id.eFecha);
        bfecha.setOnClickListener(this);

        iNombre = findViewById(R.id.nombre);
        iTel = findViewById(R.id.telefono);
        iEmail = findViewById(R.id.email);
        iDescripcion = findViewById(R.id.descripcion);

        //Aqui recibimos los valores para editar

        String eNombre = getIntent().getStringExtra("eNombre");
        iNombre.setText(eNombre);

        String eFecha = getIntent().getStringExtra("eFecha");
        efecha.setText(eFecha);

        String eTel = getIntent().getStringExtra("eTel");
        iTel.setText(eTel);

        String eEmail = getIntent().getStringExtra("eEmail");
        iEmail.setText(eEmail);

        String eDescri = getIntent().getStringExtra("eDescri");
        iDescripcion.setText(eDescri);


    }

    //Metodo para seleccionar nacimiento en el calendario
    @Override
    public void onClick(View v) {
        if (v==bfecha){
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);


            DatePickerDialog datePickerDialog = new  DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                   efecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }
            ,dia,mes,ano);
            datePickerDialog.show();


        }


    }
    public void Siguiente(View view ){
        Intent siguiente = new Intent(MainActivity.this, Main2Activity.class);
        siguiente.putExtra("rNombre", iNombre.getText().toString());
        siguiente.putExtra("rFecha", efecha.getText().toString());
        siguiente.putExtra("rTel", iTel.getText().toString());
        siguiente.putExtra("rEmail", iEmail.getText().toString());
        siguiente.putExtra("rDescri", iDescripcion.getText().toString());
        startActivity(siguiente);
    }

}
