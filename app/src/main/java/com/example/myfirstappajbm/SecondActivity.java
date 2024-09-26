package com.example.myfirstappajbm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Recojo los elementos del xml del SecondActivity
        EditText etText = findViewById(R.id.etText);
        EditText etNumInt = findViewById(R.id.etNumInt);
        EditText etNumDec = findViewById(R.id.etNumDec);
        Switch sBoolean = findViewById(R.id.sBoolean);
        Button buttonSend = findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creo un Intent para saltar a la siguiente Activity
                Intent intentSend = new Intent(SecondActivity.this, ThirdActivity.class);

                //Recojo los datos rellenados
                intentSend.putExtra("text", etText.getText().toString());
                intentSend.putExtra("numInt", Integer.parseInt(etNumInt.getText().toString()));
                intentSend.putExtra("numDec", Double.parseDouble(etNumDec.getText().toString()));
                intentSend.putExtra("sBoolean", sBoolean.isChecked());

                startActivity(intentSend);
            }
        });


    }
}