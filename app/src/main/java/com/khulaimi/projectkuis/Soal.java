package com.khulaimi.projectkuis;

public class Soal {

    public String soal;
    public String jawaban;
    public String jawaban_user;
    public String A;
    public String B;
    public String C;
    public String D;

    public Soal(String soal, String jawaban, String A, String B, String C, String D )
    {
        this.soal = soal;
        this.jawaban = jawaban;
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
    }

    public Boolean cek()
    {
        if (this.jawaban_user == this.jawaban) {
            return true;
        } else {
            return false;
        }
    }
}
