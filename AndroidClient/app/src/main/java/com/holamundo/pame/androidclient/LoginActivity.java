package com.holamundo.pame.androidclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Lesmed® on 14/06/2015.
 */
public class LoginActivity extends Activity{

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        Button bLogin = (Button) findViewById(R.id.btnLogin);


        bLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MyActivity.class);
                startActivity(i);

            }
        });
    }
}
