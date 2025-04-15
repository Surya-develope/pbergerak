package com.example.login;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class TugasActivity extends AppCompatActivity {

    private EditText edtTugas, edtTenggat;
    private Button btnSimpanTugas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas);

        edtTugas = findViewById(R.id.edtTugas);
        edtTenggat = findViewById(R.id.edtTenggat);
        btnSimpanTugas = findViewById(R.id.btnSimpanTugas);

        edtTenggat.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    TugasActivity.this,
                    (view1, year1, monthOfYear, dayOfMonth1) -> {
                        edtTenggat.setText(dayOfMonth1 + "/" + (monthOfYear + 1) + "/" + year1);
                    },
                    year, month, dayOfMonth
            );
            datePickerDialog.show();
        });

        btnSimpanTugas.setOnClickListener(view -> {
            String tugas = edtTugas.getText().toString();
            String tenggat = edtTenggat.getText().toString();

            if (!tugas.isEmpty() && !tenggat.isEmpty()) {
                Toast.makeText(TugasActivity.this, "Tugas berhasil disimpan", Toast.LENGTH_SHORT).show();
                edtTugas.setText("");
                edtTenggat.setText("");
            } else {
                Toast.makeText(TugasActivity.this, "Pastikan semua data terisi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
