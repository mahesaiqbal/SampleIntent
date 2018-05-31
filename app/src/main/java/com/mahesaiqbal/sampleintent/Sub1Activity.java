package com.mahesaiqbal.sampleintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Sub1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        getSupportActionBar().setTitle("SubActivity1");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
