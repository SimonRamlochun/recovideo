package com.example.mobileComputing.recovideo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;



/**
 * Created by simon on 5/28/17.
 */

public class QuestionListActivity extends AppCompatActivity {
    static final int REQUEST_VIDEO_CAPTURE = 1;
    private ListView questionListView;
    //ArrayList<String[]> questionsToDisplay = new ArrayList<String[]>();
    private QuestionListAdapter questionListAdapter;
    private Button assembleButton;

    private int lastQuestionRecorded = -1;

    String[][] questionsToDisplay = new String[][]
    {
        {"What are John's strengths?", "content://media/external/video/media/4463"},
        {"How do you know John?", "content://media/external/video/media/4464"},
        {"Does John always show up on time?", "content://media/external/video/media/4465"},
        {"Is John sociable?", "content://media/external/video/media/4466"},
        {"How creative is John?", "content://media/external/video/media/4467"},
        {"What flavor of ice cream does John prefer?", "content://media/external/video/media/4468"},
        {"How many children does John have?", "content://media/external/video/media/4469"},
        {"Is John's wife good looking?", "content://media/external/video/media/4470"},
        {"Does John like giraffes?", "content://media/external/video/media/4471"},
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);

        questionListView = (ListView) findViewById(R.id.questionList);
        assembleButton = (Button) findViewById(R.id.assembleButton);

        questionListAdapter = new QuestionListAdapter(this, questionsToDisplay);
        questionListView.setAdapter(questionListAdapter);


        questionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lastQuestionRecorded = position;
                dispatchTakeVideoIntent();
                //Intent intent = new Intent(QuestionListActivity.this, RecordStuff.class);
                //startActivity(intent);
            }
        });

        assembleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(QuestionListActivity.this, VideoViewer.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("uris", questionsToDisplay);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void onAssembleButtonPress() {
        //Intent intent = new Intent(QuestionListActivity.this, VideoViewer.class);
        //startActivity(intent);

        //Intent intent = new Intent(QuestionListActivity.this, VideoViewer.class);

        /**/
        //startActivity(intent);
    }

    private void dispatchTakeVideoIntent() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = intent.getData();
            saveVideoUri(videoUri);
        }

    }

    private void saveVideoUri(Uri videoUri) {
        //questionsToDisplay[lastQuestionRecorded][0] = ""+videoUri;
        questionsToDisplay[lastQuestionRecorded][1] = ""+videoUri;
        questionListAdapter.notifyDataSetChanged();
        lastQuestionRecorded = -1;
    }
}
