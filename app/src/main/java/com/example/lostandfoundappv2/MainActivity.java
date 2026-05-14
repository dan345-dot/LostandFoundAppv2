package com.example.lostandfoundappv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
ListView listView;
String[] options = {"Open ShowAllLostAndFoundItems"};

public void jumpClick (View view)
{
    Intent intent = new Intent(this, CreateANewAdvert.class);
    startActivity(intent);
}
public void showClick(View view)
{
    Intent intent = new Intent(this, ShowAllLostAndFoundItems.class);
    startActivity(intent);
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.ItemListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                options
        );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(((parent, view, position, id) -> {
            if (position == 0){
                Intent intent = new Intent(MainActivity.this, ShowAllLostAndFoundItems.class);
                startActivity(intent);
                } else if (position == 1) {
                Intent intent = new Intent(MainActivity.this, RemoveItem.class);
                startActivity(intent);
            }
        }));
    }
}