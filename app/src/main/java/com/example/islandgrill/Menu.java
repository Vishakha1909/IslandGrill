package com.example.islandgrill;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;

public class Menu extends AppCompatActivity
{
    Button signout,pro,checkcart;
    private static final String TAG = "Menu";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private ArrayList<String> mDescription = new ArrayList<>();
    private ArrayList<String> mPrices = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getInfo();
        
    }
    private void getInfo(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add(R.drawable.salmon);
        mNames.add("Salmon and Zucchini Special");
        mDescription.add("ihbdifwhnrkjn");
        mPrices.add("Rs 130");
        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.menu1);
        recyclerView.setLayoutManager(layoutManager);
        PopularViewAdapter adapter = new PopularViewAdapter(this, mNames, mImageUrls,mDescription,mPrices);
        recyclerView.setAdapter(adapter);
    }
}