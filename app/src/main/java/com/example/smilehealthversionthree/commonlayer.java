package com.example.smilehealthversionthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class commonlayer extends AppCompatActivity {

    Button goall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commonlayer);

        goall = findViewById(R.id.commonAutoGo);

        goall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(commonlayer.this, Allactivity.class);
                startActivity(intent);
            }
        });
    }
}