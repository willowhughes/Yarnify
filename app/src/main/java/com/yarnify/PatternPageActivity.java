package com.yarnify;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.yarnify.R;
import com.yarnify.model.Pattern;

public class PatternPageActivity extends AppCompatActivity {

    //this activity is the display page for a pattern when it is clicked on

    public ImageView image;
    public TextView text1, text2, text3, text4, text5;
    public Button saveButton;
    public boolean isSaved; //todo implement checking device for whether current pattern is saved already

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_page);

        //sets local variables of the patterns data to the activity_pattern_page.xml layout's views
        image = findViewById(R.id.patternImage);
        text1 = findViewById(R.id.patternName);
        text2 = findViewById(R.id.patternCreator);
        saveButton = findViewById(R.id.saveButton);
        text3 = findViewById(R.id.patternCraft);
        text4= findViewById(R.id.patternURL);
        text5 = findViewById(R.id.patternTotalYardage);

        Intent intent = getIntent(); //grabs intent from parent
        Pattern pat = intent.getParcelableExtra("clicked_item"); //grabs parceled patternObject that was clicked on to use in this class
        //sets patternObject's data to the pattern page's layout views
        image.setImageResource(pat.getImageResource());
        text1.setText(pat.getTitle());
        text2.setText("by " + pat.getCreator());
        text3.setText("Craft: " + pat.getCraft());
        text4.setText("Pattern's URL: " + pat.getURL());
        text5.setText("Total Yardage: " + pat.getTotalYardage());

        //sets a action bar with a back button that returns the user to the parent activity(main activity)
        setBackButton();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveButton.setText("Saved");
                //todo implement saving 'patternObject pat' to users device
            }
        });
    }

    public void setBackButton() {
        // Get the support action bar
        ActionBar actionBar = getSupportActionBar();
        // Set the title and display the back button
        actionBar.setTitle("");
        actionBar.setDisplayHomeAsUpEnabled(true);
        // Set a custom drawable for the up indicator to change its color
        Drawable upArrow = getResources().getDrawable(R.drawable.baseline_arrow_back_24);
        upArrow.setColorFilter(getResources().getColor(R.color.light_gray), PorterDuff.Mode.SRC_ATOP);
        actionBar.setHomeAsUpIndicator(upArrow);
    }


}