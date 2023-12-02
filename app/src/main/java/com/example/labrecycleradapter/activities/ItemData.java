package com.example.labrecycleradapter.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.labrecycleradapter.R;
import com.example.labrecycleradapter.models.Fruit;
import com.example.labrecycleradapter.models.Vegetable;

public class ItemData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_data);

        TextView itemName = findViewById(R.id.itemName);
        TextView itemQty = findViewById(R.id.itemQty);
        TextView itemPrice = findViewById(R.id.itemPrice);
        TextView itemIndex = findViewById(R.id.itemIndex);

        Intent intent = getIntent();
        Vegetable vegetable = intent.getParcelableExtra("vege", Vegetable.class);
        if(vegetable != null){
            itemName.setText(vegetable.getName());
            itemQty.setText(String.valueOf(vegetable.getQty()));
            itemPrice.setText(String.valueOf(vegetable.getPrice()));
            itemIndex.setVisibility(View.INVISIBLE);
        }
        else {
            Fruit fruit = intent.getParcelableExtra("fruit", Fruit.class);
            if(fruit != null){
                itemName.setText(fruit.getName());
                itemQty.setText(String.valueOf(fruit.getQty()));
                itemPrice.setText(String.valueOf(fruit.getPrice()));
                itemIndex.setText(String.valueOf(fruit.getSweetIndex()));
            }
        }
    }
}