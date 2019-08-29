package model;

public class User {
    private String nama;
    private String key;
    private String alamat;
    private String kelamin;
    private String umur;

    public User(String alamat, String kelamin, String nama, String umur){
        this.alamat = alamat;
        this.kelamin = kelamin;
        this.nama = nama;
        this.umur = umur;
    }

    public User(){

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKelamin() {
        return kelamin;
    }

    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }
}
