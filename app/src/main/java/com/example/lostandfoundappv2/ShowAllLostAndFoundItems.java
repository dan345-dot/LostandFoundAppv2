package com.example.lostandfoundappv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ShowAllLostAndFoundItems extends AppCompatActivity {
    SearchView searchView;
    ListView ItemView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    public Button Electronics;
    public Button Pets;
    public Button Wallets;
    public Button Other;

    public void homeClick1 (View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void addItemClick (View view)
    {
     Intent intent = new Intent(this, CreateANewAdvert.class);
     startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_all_lost_and_found_items);
        searchView = findViewById(R.id.SearchView);
        ItemView = findViewById(R.id.ItemView);
        list = new ArrayList<String>();
        list.add("Lost Key");
        list.add("Found Apple AirPods");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        ItemView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextSubmit(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

}