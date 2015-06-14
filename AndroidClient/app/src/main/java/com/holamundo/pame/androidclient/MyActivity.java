package com.holamundo.pame.androidclient;


import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MyActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Button bRegistrar = (Button)findViewById(R.id.btnRegistrar);


       //Button bProducir =(Button)findViewById(R.id.bSend);

       //Button bConsumir =(Button) findViewById(R.id.bReceiving);


        final TextView nombre = (TextView) findViewById(R.id.txtNombre);//Se define el campo del texto
        final TextView apellido = (TextView) findViewById(R.id.txtApellido);//Se define el campo del texto
        final TextView email = (TextView) findViewById(R.id.txtEmail);//Se define el campo del texto
        final TextView contraseña = (TextView) findViewById(R.id.txtContrasena);//Se define el campo del texto
        final TextView repetirContraseña = (TextView) findViewById(R.id.txtRepetirContraseña);//Se define el campo del texto


        //new connectTask().execute("");

        bRegistrar.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String nombreS = nombre.getText().toString();
                String apellidoS = apellido.getText().toString();
                String emailS = email.getText().toString();
                String contraseñaS = contraseña.getText().toString();
                String repContraseñaS = repetirContraseña.getText().toString();


            }
        });
/*
        bProducir.setOnClickListener(new OnClickListener() {
            int workedId = 1;

            public void onClick(View v) {

                Consumir consumir = new Consumir(workedId);
                consumir.start();
                workedId++;
            }
        });
*/

    }
}

 


