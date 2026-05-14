package com.example.lostandfoundappv2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.net.DatagramPacket;

public class CreateANewAdvert extends AppCompatActivity {

    Button AddImageButton;
    ImageView imageView;

    ActivityResultLauncher<Intent> resultLauncher;
    public void backClick(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void pressClick(View view)
    {
     Intent intent = new Intent(this, ShowAllLostAndFoundItems.class);
     startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_anew_advert);

        AddImageButton = findViewById(R.id.AddImageButton);
        imageView = findViewById(R.id.imageView);
        registerResult();

        AddImageButton.setOnClickListener(view -> addimage());


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    private void addimage(){
        Intent intent = new Intent(MediaStore.ACTION_PICK_IMAGES);
        resultLauncher.launch(intent);
    }

    private void registerResult(){
        resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                      try{
                          Uri imageUri = result.getData().getData();
                          imageView.setImageURI(imageUri);
                      }catch (Exception e){
                          Toast.makeText(CreateANewAdvert.this, "No Image Selected", Toast.LENGTH_SHORT).show();
                      }
                    }
                }
        );
    }
}