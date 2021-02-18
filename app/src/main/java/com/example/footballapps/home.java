package com.example.footballapps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class home extends AppCompatActivity {
    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        int images[] = {R.drawable.hl, R.drawable.hasil};
        v_flipper = findViewById(R.id.v_flipper);
        for (int i = 0; i < images.length; i++) {
            fliverImages(images[i]);
        }
        for (int image : images)
            fliverImages(image);

    }

    public void fliverImages(int images) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(images);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000);
        v_flipper.setAutoStart(true);


        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);


        CardView btn_schedule = (CardView) findViewById(R.id.btn_Schedule);
        btn_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this,jadwal.class);
                startActivity(intent);
            }
        });
        CardView btn_club = (CardView) findViewById(R.id.btn_club);
        btn_club.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this,klub.class);
                startActivity(intent);
            }
        });
        CardView bb = (CardView) findViewById(R.id.bb);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.bola.net/champions/hasil-pertandingan-barcelona-vs-psg-skor-1-4-21e3c3.html"));
                startActivity(intent);
            }
        });
        CardView sevila = (CardView) findViewById(R.id.sevila);
        sevila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://tirto.id/hasil-liga-champion-tadi-malam-sevilla-vs-dortmund-porto-vs-juve-ganu"));
                startActivity(intent);
            }
        });
        CardView juve = (CardView) findViewById(R.id.juve);
        juve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.bola.net/champions/hasil-pertandingan-fc-porto-vs-juventus-skor-2-1-4fefa3.html"));
                startActivity(intent);
            }
        });
        CardView mu = (CardView) findViewById(R.id.mu);
        mu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.bola.com/dunia/read/4485754/jelang-pertemuan-di-liga-europa-adnan-januzaj-ternyata-masih-cinta-manchester-united"));
                startActivity(intent);
            }
        });
    }



}
