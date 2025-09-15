package com.example.projek2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText nama, telp;
    RadioButton b1, b2, b3;
    Button tombol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        telp = findViewById(R.id.telp);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        tombol = findViewById(R.id.tombol);
        nama = findViewById(R.id.nama);
        String keterangan = "";

        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nama = nama.getText().toString().trim();
                String nomor = telp.getText().toString().trim();
                String keterangan = "";

                if (b1.isChecked()) {
                    keterangan = "Telepon Rumah";
                } else if (b2.isChecked()) {
                    keterangan = "Telepon Kantor";
                } else if (b3.isChecked()) {
                    keterangan = "No Pribadi";
                } else {
                    Toast.makeText(MainActivity.this, "Silakan pilih salah satu opsi.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (Nama.isEmpty() || nomor.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nama dan nomor telepon harus diisi.", Toast.LENGTH_SHORT).show();
                    return;
                }

                String hasil = "masuk sebagai " + Nama + " dengan no : " + nomor + " dengan keterangan " + keterangan;
                Toast.makeText(MainActivity.this, hasil, Toast.LENGTH_LONG).show();
            }
        });
    }
}
