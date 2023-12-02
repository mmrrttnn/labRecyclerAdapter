package com.example.labrecycleradapter.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.labrecycleradapter.R;
import com.example.labrecycleradapter.adapters.RecyclerAdapter;
import com.example.labrecycleradapter.generator.DataGenerator;
import com.example.labrecycleradapter.models.Vegetable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    List<Vegetable> shopData;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        FloatingActionButton button = findViewById(R.id.mainA_floating_button);
        button.setOnClickListener(this);

        shopData = DataGenerator.generateList(10);

        adapter = new RecyclerAdapter(shopData);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View view) {
        for (Vegetable v: shopData) {
            v.setQty(new Random().nextDouble()% 99L);
        }
        adapter.notifyDataSetChanged();
    }
}