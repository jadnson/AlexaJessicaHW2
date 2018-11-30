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

public class InventoryCheck extends Activity implements View.OnClickListener {

    Button buttonHome;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_check);

        buttonHome = (Button) findViewById(R.id.buttonHome);

        buttonHome.setOnClickListener(this);
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
                Intent intentHome = new Intent (this, HomeScreen.class);
                startActivity(intentHome);
                return true;
            case R.id.menuItemCheckInv:
                Toast.makeText(InventoryCheck.this, "You're on the Check Inventory page",Toast.LENGTH_SHORT).show();
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
        if(v == buttonHome) {
            Intent intentHome = new Intent(this, HomeScreen.class);
            startActivity(intentHome);
        }
    }
}
