package edu.galileo.ejemplo2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    /*** #1 Definir las variables del tipo de las Vistas que van a usar*/
    private EditText nombre;
    private Button saludar, saludarPersonalizado;
    private RadioGroup rgColores;
    private LinearLayout llBase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /** #2 Invoque al metodo setContentView con la layout adecuada*/
        setContentView(R.layout.main_layout);
        /** #3 Inicializacion de  las variables con las vistas de la layout */
        nombre = findViewById(R.id.et_nombre);
        saludar = findViewById(R.id.btn_saludo);
        saludarPersonalizado = findViewById(R.id.btn_saludo_personalizado);
        rgColores = findViewById(R.id.rg_color_fondo);
        llBase = findViewById(R.id.ll_base);
        /*
        saludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Hola A todos", 2000).show();
            }
        });
        */
        /* #4 Definir Listener */
        saludar.setOnClickListener(this);
        saludarPersonalizado.setOnClickListener(this);
        rgColores.setOnCheckedChangeListener(this);
        /* #5 Cargar datos iniciales */
        nombre.setTextColor(Color.rgb(0,0,254));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_saludo :
                Toast.makeText(this, "Hola a Todos", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_saludo_personalizado :
                Toast.makeText(this, "Hola " + nombre.getText().toString(), Toast.LENGTH_LONG).show();
                nombre.setText("");
                break;
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //Toast.makeText(this,"Color seeccionado " + ((RadioButton) rgColores.getChildAt(checkedId -1 )).getText(), Toast.LENGTH_LONG).show();
        switch (checkedId) {
            case 1 :
                llBase.setBackgroundColor(Color.rgb(0,254,0));
                break;
            case 2:
                llBase.setBackgroundColor(Color.rgb(110,87,245));
                break;
        }

    }
}
