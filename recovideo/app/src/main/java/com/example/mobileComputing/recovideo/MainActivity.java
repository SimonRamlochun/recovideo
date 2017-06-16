package com.example.mobileComputing.recovideo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //TextView textView = (TextView) findViewById(R.id.cola);
    //textView.setText("cola med softice og pølser");

    final Button button = (Button) findViewById(R.id.linkedIn);
    button.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, RecommendationTabs.class);
        startActivity(intent);
      }
    });

    final Button videoViewButton = (Button) findViewById(R.id.videoViewer);
    videoViewButton.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, VideoViewer.class);
        startActivity(intent);
      }
    });



  }
}
