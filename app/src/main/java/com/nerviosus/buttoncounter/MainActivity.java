package com.nerviosus.buttoncounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    // private Button button; VARIABLE DECLARED LOCALLY IN LINE 23 (or so)
    private TextView textView;
    private static final String TAG = "MainActivity"; // TO USE THE TAG FUNCTIONALITY AND BEING ABLE TO USE LOG.D
    private final String TEXT_CONTENTS = "TextContents";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: in");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.editText_id);
        Button button = (Button) findViewById(R.id.button_id);
        textView = (TextView)findViewById(R.id.textView_id);

        textView.setText(""); //THIS REPLACES THE TEXT IN THE WIDGET FOR WHATEVER YOU WANT
        textView.setMovementMethod(new ScrollingMovementMethod()); // THIS MAKES OUR TEXT SCROLL DOWN AS IT GETS BIGGER

        View.OnClickListener myFirstClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 // String result = userInput.getText().toString(); GET TEXT IS THE OPPOSITE OF SET TEXT. GET IS FOR AN INPUT. AND TO STRING IS TO CONVERT AN ANDROID EDITABLE TEXT TO A JAVA STRING
                // Editable editable = userInput.getText(); // ^^^^ THIS IS ANOTHER WAY OF DOING THIS ^^^^
                // String result = editable.toString(); // THIS LINE IS PART OF THE ONE ABOVE

                textView.append(userInput.getText().toString() + "\n");
                userInput.setText("");
            }
        };
        button.setOnClickListener(myFirstClickListener);
        Log.d(TAG, "onCreate: out");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: in");
        super.onRestart();
        Log.d(TAG, "onRestart: out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: in");
        super.onPause();
        Log.d(TAG, "onPause: out");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: in");
        outState.putString(TEXT_CONTENTS, textView.getText().toString()); //WE SAVE OUR DATA INSIDE THE 'OUTSTATE' BUNDLE
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onRestoreInstanceState(savedInstanceState);
        String savedString = savedInstanceState.getString(TEXT_CONTENTS); //WE TAKE BACK THE BUNDLE SAVED IN 'onSaveInstanceState'
        textView.setText(savedString);
      //  textView.setText(savedInstanceState.getString(TEXT_CONTENTS)); ^^ THIS IS THE SORT-CUT FOR THE THING ABOVE ^^
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: in");
        super.onDestroy();
        Log.d(TAG, "onDestroy: out");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: in");
        super.onStop();
        Log.d(TAG, "onStop: out");
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in");
        super.onStart();
        Log.d(TAG, "onStart: out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: in");
        super.onResume();
        Log.d(TAG, "onResume: out");
    }
}
