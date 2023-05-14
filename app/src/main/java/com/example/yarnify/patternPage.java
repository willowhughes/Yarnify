package com.example.yarnify;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class patternPage extends AppCompatActivity {

    //this activity is the display page for a pattern when it is clicked on

    public ImageView image;
    public TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_page);

        //sets local variables of the patterns data to the activity_pattern_page.xml layout's views
        image = findViewById(R.id.patternImage);
        text1 = findViewById(R.id.patternName);
        text2 = findViewById(R.id.patternCreator);

        Intent intent = getIntent(); //grabs intent from parent
        patternObject pat = intent.getParcelableExtra("clicked_item"); //grabs parceled patternObject that was clicked on to use in this class
        //sets patternObject's data to the pattern page's layout views
        image.setImageResource(pat.getImageResource());
        text1.setText(pat.getText1());
        text2.setText("by " + pat.getText2());

        //sets a action bar with a back button that returns the user to the parent activity(main activity)
        getSupportActionBar().setTitle("");
    }
}