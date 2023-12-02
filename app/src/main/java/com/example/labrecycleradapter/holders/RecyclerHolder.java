package com.example.labrecycleradapter.holders;

//first create line layout

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labrecycleradapter.R;

import org.w3c.dom.Text;

public class RecyclerHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView qty;

    public RecyclerHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.recyclerName);
        qty = itemView.findViewById(R.id.recyclerQty);
    }

    public TextView getName() {
        return name;
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public TextView getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty.setText(Double.toString(qty));
    }
}
