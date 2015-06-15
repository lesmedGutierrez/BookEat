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

                ConexionDB conn = new ConexionDB();
                UserAccount ua = conn.loginUser("lesmed@gmail.com", "");

                if (ua.UserAccountID != -1){

                    Intent i = new Intent(getApplicationContext(),BookingActivity.class);

                    i.putExtra("firstname",ua.FirstName );
                    i.putExtra("lastname",ua.Lastname );
                    i.putExtra("email",ua.Email );
                    i.putExtra("password",ua.Password );
                    i.putExtra("id",ua.UserAccountID );



                    startActivity(i);
                }




            }
        });
    }
}
