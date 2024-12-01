package com.example.android.notepad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class searchresult extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresult);
        Bundle extras = getIntent().getExtras();
        String mes=extras.getString("message");
        TextView textView = (TextView) findViewById(R.id.result1);
        textView.setText(mes);
    }
}