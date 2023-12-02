package com.example.labrecycleradapter.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Fruit extends Vegetable {
    private int sweetIndex;

    public Fruit(String name, double price, double qty, int sweetIndex) {
        super(name, price, qty);
        this.sweetIndex = sweetIndex;
    }

    public Fruit(Parcel in) {
        super(in);
        this.sweetIndex = in.readInt();
    }

    public int getSweetIndex() {
        return sweetIndex;
    }

    public void setSweetIndex(int sweetIndex) {
        this.sweetIndex = sweetIndex;
    }

    @Override
    public int describeContents() {
        return super.describeContents();
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(sweetIndex);
    }

    public static final Creator<Fruit> CREATOR = new Creator<Fruit>() {
        @Override
        public Fruit createFromParcel(Parcel in) {
            return new Fruit(in);
        }

        @Override
        public Fruit[] newArray(int size) {
            return new Fruit[size];
        }
    };
}
