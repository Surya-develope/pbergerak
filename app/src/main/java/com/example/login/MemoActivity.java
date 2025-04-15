package com.example.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MemoActivity extends AppCompatActivity {

    private EditText edtMemo;
    private Button btnSimpanMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        edtMemo = findViewById(R.id.edtMemo);
        btnSimpanMemo = findViewById(R.id.btnSimpanMemo);

        btnSimpanMemo.setOnClickListener(view -> {
            String memo = edtMemo.getText().toString();
            if (!memo.isEmpty()) {
                Toast.makeText(MemoActivity.this, "Memo berhasil disimpan", Toast.LENGTH_SHORT).show();
                edtMemo.setText("");
            }
        });
    }
}
