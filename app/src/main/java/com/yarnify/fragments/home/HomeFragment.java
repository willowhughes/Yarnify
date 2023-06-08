package com.yarnify.fragments.home;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.yarnify.databinding.FragmentHomeBinding;
import com.yarnify.API.Request;
import com.yarnify.API.ResponseModels.ResponsePatternList;
import com.yarnify.API.ResponseUtilities.RequestToPattern;
import com.yarnify.API.ResponseUtilities.ToPojo;
import com.yarnify.cardAdapter;
import com.yarnify.model.Pattern;
import com.yarnify.viewmodel.PatternViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    //binding is an instance of the auto-generated FragmentHomeBinding class, which is used to bind the layout XML elements to their corresponding Java objects.
    private FragmentHomeBinding binding;
    private PatternViewModel patternViewModel;
    private RequestToPattern requestToPattern;

    ArrayList<Pattern> exampleList = new ArrayList<>(); //array of pattern objects

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment using the FragmentHomeBinding
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        exampleList.clear(); //clear the exampleList before adding new pattern objects
        // I don't think this is an ideal way to allow Network stuff on the main thread. Just using it for testing purposes
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Request request = new Request("patterns/search.json?page_size=100");
        String s = request.getResponse();
        try {
            exampleList = parsePatternsFromJson(s);
            // Use the patterns list as needed
        } catch (JSONException e) {
            e.printStackTrace();
            // Handle the exception or show an error message
        }


        //hardcoded example pattern objects
        exampleList.add(new Pattern("https://images4-f.ravelrycache.com/uploads/nawatramani/926341990/Making_Waves_4_small2.jpg", "Making Waves", "Nita Awatramani", "Knitting", "https://www.ravelry.com/patterns/library/making-waves-31", 0, 0));
        exampleList.add(new Pattern("https://images4-f.ravelrycache.com/uploads/Finnceburk/926533726/IMG_9809_medium.jpg", "Dragon Derek", "Finn Burke", "Crochet", "https://www.ravelry.com/patterns/library/dragon-derek", 383, 0));
        exampleList.add(new Pattern("https://images4-f.ravelrycache.com/uploads/mongaknit/926461293/20230513_1431102_small2.png", "DDuDDu", "mongaknit kang", "\n" +
                "Knitting", "https://www.ravelry.com/patterns/library/dduddu", 0, 0));


        setUpRecyclerView(); //method initializes and sets the recyclerview, adapter, and layout manager
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

    public ArrayList<Pattern> parsePatternsFromJson(String jsonString) throws JSONException {
        ArrayList<Pattern> patterns = new ArrayList<>();

        JSONObject response = new JSONObject(jsonString);
        JSONArray patternArray = response.getJSONArray("patterns");

        for (int i = 0; i < patternArray.length(); i++) {
            JSONObject patternObject = patternArray.getJSONObject(i);

            // Extract pattern data from the JSON object
            long id = patternObject.getLong("id");
            String image = patternObject.getJSONObject("first_photo").getString("medium_url");
            String title = patternObject.getString("name");
            String creator = patternObject.getJSONObject("designer").getString("name");
            String craft = "knitting";  // Assuming a default value
            String patternURL = "https://www.ravelry.com/patterns/library/" + patternObject.getString("permalink");
            int minYardage = 0;  // Assuming a default value
            int maxYardage = 0;  // Assuming a default value

            // Create a new Pattern object with the extracted data
            Pattern pattern = new Pattern(image, title, creator, craft, patternURL, minYardage, maxYardage);
            patterns.add(pattern);
        }

        return patterns;
    }
}