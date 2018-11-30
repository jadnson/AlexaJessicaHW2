package com.example.jpier.jessicaalexahw2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeScreen extends Activity implements View.OnClickListener {

    Button buttonAddInv;
    Button buttonCheckInv;
    Button buttonLogOut;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        buttonAddInv = (Button) findViewById(R.id.buttonAddInv);
        buttonCheckInv = (Button) findViewById(R.id.buttonCheckInv);
        buttonLogOut = (Button) findViewById(R.id.buttonLogOut);

        buttonAddInv.setOnClickListener(this);
        buttonCheckInv.setOnClickListener(this);
        buttonLogOut.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v == buttonAddInv){
            Intent intentAddInv = new Intent(this, AddInventory.class);
            startActivity(intentAddInv);
        }

        else if(v==buttonCheckInv){
            Intent intentCheckInv = new Intent (this, InventoryCheck.class);
            startActivity(intentCheckInv);
        }

        else if (v==buttonLogOut){
            mAuth.signOut();
        }
    }
}
