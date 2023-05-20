package com.yarnify;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yarnify.R;
import com.yarnify.model.Pattern;

import java.util.ArrayList;

public class cardAdapter extends RecyclerView.Adapter<cardAdapter.exampleViewHolder> {

    private ArrayList<Pattern> mExampleList; //local variable that will hold the passed in list of patternObjects

    public static class exampleViewHolder extends RecyclerView.ViewHolder { //contains three views  that will be displayed in the card. The constructor of this class sets the views
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public exampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView1);
            mTextView2 = itemView.findViewById(R.id.textView2);
        }
    }

    //defines the constructor for the adapter that takes an array of patternObjects and assigns it to the mExampleList variable.
    public cardAdapter(ArrayList<Pattern> exampleList) {
        mExampleList = exampleList;
    }

    @NonNull
    @Override
    //This method is called when a new ViewHolder object needs to be created for the RecyclerView. It inflates the pattern_card.xml layout file
    //and returns a new exampleViewHolder object based on the inflated view.
    public exampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pattern_card, parent, false);
        exampleViewHolder evh = new exampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull exampleViewHolder holder, int position) { //This method is called to bind the data to a specific view holder
        Pattern currentItem = mExampleList.get(position);
        //sets the values of the ImageView and two TextView views in the exampleViewHolder object based on the patternObject at the position in the mExampleList array.
        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getTitle());
        holder.mTextView2.setText("by " + currentItem.getCreator());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start a new activity and pass the clicked item as an extra
                Intent intent = new Intent(view.getContext(), PatternPageActivity.class);
                intent.putExtra("clicked_item", currentItem);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}