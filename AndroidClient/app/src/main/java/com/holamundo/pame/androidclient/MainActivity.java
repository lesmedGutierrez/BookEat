package com.holamundo.pame.androidclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Lesmed® on 14/06/2015.
 */
public class MainActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Button bLogin = (Button)findViewById(R.id.btnLogin);
        Button bRegistrarse = (Button)findViewById(R.id.btnRegistrarse);




        bLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);

            }
        });
        bRegistrarse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MyActivity.class);
                startActivity(i);

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
