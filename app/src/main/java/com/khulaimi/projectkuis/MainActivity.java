package com.khulaimi.projectkuis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static MainActivity contex;
    public static ArrayList<Soal> soals = new ArrayList<Soal>();
    public static final String NOMOR_SOAL = "com.khulaimi.projectkuis.NOMOR_SOAL";
    public static final String SOAL_NAME = "com.khulaimi.projectkuis.SOAL";
    public static final String OPSIA_NAME = "com.khulaimi.projectkuis.OPSIA";
    public static final String OPSIB_NAME = "com.khulaimi.projectkuis.OPSIB";
    public static final String OPSIC_NAME = "com.khulaimi.projectkuis.OPSIC";
    public static final String OPSID_NAME = "com.khulaimi.projectkuis.OPSID";
    public static int nomor = 1;

    protected void addSoal()
    {
        soals.add(new Soal(
                "Tumbuhan hijau melakukan fotosintesis pada ….",
                "A",
                "Daunnya ",
                "Batangnya",
                "Bunganya",
                "Akarnya"
        ));
        soals.add(new Soal(
                "Tumbuhan yang dapat dikembangbiakan denga cara setek ialah ….",
                "C",
                "padi, jagung, kangkung",
                "kentang, bawang, llobak",
                "singkong, tebu, kangkung",
                "terung, buncing kedelai"
        ));
        soals.add(new Soal(
                "Jantung berfungsi untuk ….",
                "B",
                "membuat butir-butir darah",
                "memompa darah ke seluruh tubuh",
                "mencampur darah dengan oksigen",
                "tempat meyimpan darah"
        ));
        soals.add(new Soal(
                "Hewan yang berkembang biak dengan cara bertelur mempunyai ciri ….",
                "B",
                "berkaki empat",
                "mempunyai sisik",
                "memiliki kelenjar susu",
                "memiliki daun telinga"
        ));
        soals.add(new Soal(
                "Planet-planet berurutan yang mengelilingi matahari adalah ….",
                "D",
                "Mars, Saturnus, Neptunus, Venus",
                "Venus, Yupiter, Uranus, Neptunus",
                "Bumi, Yupiter, Uranus, Pluto, Venus",
                "Venus, Bumi, Mars, Yupiter"
        ));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.addSoal();
        contex = this;
    }

    public void mulai(View v)
    {
        Intent soal = new Intent(this, SoalActivity.class);
        soal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Soal s = soals.get(nomor);
        soal.putExtra(NOMOR_SOAL, nomor);
        soal.putExtra(SOAL_NAME, s.soal);
        soal.putExtra(OPSIA_NAME, s.A);
        soal.putExtra(OPSIB_NAME, s.B);
        soal.putExtra(OPSIC_NAME, s.C);
        soal.putExtra(OPSID_NAME, s.D);
        startActivity(soal);
    }
}
