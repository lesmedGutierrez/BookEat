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


       Button bProducir =(Button)findViewById(R.id.bSend);

       Button bConsumir =(Button) findViewById(R.id.bReceiving);


        final TextView texto = (TextView) findViewById(R.id.etMessage);//Se define el campo del texto

        //new connectTask().execute("");

        bConsumir.setOnClickListener(new OnClickListener() {
            int producerId = 1;
            int num = 1;

            public void onClick(View v) {
                String textoI = texto.getText().toString();
                num = Integer.parseInt(textoI);

                Producir producer = new Producir(num, producerId);
                producer.start();
                producerId++;

            }
        });

        bProducir.setOnClickListener(new OnClickListener() {
            int workedId = 1;

            public void onClick(View v) {

                Consumir consumir = new Consumir(workedId);
                consumir.start();
                workedId++;
            }
        });


    }
}

 


