package com.example.footballapps;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class spain extends AppCompatActivity {
    ListView listView;
    ArrayList<String> club = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    EditText etSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ligaspain);
        listView = findViewById(R.id.listView);
        etSearch = findViewById(R.id.etSearch);
        club.add("Alaves");
        club.add("Athletic Bilbao");
        club.add("Atletico Madrid");
        club.add("Barcelona");
        club.add("Cadiz");
        club.add("Celta Vigo");
        club.add("Eibar");
        club.add("Elche ");
        club.add("Getafe");
        club.add("LGranada");
        club.add("Huesca");
        club.add("Levante");
        club.add("Osasuna");
        club.add("Real Betis");
        club.add("Real Madrid");
        club.add("Real Sociedad");
        club.add("Sevilla");
        club.add("Valencia");
        club.add("Valladolid");

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, club);
        listView.setAdapter(arrayAdapter);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                arrayAdapter.getFilter().filter(s);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
