package com.example.mobileComputing.recovideo;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by simon on 5/27/17.
 */



public class MyRecommendationsFragment extends Fragment {

    private ListView videoListView;
    ArrayList<String[]> videosToDisplay = new ArrayList<String[]>();
    private int tabIdentity;
    private ListAdapter myRecommendationsAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_recommendations, container, false);

        videosToDisplay.add(new String[]{"Simon Eriksen", "87", "Student", "1"});
        videosToDisplay.add(new String[]{"Mads Hansen", "12", "Consultant", "1"});
        videosToDisplay.add(new String[]{"Mark Jay Nielsen", "20", "Designer", "1"});
        videosToDisplay.add(new String[]{"Emil Armenian", "11", "Consultant", "1"});
        videosToDisplay.add(new String[]{"Yunus Lastname", "23", "CEO", "1"});
        videosToDisplay.add(new String[]{"Claude Monet", "87", "Painter", "1"});

        videoListView = (ListView) view.findViewById(R.id.recommendationList);

        myRecommendationsAdapter = new MyRecommendationsAdapter(getActivity(), videosToDisplay);
        videoListView.setAdapter(myRecommendationsAdapter);


        videoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //...
            }
        });

        return view;
    }
}
