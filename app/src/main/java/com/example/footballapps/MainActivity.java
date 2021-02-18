package com.example.footballapps;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> club = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    EditText etSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        etSearch = findViewById(R.id.etSearch);
        club.add("Arsenal");
        club.add("Aston Villa");
        club.add("Brighton");
        club.add("Burnley");
        club.add("Chelsea");
        club.add("Crystal Palace");
        club.add("Everton");
        club.add("Fulham ");
        club.add("Leeds United");
        club.add("Leicester");
        club.add("Liverpool");
        club.add("Manchester United");
        club.add("Newcastle");
        club.add("Sheffield Utd");
        club.add("Southampton");
        club.add("Tottenham");
        club.add("West Brom");
        club.add("West Ham");
        club.add("Wolverhampton");

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