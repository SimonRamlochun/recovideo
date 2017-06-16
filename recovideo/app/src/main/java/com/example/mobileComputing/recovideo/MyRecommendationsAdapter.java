package com.example.mobileComputing.recovideo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by simon on 5/26/17.
 */

public class MyRecommendationsAdapter extends ArrayAdapter<String[]> {

    public MyRecommendationsAdapter(Context context, ArrayList<String[]> values) {
        super(context, R.layout.recommendation_list_item, values);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(getContext());
        View view = myInflater.inflate(R.layout.recommendation_list_item, parent, false);

        String[] item = getItem(position);
        String name = item[0];
        String age = item[1] + " years old";
        String occupation = item[2];

        if(item[3].equals("0")) {
            Switch switchyroo = (Switch) view.findViewById(R.id.recommendationVideoItemHide);
            switchyroo.setVisibility(View.GONE);
        }

        TextView nameTextView = (TextView) view.findViewById(R.id.recommendationVideoItemName);
        TextView ageTextView = (TextView) view.findViewById(R.id.recommendationVideoItemAge);
        TextView occupationTextView = (TextView) view.findViewById(R.id.recommendationVideoItemOccupation);

        nameTextView.setText(name);
        ageTextView.setText(age);
        occupationTextView.setText(occupation);

        return view;
    }
}
