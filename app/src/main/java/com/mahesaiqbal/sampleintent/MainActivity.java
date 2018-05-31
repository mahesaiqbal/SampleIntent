package com.mahesaiqbal.sampleintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnSub1, btnSub2, btnDial, btnWebView, btnShare, btnMap;
    private String strIntent;
    private EditText txtIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSub1 = (Button) findViewById(R.id.btn_activity_sub_1);
        btnSub2 = (Button) findViewById(R.id.btn_activity_sub_2);
        btnDial = (Button) findViewById(R.id.btn_activity_dial);
        btnWebView = (Button) findViewById(R.id.btn_web_view);
        btnShare = (Button) findViewById(R.id.btn_share);
        btnMap = (Button) findViewById(R.id.btn_map);

        txtIntent = (EditText)findViewById(R.id.text_intent);

        btnSub1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sub1Activity.class);
                startActivity(intent);
            }
        });

        btnSub2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                strIntent = txtIntent.getText().toString();
                Intent intent = new Intent(MainActivity.this, Sub2Activity.class);
                intent.putExtra(Sub2Activity.KEY_DATA, strIntent);
                startActivityForResult(intent, 0);
            }
        });

        btnDial.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 081294502208"));
                startActivity(intent);
            }
        });

        btnWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webView = new Intent(Intent.ACTION_VIEW, Uri.parse("https://medium.com/@mahesaiqbal6"));
                startActivity(webView);
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, "Sharing Text");
                startActivity(Intent.createChooser(share, "Share using"));
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = "budiluhur salemba";

                Intent map = new Intent(Intent.ACTION_VIEW);
                map.setData(Uri.parse("http://maps.google.co.id/maps?q=" + address));
                startActivity(map);
            }
        });
    }
}
