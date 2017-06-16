package com.example.mobileComputing.recovideo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RecommendationTabs extends AppCompatActivity {

  private TabLayout tabLayout;
  private PagerAdapter adapter;
    private FloatingActionButton newVideoButton;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //View view = inflater.inflate(R.layout.activity_recommendation_tabs, container, false);
    setContentView(R.layout.activity_recommendation_tabs);


      newVideoButton = (FloatingActionButton) findViewById(R.id.newRecommendationButton);

      newVideoButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(RecommendationTabs.this, QuestionListActivity.class);
              startActivity(intent);
          }
      });

    setupViewPager();
  }

  public void setupViewPager() {
    tabLayout = (TabLayout) findViewById(R.id.my_events_tab_layout);
    tabLayout.addTab(tabLayout.newTab().setText("My Recommendations"));
    tabLayout.addTab(tabLayout.newTab().setText("People that I did once recommend I dont remember when exactly"));
    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

    adapter = new TabsAdapter(getSupportFragmentManager());
    viewPager.setAdapter(adapter);
    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
      @Override
      public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
      }


      @Override
      public void onTabUnselected(TabLayout.Tab tab) {
        //DO NOTHING
      }

      @Override
      public void onTabReselected(TabLayout.Tab tab) {
        //DO NOTHING
      }
    });
  }

}

