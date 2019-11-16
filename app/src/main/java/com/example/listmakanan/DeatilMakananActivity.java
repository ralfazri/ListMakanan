package com.example.listmakanan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DeatilMakananActivity extends AppCompatActivity {

    TextView txtnama, desc;
    ImageView gambar;

    String nama;
    int photo;
    int id;
    String detail;

    Spinner spinner;


    private String[] namaHewan = {

            "Jerapah",
            "Gajah",
            "Sapi"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);
        nama = getIntent().getStringExtra("nama");
        photo =  getIntent().getIntExtra("gambar", 0);
        detail = getIntent().getStringExtra("detail");
        spinner = findViewById(R.id.spinner);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        txtnama = findViewById(R.id.nama_detail);
        desc = findViewById(R.id.desc_detail);
        gambar = findViewById(R.id.image_detail);

        txtnama.setText(nama);
        desc.setText(detail);
        Glide.with(getApplicationContext()).load(photo).into(gambar);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, namaHewan);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DeatilMakananActivity.this, "Kamu pelihara " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
