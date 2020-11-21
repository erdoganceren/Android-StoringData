package com.cerenerdogan.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String userName;
    TextView textView;
    SharedPreferences sharedPreferences;
    EditText enterText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterText = findViewById(R.id.enterText);
        textView = findViewById(R.id.textView);
        sharedPreferences = this.getSharedPreferences("com.cerenerdogan.storingdata", Context.MODE_PRIVATE);
        String storedName = sharedPreferences.getString("storedName","");
        if(storedName == ""){
            textView.setText("Your Username: ");
        }else {
            textView.setText("Your Username: " + storedName);
        }
    }

    public void save(View view){
        if(!enterText.getText().equals("")){
            userName = enterText.getText().toString();
            textView.setText("Your Username: " + userName);
            sharedPreferences.edit().putString("storedName",userName).apply();

        }
    }

    public void delete(View view){
        String storedData = sharedPreferences.getString("storedName","");
        if(storedData != ""){
            sharedPreferences.edit().remove("storedName").apply();
            textView.setText("Your Username: ");
        }
    }
}