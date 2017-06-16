package com.example.mobileComputing.recovideo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoViewer extends AppCompatActivity {

    private String[][] videoData;
    private int i = 1;

    TextView questionTextView;
    ImageView cancelButton;
    ImageView saveButton;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_viewer);

        final VideoView videoView;
        videoView = (VideoView)findViewById(R.id.videoView1);
        questionTextView = (TextView) findViewById(R.id.questionTextVideo);
        cancelButton = (ImageView) findViewById(R.id.cancelButton);
        saveButton = (ImageView) findViewById(R.id.saveButton);





        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VideoViewer.this, QuestionListActivity.class);
                startActivity(intent);
            }

        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //.... clicking accept does nothing
            }

        });

        String[][] arrayReceived=null;
        Object[] objectArray = (Object[]) getIntent().getExtras().getSerializable("uris");
        if(objectArray!=null){
            arrayReceived = new String[objectArray.length][];
            for(int i=0;i<objectArray.length;i++){
                arrayReceived[i]=(String[]) objectArray[i];
            }
        }

        videoData = arrayReceived;



        //show question text
        questionTextView.setVisibility(View.VISIBLE);
        videoView.setVisibility(View.GONE);
        questionTextView.setText(videoData[0][0]);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                questionTextView.setVisibility(View.GONE);
                videoView.setVisibility(View.VISIBLE);
                videoView.setVideoPath(videoData[0][1]);
                videoView.start();


            }
        }, 3000);

        videoView.setOnCompletionListener(new   MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {

                if(i < videoData.length) {
                //show question text
                questionTextView.setVisibility(View.VISIBLE);
                videoView.setVisibility(View.GONE);
                questionTextView.setText(videoData[i][0]);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        questionTextView.setVisibility(View.GONE);
                        videoView.setVisibility(View.VISIBLE);



                            System.out.println(videoData[i][1]);
                            Uri videoUri = Uri.parse(videoData[i][1]);
                            videoView.setVideoURI(videoUri);

                            videoView.start();
                            i++;

                    }
                }, 3000);
            }


            }
        });

    }
}
