package com.ecosd.project.carbonfootprint;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;

import Models.AlternativeModel;

/**
 * Created by this pc on 12-04-17.
 */

public class Alternatives extends AppCompatActivity{

    Toolbar toolbar;
    private static CustomAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    ArrayList<AlternativeModel> alternativeModels;
    int[] images={R.drawable.walking,R.drawable.beef,R.drawable.electric_car,R.drawable.energy_star,R.drawable.led,R.drawable.organic_food,R.drawable.recycle,R.drawable.saving_water,R.drawable.clean_energy,R.drawable.solar_power};
    FloatingActionButton fab;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alternative_list);
        toolbar=(Toolbar)findViewById(R.id.toolbar3);
        toolbar.setTitle("Alternatives");
        toolbar.setTitleTextColor(Color.WHITE);


        recyclerView = (RecyclerView) findViewById(R.id.alternative_grid);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        alternativeModels=new ArrayList<>();

        alternativeModels.add(new AlternativeModel(images[0],"Alternatives to driving","When possible, walk or ride your bike in order to avoid carbon emissions completely. Carpooling and public transportation drastically reduce CO2 emissions by spreading them out over many riders."));
        alternativeModels.add(new AlternativeModel(images[2],"Drive a low carbon vehicle","High mileage doesn’t always mean low CO2 emissions. All vehicles have an estimated miles-per-gallon rating. Electric cars emit no CO2 if they’re charged with clean electricity. If you don’t charge it with your home’s solar panels AND live somewhere like WY, MO, MO, WV, or KY you’re BETTER OFF with a hybrid or high-mileage gas/diesel car. Here’s why. After incentives and gas savings, it essentially costs nothing to switch to an electric car like the the Nissan Leaf."));
        alternativeModels.add(new AlternativeModel(images[3],"Appliances","When possible, walk or ride your bike in order to avoid carbon emissions completely. Carpooling and public transportation drastically reduce CO2 emissions by spreading them out over many riders."));
        alternativeModels.add(new AlternativeModel(images[4],"Lighting","When possible, walk or ride your bike in order to avoid carbon emissions completely. Carpooling and public transportation drastically reduce CO2 emissions by spreading them out over many riders."));
        alternativeModels.add(new AlternativeModel(images[9],"Solar","When possible, walk or ride your bike in order to avoid carbon emissions completely. Carpooling and public transportation drastically reduce CO2 emissions by spreading them out over many riders."));
        alternativeModels.add(new AlternativeModel(images[5],"Eat locally-produced and organic food","When possible, walk or ride your bike in order to avoid carbon emissions completely. Carpooling and public transportation drastically reduce CO2 emissions by spreading them out over many riders."));
        alternativeModels.add(new AlternativeModel(images[1],"Cut the beef and dairy","When possible, walk or ride your bike in order to avoid carbon emissions completely. Carpooling and public transportation drastically reduce CO2 emissions by spreading them out over many riders."));
        alternativeModels.add(new AlternativeModel(images[7],"Water usage","When possible, walk or ride your bike in order to avoid carbon emissions completely. Carpooling and public transportation drastically reduce CO2 emissions by spreading them out over many riders."));
        alternativeModels.add(new AlternativeModel(images[6],"Reuse and recycle","When possible, walk or ride your bike in order to avoid carbon emissions completely. Carpooling and public transportation drastically reduce CO2 emissions by spreading them out over many riders."));
        alternativeModels.add(new AlternativeModel(images[8],"Support clean energy sources","When possible, walk or ride your bike in order to avoid carbon emissions completely. Carpooling and public transportation drastically reduce CO2 emissions by spreading them out over many riders."));

        Log.e("Arraylist",alternativeModels.toString());

        adapter=new CustomAdapter(getApplicationContext(), alternativeModels, new CustomAdapter.VenueAdapterClickCallbacks() {
            @Override
            public void onShareClick(String a) {

            }
        });


        Log.e("Arraylist",adapter.toString());
        recyclerView.setAdapter(adapter);



    }
}
