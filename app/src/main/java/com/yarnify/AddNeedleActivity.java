package com.yarnify;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.yarnify.databinding.ActivityAddNeedleBinding;

import com.example.yarnify.R;

public class AddNeedleActivity extends AppCompatActivity {
    private Context context = this;
    private String type;
    private String craft;
    private int metric;
    private boolean isHook, metricUnits;
    private String us;
    private int length;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_needle);
        setBackButton();

        //Type RadioButton
        //https://stackoverflow.com/questions/22943045/why-oncheckedchanged-for-radiobutton-doesnt-get-raised-in-android
        RadioGroup typeRadioGroup = (RadioGroup) findViewById(R.id.craftType);
        typeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //Check which radio button was checked
                switch (checkedId) {
                    case R.id.knittingNeedle:
                        craft = "knitting";
                        isHook = false;
                        Log.i("Craft:", craft);
                        setTypeSpinner(R.array.knitting_needle_type_choices);
                        break;
                    case R.id.crochetHook:
                        craft = "crochet";
                        isHook = true;
                        Log.i("Craft:", craft);
                        setTypeSpinner(R.array.crochet_hook_type_choices);
                        break;
                }
            }
        });

        //Type Spinner initially shows all options
        setTypeSpinner(R.array.all_needle_type_choices);

        //SizeUnit RadioButton
        //https://stackoverflow.com/questions/22943045/why-oncheckedchanged-for-radiobutton-doesnt-get-raised-in-android
        RadioGroup sizeUnitRadioGroup = (RadioGroup) findViewById(R.id.needleSizeUnit);
        typeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //Check which radio button was checked
                switch (checkedId) {
                    case R.id.metric:
                        metricUnits = true;
                        break;
                    case R.id.us:
                        metricUnits = false;
                        break;
                }
            }
        });



    }

    /*
    * Sets and updates the Type Spinner to whatever array is appropriate
    * @params: int array ResourceID - the id of the array of strings for the dropdown
    */
    private void setTypeSpinner(int arrayResourceId) {
        //Spinner for type of needle
        Spinner typeSpinner = findViewById(R.id.needleTypeSpinner);
        int typeChoicesArrayId = arrayResourceId;
        ArrayAdapter<CharSequence> typeSpinnerAdapter = ArrayAdapter.createFromResource(this,
                typeChoicesArrayId, android.R.layout.simple_spinner_item);
        typeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeSpinnerAdapter);
        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = (String) parent.getItemAtPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void onCraftSelected(View view) {
        // Is the button checked?
        boolean checked = ((RadioButton) view).isChecked();
        //Check which radio button was checked
        switch (view.getId()) {
            case R.id.knittingNeedle:
                if (checked){
                    craft = "knitting";
                    isHook = false;
                }
                break;
            case R.id.crochetHook:
                if (checked){
                    craft = "crochet";
                    isHook = true;
                }
                break;
        }
    }

    public void onUnitsSelected(View view) {
        // Is the button checked?
        boolean checked = ((RadioButton) view).isChecked();
        //Check which radio button was checked
        switch (view.getId()) {
            case R.id.metric:
                if (checked){
                    metricUnits = true;
                }
                break;
            case R.id.crochetHook:
                if (checked){
                    metricUnits = false;
                }
                break;
        }
    }
    public void setBackButton() {
        // Get the support action bar
        ActionBar actionBar = getSupportActionBar();
        // Set the title
        actionBar.setTitle("Needles and Hooks");
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