package com.nerviosus.buttoncounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    RequestQueue queue = Volley.newRequestQueue(this);
    String url = "https://neat-axis-217814.appspot.com"; //SEND REQUEST SHIT ^^^^

    private EditText userInput;
    // private Button button; VARIABLE DECLARED LOCALLY IN LINE 23 (or so)
    private TextView textView;
    private static final String TAG = "MainActivity"; // TO USE THE TAG FUNCTIONALITY AND BEING ABLE TO USE LOG.D
    private final String TEXT_CONTENTS = "TextContents";
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: in");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ALL OF THIS IS TO SEND A REQUEST TO A HTTP >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        mTextView = (TextView)findViewById(R.id.textView_id);                                                  //^
                                                                                                        //^
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,                        //^
                new Response.Listener<String>() {                                                       //^
                    @Override                                                                           //^
                    public void onResponse(String response) {                                            //^
                        mTextView.setText("Response is: " + response.substring(0, 500));                  //^
                    }                                                                                   //^
                }, new Response.ErrorListener() {                                                       //^
            @Override                                                                                  //^
            public void onErrorResponse(VolleyError error) {                                           //^
                mTextView.setText("That didnt work!");                                                 //^
            }                                                                                          //^
        });                                                                                            //^
                                                                                                       //^
        queue.add(stringRequest);                                                                      //^
        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^


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

//    final TextView mTextView = (TextView) findViewById(R.id.text);
//
//    // Instantiate the RequestQueue.
//    RequestQueue queue = Volley.newRequestQueue(this);
//    String url ="https://neat-axis-217814.appspot.com";
//
//    // Request a string response from the provided URL.
//    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//            new Response.Listener<String>() {
//                @Override
//                public void onResponse(String response) {
//                    // Display the first 500 characters of the response string.
//                    mTextView.setText("Response is: "+ response.substring(0,500));
//                }
//            }, new Response.ErrorListener() {
//        @Override
//        public void onErrorResponse(VolleyError error) {
//            mTextView.setText("That didn't work!");
//        }
//
//    });
//// Add the request to the RequestQueue.
//    queue.add(stringRequest);








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
}
