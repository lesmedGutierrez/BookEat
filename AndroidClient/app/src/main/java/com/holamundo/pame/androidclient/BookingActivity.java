package com.holamundo.pame.androidclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

/**
 * Created by Lesmed® on 15/06/2015.
 */
public class BookingActivity extends Activity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_acitvity);

        ListView  listView_reservaciones = (ListView)findViewById(R.id.listView_Reservaciones);

        Intent i = getIntent();

        String FirstName = i.getStringExtra("firstname");
        String LastName = i.getStringExtra("lastname");
        String Email = i.getStringExtra("email");
        String password= i.getStringExtra("password");
        String id = i.getStringExtra("id");


        String[] items = new String[] {FirstName, LastName, Email, password,id};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items);
        listView_reservaciones.setAdapter(adapter);


    }

}
