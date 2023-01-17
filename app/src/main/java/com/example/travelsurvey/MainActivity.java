/*
File name:                   MainActivity
Description:                 Main page for the survey
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
import android.widget.EditText;
import android.widget.Toast;

// Global declarations

// class for main activity
public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Called when user taps Start button
    public void checkPassword(View view)
    {
        // Obtain the user's input value for password
        EditText editText = findViewById(R.id.editTextTextPassword);
        String editTextValue = editText.getText().toString();

        //String message = editText.getText().toString();

        // Create an Intent with the current and target Activities specified (explicit intent)
        Intent intent = new Intent(this, Page1.class);

        // If password is correct (COMP7855) then go to page 1 else do nothing
        if (editTextValue.equals("COMP7855"))
        {
            // Enter next page
            startActivity(intent);
        }
        else
        {
            // Toast parameters
            Context context = getApplicationContext();
            CharSequence text = "WRONG CODE";
            int duration = Toast.LENGTH_SHORT;

            // Prompting user that they inputted the wrong code
            Toast.makeText(context, text, duration).show();
        }
    }
}