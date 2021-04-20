package com.example.myapplicationiipertemuan9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.*;
import android.os.Bundle;
import android.view.View;

import java.util.*;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewHero;
    private List<Hero> models = new ArrayList<>();
    private HeroRecyclerAdapter.RecyclerViewClickListener listener;
    @Override
    protected void onStart(){
        super.onStart();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewHero = findViewById(R.id.rv_hero);
        recyclerViewHero.setHasFixedSize(true);

        models.addAll(HeroDatabase.getListData());
        ClickOnMe();
        recyclerViewHero.setLayoutManager(new LinearLayoutManager(this));
        HeroRecyclerAdapter adapter = new HeroRecyclerAdapter(models, listener);
        recyclerViewHero.setAdapter(adapter);
    }
    public void ClickOnMe(){
        listener = new HeroRecyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("index", position);
                startActivity(intent);

            }
        };
    }
}