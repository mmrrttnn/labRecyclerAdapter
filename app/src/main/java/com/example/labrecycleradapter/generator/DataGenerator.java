package com.example.labrecycleradapter.generator;

import com.example.labrecycleradapter.models.Fruit;
import com.example.labrecycleradapter.models.Vegetable;

import java.util.ArrayList;
import java.util.Random;

public class DataGenerator {
    public static ArrayList<Vegetable> generateList(int number){
        ArrayList<Vegetable> production = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= number; i++){
            //Vegetable
            production.add(new Vegetable("Vegetable" + i,
                    10L+random.nextDouble() % 99L,
                    4L+random.nextDouble()%99L));

            //Fruit
            production.add(new Fruit(
                    "Fruit" + i,
                    4L+random.nextDouble()%99L,
                    4L+random.nextDouble()%99L,
                    random.nextInt(10)));
        }
        return production;
    }
}
