package com.example.mobileComputing.recovideo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by simon on 5/28/17.
 */

public class QuestionListAdapter extends ArrayAdapter<String[]> {

    private Context context;

    public QuestionListAdapter(Context context, String[][] values) {
        super(context, R.layout.question_list_item, values);
        this.context = context;
    }

    public void notifyStuff() {
        this.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(getContext());
        View view = myInflater.inflate(R.layout.question_list_item, parent, false);

        String[] item = getItem(position);
        String name = item[0];
        String age = item[1];

        TextView questionTextView = (TextView) view.findViewById(R.id.questionText);
        //ImageView recordIcon = (ImageView) view.findViewById(R.id.recordIcon);

        questionTextView.setText(name);

        return view;
    }


}
