package ui.ft.ccit.faculty.transaksi.karyawan;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "karyawan")
public class Karyawan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKaryawan;

    @Column(length = 255, nullable = false)
    private String nama;

    @Column(length = 10)
    private String jenisKelamin;

    @Column(length = 255)
    private String alamat;

    @Column(length = 20)
    private String telepon;

    private LocalDate tglLahir;

    private Double gaji;

    protected Karyawan() { }

    public Karyawan(String nama, String jenisKelamin, String alamat, String telepon, LocalDate tglLahir, Double gaji) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.telepon = telepon;
        this.tglLahir = tglLahir;
        this.gaji = gaji;
    }

    // getter & setter
    public Long getIdKaryawan() { return idKaryawan; }
    public void setIdKaryawan(Long idKaryawan) { this.idKaryawan = idKaryawan; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getJenisKelamin() { return jenisKelamin; }
    public void setJenisKelamin(String jenisKelamin) { this.jenisKelamin = jenisKelamin; }
    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
    public String getTelepon() { return telepon; }
    public void setTelepon(String telepon) { this.telepon = telepon; }
    public LocalDate getTglLahir() { return tglLahir; }
    public void setTglLahir(LocalDate tglLahir) { this.tglLahir = tglLahir; }
    public Double getGaji() { return gaji; }
    public void setGaji(Double gaji) { this.gaji = gaji; }
}
