package com.example.a1959freetibet.waterreminder;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;


public class thebeginning extends AppCompatActivity {
    Button notif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thebeginning);

        notif = (Button) findViewById(R.id.notification);
        notif.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), notificationmain.class);
                startActivity(intent);
            }
        });
    }

    public void showAlert(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Congratulations! You completed a cycle!");
        builder.setMessage("Click New Cycle to continue, Click Cancel if it was a mistake.");
        builder.setPositiveButton("New Cycle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int w) {
                Toast.makeText(getApplicationContext(), "See you soon!", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int w) {
                Toast.makeText(getApplicationContext(), "Cycle didn't count!", Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }
}