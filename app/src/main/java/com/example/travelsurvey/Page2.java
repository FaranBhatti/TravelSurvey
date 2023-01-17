/*
File name:                   Page2
Description:                 Page 2 of the survey
Created:                     Faran Bhatti
Edited:                      2023-01-17 by Faran Bhatti (FB)
Last Edited:                 2023-01-17 by Faran Bhatti (FB)
*/

// Declaring where the source code of project is
package com.example.travelsurvey;

// Importing respective libraries
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RatingBar;

public class Page2 extends AppCompatActivity
{
    // Declaring the corresponding checkboxes
    CheckBox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        // Finding checkboxes by its unique ID
        checkbox1 = (CheckBox)findViewById(R.id.checkBox1);
        checkbox2 = (CheckBox)findViewById(R.id.checkBox2);
        checkbox3 = (CheckBox)findViewById(R.id.checkBox3);
        checkbox4 = (CheckBox)findViewById(R.id.checkBox4);
        checkbox5 = (CheckBox)findViewById(R.id.checkBox5);

    }

    public void summaryPage(View view)
    {
        // Extracting the bundle
        Bundle bundle = getIntent().getExtras();

        // Creating an intent
        Intent intent = new Intent(this, Page3.class);

        // Storing the corresponding binary values into the bundles
        if(checkbox1.isChecked())
        {
            bundle.putString("checkbox1", "true");
        }
        else
        {
            bundle.putString("checkbox1", "false");
        }
        if(checkbox2.isChecked())
        {
            bundle.putString("checkbox2", "true");
        }
        else
        {
            bundle.putString("checkbox2", "false");
        }
        if(checkbox3.isChecked())
        {
            bundle.putString("checkbox3", "true");
        }
        else
        {
            bundle.putString("checkbox3", "false");
        }
        if(checkbox4.isChecked())
        {
            bundle.putString("checkbox4", "true");
        }
        else
        {
            bundle.putString("checkbox4", "false");
        }
        if(checkbox5.isChecked())
        {
            bundle.putString("checkbox5", "true");
        }
        else
        {
            bundle.putString("checkbox5", "false");
        }

        // Obtaining the user selected rating number
        RatingBar travel_rating = (RatingBar) findViewById(R.id.ratingBar);
        Float ratingNumber = travel_rating.getRating();

        // Storing the rating into the bundle
        bundle.putString("Rating", String.valueOf(ratingNumber));

        // Pass the bundle into the intent
        intent.putExtras(bundle);

        // Starting the intent
        startActivity(intent);
    }
}



/*
    // Extracting the bundle
    Bundle bundle = getIntent().getExtras();

//bundle.putString(key, value) to add something to the bundle
 */
