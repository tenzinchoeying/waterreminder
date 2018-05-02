package com.example.a1959freetibet.waterreminder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class water_calc extends AppCompatActivity {
    public int weight = 0;
    public double amount = 0;
    TextView goal;
    EditText value;
    Button proc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water_calc);
        proc = (Button) findViewById(R.id.proceed);
        proc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), thebeginning.class);
                startActivity(intent);
            }
        });

        goal = (TextView) findViewById(R.id.goal);
        value = (EditText) findViewById(R.id.weight);
    }

    public void calc(View v) {
        weight = Integer.parseInt(value.getText().toString());
        amount = weight * 0.5;
        String num = String.format("%.0f",amount);
        goal.setText(num);
    }
}
