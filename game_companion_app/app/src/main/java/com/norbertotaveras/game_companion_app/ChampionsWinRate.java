package com.norbertotaveras.game_companion_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Emanuel on 12/7/2017.
 */

public class ChampionsWinRate extends Fragment {

    private static final String TAG = "ChampionsWinRate";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView: started");

        initImageBitmaps();

        View rootView = inflater.inflate(R.layout.fragment_championswinrate, container, false);
        return rootView;



    }
    
    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        mImageUrls.add("http://opgg-static.akamaized.net/images/lol/champion/Tryndamere.png?image=w_140&v=1");
        mNames.add("Tryndamere");

        mImageUrls.add("http://apollo-na-uploads.s3.amazonaws.com/1420537412050/ashe-league-of-legends-30090-1920x1080.jpg");
        mNames.add("Ashe");

        mImageUrls.add("http://www.behindthevoiceactors.com/_img/chars/jax-league-of-legends-4.27.jpg");
        mNames.add("Jax");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: initialized RecyclerView");
        RecyclerView recyclerView = findViewById(R.id.winrecyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

