package com.example.yarnify.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yarnify.R;
import com.example.yarnify.cardAdapter;
import com.example.yarnify.databinding.FragmentHomeBinding;
import com.example.yarnify.patternObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<patternObject> exampleList = new ArrayList<>(); //array of pattern objects

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //hardcoded example pattern objects
        exampleList.add(new patternObject(R.drawable.ravelry_sample_photo, "gloves", "Susan"));
        exampleList.add(new patternObject(R.drawable.armillafirm_small2, "thin sweater", "Jack"));
        exampleList.add(new patternObject(R.drawable.beanies_medium2, "beanies", "Bob"));
        setUpRecyclerView(); //method initializes and sets the recyclerview, adapter, and layout manager

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void setUpRecyclerView() {
        mRecyclerView = binding.recyclerView; //initialize the RecyclerView from the binding object
        mRecyclerView.setHasFixedSize(true); //the size of the RecyclerView will remain constant and won't change as the contents of the adapter change
        mLayoutManager = new LinearLayoutManager(getContext()); //LinearLayoutManager lays out items in a RecyclerView in a vertical fashion
        mAdapter = new cardAdapter(exampleList); //A cardAdapter is a custom adapter class that provides the data to the RecyclerView to display.
        //The exampleList is passed to the constructor and contains the list of pattern objects that will be displayed in the RecyclerView.
        mRecyclerView.setLayoutManager(mLayoutManager); //ensures that the RecyclerView knows how to lay out its items
        mRecyclerView.setAdapter(mAdapter); //sets adapter
    }
}