package com.example.login;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    private TextView txtUserID, txtProfileUsername, txtProfileEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtUserID = findViewById(R.id.txtUserID);
        txtProfileUsername = findViewById(R.id.txtProfileUsername);
        txtProfileEmail = findViewById(R.id.txtProfileEmail);

        String userID = getIntent().getStringExtra("USER_ID");
        String username = getIntent().getStringExtra("USERNAME");
        String email = getIntent().getStringExtra("EMAIL");

        txtUserID.setText(userID);
        txtProfileUsername.setText(username);
        txtProfileEmail.setText(email);
    }
}
