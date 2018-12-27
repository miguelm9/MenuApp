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
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(TEXT_CONTENTS, textView.getText().toString()); //WE SAVE OUR DATA INSIDE THE 'OUTSTATE' BUNDLE
        super.onSaveInstanceState(outState);

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

}
