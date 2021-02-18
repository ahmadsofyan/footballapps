package com.example.footballapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class klub extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.klublist);
        CardView pl = (CardView) findViewById(R.id.pl);
        pl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(klub.this,MainActivity.class);
                startActivity(intent);
            }
        });
        CardView ll = (CardView) findViewById(R.id.ll);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(klub.this,spain.class);
                startActivity(intent);
            }
        });
    }
}
