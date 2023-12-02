package com.example.labrecycleradapter.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labrecycleradapter.R;
import com.example.labrecycleradapter.activities.ItemData;
import com.example.labrecycleradapter.holders.RecyclerHolder;
import com.example.labrecycleradapter.models.Fruit;
import com.example.labrecycleradapter.models.Vegetable;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder> {
    private List<Vegetable> shopData;
    private Context context;
    //da dovurshim 2te aktivitita

    public RecyclerAdapter(List<Vegetable> shopData) {
        this.shopData = shopData;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext(); //взема контекста, където се намира RecyclerView(view)
        LayoutInflater inflater = LayoutInflater.from(context);
        View shopView = inflater.inflate(R.layout.recycler_line_item_layout, parent, false); //създава View от персонализиран изглед(layout)
        RecyclerHolder holder = new RecyclerHolder(shopView); //създава holder чрез view
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        Vegetable item = shopData.get(position); //взима текущия елемент от колекцията

        //поставя стойности в съответните TextView
        holder.setName(item.getName());
        holder.setQty(item.getQty());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(item instanceof Fruit){
                    Fruit fruit = (Fruit) item;
                    Intent intent = new Intent(context, ItemData.class);
                    intent.putExtra("fruit", fruit);
                    ((Activity)context).startActivity(intent);
                } else {
                    Vegetable vegetable = (Vegetable) item;
                    Intent intent = new Intent(context, ItemData.class);
                    intent.putExtra("vege", vegetable);
                    ((Activity)context).startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopData.size();
    }
}
