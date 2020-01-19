package com.khulaimi.projectkuis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SoalActivity extends AppCompatActivity {

    public String soal;
    public int nomor_soal;
    public String opsiA;
    public String opsiB;
    public String opsiC;
    public String opsiD;

    protected TextView txtSoal;
    protected Button btnA;
    protected Button btnB;
    protected Button btnC;
    protected Button btnD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);
        Intent i = getIntent();

        this.txtSoal = (TextView) findViewById(R.id.txtSoal);
        this.btnA = (Button) findViewById(R.id.btnJwb1);
        this.btnB = (Button) findViewById(R.id.btnJwb2);
        this.btnC = (Button) findViewById(R.id.btnJwb3);
        this.btnD = (Button) findViewById(R.id.btnJwb4);

        this.ambilData(i);
        this.tampil();
    }

    public void ambilData(Intent i)
    {
        this.soal = i.getStringExtra(MainActivity.SOAL_NAME);
        this.nomor_soal = i.getIntExtra(MainActivity.NOMOR_SOAL, 1);
        this.opsiA = i.getStringExtra(MainActivity.OPSIA_NAME);
        this.opsiB = i.getStringExtra(MainActivity.OPSIB_NAME);
        this.opsiC = i.getStringExtra(MainActivity.OPSIC_NAME);
        this.opsiD = i.getStringExtra(MainActivity.OPSID_NAME);
    }

    public void tampil()
    {
        this.txtSoal.setText(this.soal);
        this.btnA.setText(this.opsiA);
        this.btnB.setText(this.opsiB);
        this.btnC.setText(this.opsiC);
        this.btnD.setText(this.opsiD);
    }

    public void jawab(View v)
    {
        int id = v.getId();
        Soal soal = MainActivity.soals.get(this.nomor_soal);
        String jawaban = "";

        switch (id) {
            case R.id.btnJwb1:
                jawaban = "A";
                break;

            case R.id.btnJwb2:
                jawaban = "B";
                break;

            case R.id.btnJwb3:
                jawaban = "C";
                break;

            case R.id.btnJwb4:
                jawaban = "D";
                break;
        }

        soal.jawaban_user = jawaban;
        MainActivity.soals.set(this.nomor_soal, soal);
        this.next();
    }

    public void next()
    {
        this.nomor_soal++;
        if (MainActivity.soals.size() > this.nomor_soal) {
            Intent soal = new Intent(getApplicationContext(), SoalActivity.class);
            Soal s = MainActivity.soals.get(this.nomor_soal);
            soal.putExtra(MainActivity.NOMOR_SOAL, this.nomor_soal);
            soal.putExtra(MainActivity.SOAL_NAME, s.soal);
            soal.putExtra(MainActivity.OPSIA_NAME, s.A);
            soal.putExtra(MainActivity.OPSIB_NAME, s.B);
            soal.putExtra(MainActivity.OPSIC_NAME, s.C);
            soal.putExtra(MainActivity.OPSID_NAME, s.D);
            startActivity(soal);
        } else {
            Intent hasil = new Intent(this, HasilActivity.class);
            startActivity(hasil);
        }
    }
}
