/*
File name:                   Page1
Description:                 Page 1 of the survey
Created:                     Faran Bhatti
Edited:                      2023-01-16 by Faran Bhatti (FB)
Last Edited:                 2023-01-17 by Faran Bhatti (FB)
*/

// Declaring where the source code of project is
package com.example.travelsurvey;

// Importing respective libraries
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class Page1 extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        // Create a vector of strings to store countries
        Vector<String> countries = new Vector<>();

        // Reading the countries from res/raw/countries.txt
        InputStream inputStream = getBaseContext().getResources().openRawResource(R.raw.countries);
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (line != null)
        {
            // Make use of the line read
            try {
                line = bufferedReader.readLine();
                countries.add(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Deleting null element from vector of strings
        countries.remove(countries.size()-1);
        // Determining ID for the spinner corresponding to country selection
        Spinner country_spinner = (Spinner) findViewById(R.id.spinner);
        // Creating an adapter for the spinner
        ArrayAdapter country_drop_down = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
        // Setting the adapter to the corresponding spinner
        country_spinner.setAdapter(country_drop_down);
    }

    public void nextPage(View view)
    {
        // Obtaining selected country spinner
        Spinner country_spinner = (Spinner) findViewById(R.id.spinner);
        String selected_country = country_spinner.getSelectedItem().toString();

        // Obtaining selected age range
        RadioGroup age_radio_group = (RadioGroup) findViewById(R.id.radioGroup);
        final String selected_age_range = ((RadioButton) findViewById(age_radio_group.getCheckedRadioButtonId())).getText().toString();

        // Creating an intent
        Intent intent = new Intent(this, Page2.class);

        // Creating a bundle object
        Bundle bundle = new Bundle();

        // Storing the selected user values into the bundle
        bundle.putString("Country", selected_country);

        // Storing the selected age range into the bundle
        bundle.putString("Age_Range", selected_age_range);

        // Pass the bundle into the intent
        intent.putExtras(bundle);

        // Starting the intent
        startActivity(intent);
    }
}