package com.example.myapplicationiipertemuan9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    ImageView ImagePhoto;
    private  Hero models = new Hero();
    TextView Details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Details = findViewById(R.id.Details);
        ImagePhoto = findViewById(R.id.Myimage);
        Bundle extra = getIntent().getExtras();
        if (extra != null){
            int index = extra.getInt("index");
            models = HeroDatabase.getData(index);
            Details.setText(models.getSummary());
            ImagePhoto.setImageResource(models.getPhoto());
        }


    }
}