package com.yarnify.fragments.search;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.yarnify.R;
import com.example.yarnify.databinding.FragmentSearchBinding;
import com.yarnify.API.ResponseUtilities.UrlToPattern;
import com.yarnify.cardAdapter;
import com.yarnify.model.Pattern;

import org.json.JSONException;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    private FragmentSearchBinding binding;
    private ArrayList<Pattern> exampleList = new ArrayList<>();
    private String query = "pet";
    private UrlToPattern urlToPattern;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        urlToPattern = new UrlToPattern();

        SearchView searchView = binding.searchView;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                performSearch(query);
                searchView.clearFocus(); // Hide the keyboard
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // can perform incremental search here
                return false;
            }
        });

        performSearch(query);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void performSearch(String query) {
        exampleList.clear();
        try {
            exampleList = urlToPattern.UrlToPatternList("patterns/search.json?query=" + query);
            if (exampleList.isEmpty()) {
                Toast.makeText(requireContext(), "No search results! Try different keywords", Toast.LENGTH_SHORT).show();
            } else {
                setUpRecyclerView();
            }
        } catch (JSONException e) {
            e.printStackTrace();
            // Handle the exception or show an error message
        }
    }

    private void setUpRecyclerView() {
        RecyclerView mRecyclerView = binding.recyclerView;
        mRecyclerView.setHasFixedSize(true);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter mAdapter = new cardAdapter(exampleList);
        mRecyclerView.setAdapter(mAdapter);
    }
}