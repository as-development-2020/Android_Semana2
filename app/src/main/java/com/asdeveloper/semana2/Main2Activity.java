package com.asdeveloper.semana2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView tvEdiNombre;
    private TextView tvEdiFecha;
    private TextView tvEdiTelefono;
    private TextView tvEdiEmail;
    private TextView tvEdiDescripcion;
    String stNombre,stTelefono,stEmail,stFecha,stDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle parametros = getIntent().getExtras();
        String pnombre  = parametros.getString("NOMBRE");
        String pfecha   = parametros.getString("FECHA");
        String ptelefono= parametros.getString("TELEFONO");
        String pemail   = parametros.getString("EMAIL");
        String pdescripcion   = parametros.getString("DESCRIPCION");
        tvEdiNombre       = (TextView) findViewById(R.id.tvNombreCompleto);
        tvEdiFecha        = (TextView) findViewById(R.id.tvFecha);
        tvEdiTelefono     = (TextView) findViewById(R.id.tvTelefono);
        tvEdiEmail        = (TextView) findViewById(R.id.tvEmail);
        tvEdiDescripcion  = (TextView) findViewById(R.id.tvDescripcion);
        tvEdiNombre.setText(pnombre);
        tvEdiFecha.setText(pfecha);
        tvEdiTelefono.setText(ptelefono);
        tvEdiEmail.setText(pemail);
        tvEdiDescripcion.setText(pdescripcion);
        //
        Button send = (Button) findViewById(R.id.buttonEditar);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarDatos();
            }
        });
    }
    public void editarDatos() {
        Bundle bunParam = new Bundle();
        bunParam.putString("NOMBRE", tvEdiNombre.getText().toString());
        bunParam.putString("EMAIL", tvEdiEmail.getText().toString());
        bunParam.putString("TELEFONO", tvEdiTelefono.getText().toString());
        bunParam.putString("FECHA", tvEdiFecha.getText().toString());
        bunParam.putString("DESCRIPCION", tvEdiDescripcion.getText().toString());
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        intent.putExtras(bunParam);
        startActivity(intent);
        finish();
    }
}
