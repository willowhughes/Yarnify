package com.yarnify;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.example.yarnify.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.yarnify.model.Yarn;
import com.yarnify.viewmodel.YarnViewModel;

import java.util.ArrayList;

public class YarnListActivity extends AppCompatActivity {

    private ArrayList<Yarn> allYarns = new ArrayList<>();
    private YarnViewModel yarnViewModel;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yarn_list);
        setBackButton();

        //The FAB button brings the user to a new screen to enter a new yarn
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AddYarnActivity.class);
                startActivity(intent);
            }
        });
    }
    public void setBackButton() {
        // Get the support action bar
        ActionBar actionBar = getSupportActionBar();
        // Set the title
        actionBar.setTitle("Yarns");
        // Enable the back button
        actionBar.setDisplayHomeAsUpEnabled(true);
        // Set a custom drawable for the up indicator to change its color
        Drawable upArrow = getResources().getDrawable(R.drawable.baseline_arrow_back_24);
        upArrow.setColorFilter(getResources().getColor(R.color.light_gray), PorterDuff.Mode.SRC_ATOP);
        actionBar.setHomeAsUpIndicator(upArrow);
    }
}