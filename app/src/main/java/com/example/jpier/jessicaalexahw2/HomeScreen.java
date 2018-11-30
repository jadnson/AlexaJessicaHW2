package com.example.jpier.jessicaalexahw2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater optionsMenuInflater = getMenuInflater();
        optionsMenuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuItemHome:
                Toast.makeText(HomeScreen.this, "You're on the Home Page",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuItemCheckInv:
                Intent intentCheckInv = new Intent(this, InventoryCheck.class);
                startActivity(intentCheckInv);
                return true;
            case R.id.menuItemAddInv:
                Intent intentAddInv = new Intent(this, AddInventory.class);
                startActivity(intentAddInv);
                return true;
            case R.id.menuItemLogOut:
                FirebaseAuth.getInstance().signOut();
                Intent intentWelcome = new Intent (this, WelcomeScreen.class);
                startActivity(intentWelcome);
            default:
                return false;
        }
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
            FirebaseAuth.getInstance().signOut();
            Intent intentWelcome = new Intent (this, WelcomeScreen.class);
            startActivity(intentWelcome);


        }
    }
}
