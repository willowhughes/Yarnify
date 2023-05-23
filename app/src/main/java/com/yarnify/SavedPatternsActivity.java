package com.yarnify;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.yarnify.R;
import com.yarnify.model.Pattern;

import java.util.ArrayList;

public class SavedPatternsActivity extends AppCompatActivity {

    ArrayList<Pattern> savedPatternExampleList = new ArrayList<>(); //array of pattern objects
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_patterns);
        setBackButton();

        //clear the exampleList before adding new pattern objects
        savedPatternExampleList.clear();
        //hardcoded example pattern objects until we can retrieve saved patterns from local database
        savedPatternExampleList.add(new Pattern(R.drawable.ravelry_sample_photo, "gloves", "Susan", "Crochet", "https://www.ravelry.com/patterns/library/helia-bolero", 1500));
        //exampleList.add(new Pattern(R.drawable.armillafirm_small2, "thin sweater", "Jack", "Crochet", "https://www.ravelry.com/patterns/library/helia-bolero", 1500));
        savedPatternExampleList.add(new Pattern(R.drawable.beanies_medium2, "beanies", "Bob", "Crochet", "https://www.ravelry.com/patterns/library/helia-bolero", 1500));

        setUpRecyclerView(context); //method initializes and sets the recyclerview, adapter, and layout manager

    }

    public void setUpRecyclerView(Context context) {
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView2); //initialize the RecyclerView from the binding object
        mRecyclerView.setHasFixedSize(true); //the size of the RecyclerView will remain constant and won't change as the contents of the adapter change
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context); //LinearLayoutManager lays out items in a RecyclerView in a vertical fashion
        RecyclerView.Adapter mAdapter = new cardAdapter(savedPatternExampleList); //A cardAdapter is a custom adapter class that provides the data to the RecyclerView to display.
        //The exampleList is passed to the constructor and contains the list of pattern objects that will be displayed in the RecyclerView.
        mRecyclerView.setLayoutManager(mLayoutManager); //ensures that the RecyclerView knows how to lay out its items
        mRecyclerView.setAdapter(mAdapter); //sets adapter
    }

    public void setBackButton() {
        // Get the support action bar
        ActionBar actionBar = getSupportActionBar();
        // Set the title
        actionBar.setTitle("Saved Patterns");
        // Enable the back button
        actionBar.setDisplayHomeAsUpEnabled(true);
        // Set a custom drawable for the up indicator to change its color
        Drawable upArrow = getResources().getDrawable(R.drawable.baseline_arrow_back_24);
        upArrow.setColorFilter(getResources().getColor(R.color.light_gray), PorterDuff.Mode.SRC_ATOP);
        actionBar.setHomeAsUpIndicator(upArrow);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                // Handle the back button click
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}