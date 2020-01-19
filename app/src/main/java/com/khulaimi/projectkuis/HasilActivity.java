package com.khulaimi.projectkuis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static java.lang.Math.round;

public class HasilActivity extends AppCompatActivity {

    public int benar = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        this.hitung();
    }

    public void hitung()
    {
        for (int i = 0; i < MainActivity.soals.size(); i++) {
            Soal s = MainActivity.soals.get(i);
            if (s.cek()) benar++;
        }

        String txtBenar = Integer.toString(benar) + "/" + Integer.toString(MainActivity.soals.size());
        String nilai = "Nilai : " + Integer.toString(round((100 / MainActivity.soals.size()) * benar));

        TextView tvHasil = (TextView) findViewById(R.id.hasil);
        TextView tvNilai = (TextView) findViewById(R.id.nilai);
        tvHasil.setText(txtBenar);
        tvNilai.setText(nilai);
    }

    public void reset(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}
