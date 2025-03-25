package com.example.login; // Tambahkan package ini jika belum ada

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    private TextView txtUserID, txtEmail;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtUserID = findViewById(R.id.txtUserID);
        txtEmail = findViewById(R.id.txtEmail);
        mAuth = FirebaseAuth.getInstance();

        // Ambil data user dari Firebase Authentication
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            String userID = user.getUid();
            String email = user.getEmail();

            // Cegah error jika userID atau email null
            txtUserID.setText(getString(R.string.user_id_text, (userID != null ? userID : "Tidak tersedia")));
            txtEmail.setText(getString(R.string.email_text, (email != null ? email : "Tidak tersedia")));
        } else {
            txtUserID.setText("User ID: Tidak ada user yang login");
            txtEmail.setText("Email: Tidak ada user yang login");
        }
    }
}
