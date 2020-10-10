package com.asdeveloper.semana2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etFecha;
    EditText etNombre;
    EditText etTelefono;
    EditText etEmail;
    EditText etDescripcion;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText) findViewById(R.id.eTNombre);
        etFecha = (EditText) findViewById(R.id.etFecha);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);

        etFecha = (EditText) findViewById(R.id.etFecha);
        etFecha.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.etFecha:
                        showDatePickerDialog();
                        break;
                }
            }
        });

            Bundle parametros = getIntent().getExtras();
        if(parametros != null) {
            Toast.makeText(this,"HAY",0);
            etNombre.setText(parametros.getString("NOMBRE"));
            etFecha.setText(parametros.getString("FECHA"));
            etTelefono.setText(parametros.getString("TELEFONO"));
            etEmail.setText(parametros.getString("EMAIL"));
            etDescripcion.setText(parametros.getString("DESCRIPCION"));
        }
        else {
            Toast.makeText(this,"no hay parametros",0);
        }
        Button btnSiguiente = (Button) findViewById(R.id.buttonSiguiente);

        btnSiguiente.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                    // Crear Objeto Bundle
                    Bundle bunParam = new Bundle();
                    bunParam.putString("NOMBRE", etNombre.getText().toString());
                    bunParam.putString("TELEFONO",etTelefono.getText().toString());
                    bunParam.putString("EMAIL",etEmail.getText().toString());
                    bunParam.putString("FECHA",etFecha.getText().toString());
                    bunParam.putString("DESCRIPCION",etDescripcion.getText().toString());
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    intent.putExtras(bunParam);
                    startActivity(intent);
                    finish();
                }
        });
    }

    private void showDatePickerDialog(){
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                etFecha.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");    }
}
