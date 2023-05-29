package com.yarnify.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yarnify.R;
import com.yarnify.cardAdapter;
import com.example.yarnify.databinding.FragmentHomeBinding;
import com.yarnify.model.Pattern;
import com.yarnify.viewmodel.PatternViewModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    //binding is an instance of the auto-generated FragmentHomeBinding class, which is used to bind the layout XML elements to their corresponding Java objects.
    private FragmentHomeBinding binding;
    private PatternViewModel patternViewModel;

    ArrayList<Pattern> exampleList = new ArrayList<>(); //array of pattern objects
    private String url;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment using the FragmentHomeBinding
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //clear the exampleList before adding new pattern objects
        exampleList.clear();
        //hardcoded example pattern objects
        exampleList.add(new Pattern("https://images4-f.ravelrycache.com/uploads/Finnceburk/926533726/IMG_9809_medium.jpg", "Dragon Derek", "Finn Burke", "Crochet", "https://www.ravelry.com/patterns/library/dragon-derek", 383));
        exampleList.add(new Pattern("https://images4-f.ravelrycache.com/uploads/mongaknit/926461293/20230513_1431102_small2.png", "DDuDDu", "mongaknit kang", "\n" +
                "Knitting", "https://www.ravelry.com/patterns/library/dduddu", 0));
        exampleList.add(new Pattern("https://images4-f.ravelrycache.com/uploads/nawatramani/926341990/Making_Waves_4_small2.jpg", "Making Waves", "Nita Awatramani", "Knitting", "https://www.ravelry.com/patterns/library/making-waves-31", 0));

        setUpRecyclerView(); //method initializes and sets the recyclerview, adapter, and layout manager


        return root; // Return the root view created by inflating the FragmentHomeBinding
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void setUpRecyclerView() {
        RecyclerView mRecyclerView = binding.recyclerView; //initialize the RecyclerView from the binding object
        mRecyclerView.setHasFixedSize(true); //the size of the RecyclerView will remain constant and won't change as the contents of the adapter change
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext()); //LinearLayoutManager lays out items in a RecyclerView in a vertical fashion
        RecyclerView.Adapter mAdapter = new cardAdapter(exampleList); //A cardAdapter is a custom adapter class that provides the data to the RecyclerView to display.
        //The exampleList is passed to the constructor and contains the list of pattern objects that will be displayed in the RecyclerView.
        mRecyclerView.setLayoutManager(mLayoutManager); //ensures that the RecyclerView knows how to lay out its items
        mRecyclerView.setAdapter(mAdapter); //sets adapter
    }
}