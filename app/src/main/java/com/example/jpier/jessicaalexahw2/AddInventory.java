package com.example.jpier.jessicaalexahw2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddInventory extends Activity implements View.OnClickListener {

    Button buttonHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inventory);

        buttonHome = (Button) findViewById(R.id.buttonHome);

        buttonHome.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == buttonHome) {
            Intent intentHome = new Intent(this, WelcomeScreen.class);
            startActivity(intentHome);
        }
    }
}