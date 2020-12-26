package com.example.bms_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    String[] agent = {"agent1","agent2","agent3","agent4"};
    String[] agentpass = {"agentpass1","agentpass2","agentpass3","agentpass4"};
    String[] group={"groupe1","groupe2","groupe3","groupe4"};
    String[] grouppass = {"groupepass1","groupepass2","groupepass3","groupepass4"};

    EditText R_username,R_password;

    private CheckBox checkBox;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor UserEditor;
    private Boolean saveLogin;
    int agentOrGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Intent intent = getIntent();
        agentOrGroup = intent.getIntExtra("Group_OR_Agent",0);
        R_username = findViewById(R.id.username);
        R_password = findViewById(R.id.password);

        checkBox = findViewById(R.id.checkbox);
        loginPreferences = getSharedPreferences("FILE", MODE_PRIVATE);
        UserEditor = loginPreferences.edit();
        saveLogin = loginPreferences.getBoolean("saveLogin", false);

        if (saveLogin == true) {
            R_username.setText(loginPreferences.getString("username", ""));
            R_password.setText(loginPreferences.getString("password", ""));
            checkBox.setChecked(true);
        }

    }

    public void SignIn(View view) {
        String username = R_username.getText().toString();
        String password = R_password.getText().toString();
            try {
                if (agentOrGroup == 1) {
                    Log.i("Username2", username);
                    Log.i("Password2", password);
                }else if(agentOrGroup == 2){
                    Log.i("Username2", username);
                    Log.i("Password2", password);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                Intent intent = new Intent(SignInActivity.this,ResdelersActivity.class);
                startActivity(intent);
            }
    }
}