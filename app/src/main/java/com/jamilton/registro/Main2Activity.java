package com.jamilton.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView mNombre, mFNacimiento, mTel, mEmail, mDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mNombre = findViewById(R.id.reciNombre);
        mFNacimiento = findViewById(R.id.reciFecha);
        mTel = findViewById(R.id.reciTel);
        mEmail = findViewById(R.id.reciMail);
        mDescripcion = findViewById(R.id.reciDescri);

        //Aqui recibimos los datos
        String rNombre = getIntent().getStringExtra("rNombre");
        mNombre.setText(rNombre);

        String rFecha = getIntent().getStringExtra("rFecha");
        mFNacimiento.setText("Fecha de Nacimiento: " + rFecha);

        String rTel = getIntent().getStringExtra("rTel");
        mTel.setText("Telefono: " + rTel);

        String rEmail = getIntent().getStringExtra("rEmail");
        mEmail.setText("Email: " + rEmail);

        String rDescri = getIntent().getStringExtra("rDescri");
        mDescripcion.setText("Descripcion: " + rDescri);



    }

    public void Editar(View view){
        Intent editar = new Intent(Main2Activity.this, MainActivity.class);
        editar.putExtra("eNombre", mNombre.getText().toString());
        editar.putExtra("eFecha", mFNacimiento.getText().toString());
        editar.putExtra("eTel", mTel.getText().toString());
        editar.putExtra("eEmail", mEmail.getText().toString());
        editar.putExtra("eDescri", mDescripcion.getText().toString());
        startActivity(editar);

    }


}
