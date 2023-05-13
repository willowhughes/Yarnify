package com.example.yarnify;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yarnify.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<patternObject> exampleList = new ArrayList<>(); //array of pattern objects

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        //hardcoded example pattern objects
        exampleList.add(new patternObject(R.drawable.ravelry_sample_photo, "gloves", "Susan"));
        exampleList.add(new patternObject(R.drawable.armillafirm_small2, "thin sweater", "Jack"));
        exampleList.add(new patternObject(R.drawable.beanies_medium2, "beanies", "Bob"));

        setUpRecyclerView(); //method initializes and sets the recyclerview, adapter, and layout manager
    }

    public void setUpRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView); //initializes a variable mRecyclerView and assigns it to the view with the ID recyclerView from activity_main.xml layout file
        mRecyclerView.setHasFixedSize(true); //the size of the RecyclerView will remain constant and won't change as the contents of the adapter change
        mLayoutManager = new LinearLayoutManager(this); //LinearLayoutManager lays out items in a RecyclerView in a vertical fashion
        mAdapter = new cardAdapter(exampleList); //A cardAdapter is a custom adapter class that provides the data to the RecyclerView to display.
        //The exampleList is passed to the constructor and contains the list of pattern objects that will be displayed in the RecyclerView.
        mRecyclerView.setLayoutManager(mLayoutManager); //ensures that the RecyclerView knows how to lay out its items
        mRecyclerView.setAdapter(mAdapter); //sets adapter
    }

}