package com.example.willian.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import java.net.URL;

public class BookListActtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list_acttivity);
        TextView tvResult = (TextView) findViewById(R.id.tvResponse);

        try {
            URL bookURL = ApiUtil.buildURL("cooking");
            String jsonResult = ApiUtil.getJason(bookURL);

            tvResult.setText(jsonResult);
        }catch(Exception ex)
        {
            Log.d("error", ex.getMessage());
        }
    }
}
