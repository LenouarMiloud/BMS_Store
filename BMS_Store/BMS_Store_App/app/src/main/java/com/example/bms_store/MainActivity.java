package com.example.bms_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int groupOrAgent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.GroupButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groupOrAgent = 1;
                Intent intent = new Intent(MainActivity.this,SignInActivity.class);
                intent.putExtra("Group_OR_Agent",groupOrAgent);
                startActivity(intent);
            }
        });

        findViewById(R.id.AgentButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groupOrAgent = 2;
                Intent intent = new Intent(MainActivity.this,SignInActivity.class);
                intent.putExtra("Group_OR_Agent",groupOrAgent);
                startActivity(intent);
            }
        });

    }
}