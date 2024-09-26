package com.example.myfirstappajbm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //Recojo los elementos del xml del ThirdActivity
        Button btonBack = findViewById(R.id.buttonBack);
        TextView tvString = findViewById(R.id.tvString);
        TextView tvInt = findViewById(R.id.tvInt);
        TextView tvIntDec = findViewById(R.id.tvIntDec);
        TextView tvBoolean = findViewById(R.id.tvBoolean);


        btonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(ThirdActivity.this, MainActivity.class);
                startActivity(intentBack);
            }
        });

        //Creo un Intent para volver al primer Activity
        Intent intentSecondAct = getIntent();

        //Recojo los elementos ya enviados y los asigno a variables
        String String = intentSecondAct.getStringExtra("text");
        int Int = intentSecondAct.getIntExtra("numInt", 0);
        double Dec = intentSecondAct.getDoubleExtra("numDec", 0.0);
        Boolean Bool = intentSecondAct.getBooleanExtra("sBoolean", false);

        //Muestro los datos recogidos
        tvString.setText(String);
        tvInt.setText(String.valueOf(Int));
        tvIntDec.setText(String.valueOf(Dec));
        tvBoolean.setText(String.valueOf(Bool));
    }
}