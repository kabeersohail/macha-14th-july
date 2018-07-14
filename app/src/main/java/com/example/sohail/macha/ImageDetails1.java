package com.example.sohail.macha;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sohail.macha.Adapter.CustomViewPagerAdapter;
import com.example.sohail.macha.Model.Model;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hold1.pagertabsindicator.PagerTabsIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImageDetails1 extends AppCompatActivity {
    int position;
    static int size;
    static String[] images;
    ViewPager viewPager;
    PagerTabsIndicator pagerTabsIndicator;
    List<Model> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details1);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Products");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                 size = (int) dataSnapshot.child("Jeans").child("Images").getChildrenCount();
                 images = new String[size];
                for(int i=1;i<size;i++){
                    images[i] = (String) (dataSnapshot.child("Jeans").child("Images").child(String.valueOf(i)).getValue());
                }
                Intent i = getIntent();
                position = Objects.requireNonNull(i.getExtras()).getInt("position");
                initModel();
                viewPager = findViewById(R.id.ViewPager);
                pagerTabsIndicator = findViewById(R.id.tabsIndicator);
                viewPager.setAdapter(new CustomViewPagerAdapter(models,ImageDetails1.this));
                pagerTabsIndicator.setViewPager(viewPager);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void initModel() {
        String url;
        Model model;
        for(int i=1;i<size;i++){
            url = images[i];
            model = new Model("Page 1",R.drawable.m1,url);
            models.add(model);
        }
    }
}
