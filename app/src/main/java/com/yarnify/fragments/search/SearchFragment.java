package com.yarnify.fragments.search;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.yarnify.databinding.FragmentSearchBinding;
import com.yarnify.API.ResponseUtilities.UrlToPattern;
import com.yarnify.cardAdapter;
import com.yarnify.model.Pattern;

import org.json.JSONException;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    private FragmentSearchBinding binding;
    String query;
    ArrayList<Pattern> exampleList = new ArrayList<>(); //array of pattern objects

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        exampleList.clear(); //clear the exampleList before adding new pattern objects
        // I don't think this is an ideal way to allow Network stuff on the main thread. Just using it for testing purposes
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        UrlToPattern urlToPattern = new UrlToPattern();

        query = "pet";

        try {
            exampleList = urlToPattern.UrlToPatternList("patterns/search.json?query=" + query);
            // Use the patterns list as needed
        } catch (JSONException e) {
            e.printStackTrace();
            // Handle the exception or show an error message
        }

        if (exampleList.isEmpty()) {
            Log.d("Search Frag", "No search results!");
            Toast.makeText(getContext(), "No search results! Try different keywords", Toast.LENGTH_SHORT).show();
        } else {
            setUpRecyclerView(); //method initializes and sets the recyclerview, adapter, and layout manager
        }

        return root; // Return the root view created by inflating the FragmentHomeBinding
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void setUpRecyclerView() {
        RecyclerView mRecyclerView = binding.recyclerView;
        mRecyclerView.setHasFixedSize(true);

        // Use StaggeredGridLayoutManager instead of LinearLayoutManager
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter mAdapter = new cardAdapter(exampleList);
        mRecyclerView.setAdapter(mAdapter);
    }
}