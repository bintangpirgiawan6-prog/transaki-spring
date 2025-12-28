package ui.ft.ccit.faculty.transaksi.pelanggan;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelanggan")
public class Pelanggan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelanggan;

    @Column(length = 255, nullable = false)
    private String nama;

    @Column(length = 10)
    private String jenisKelamin;

    @Column(length = 255)
    private String alamat;

    @Column(length = 20)
    private String telepon;

    private LocalDate tglLahir;

    @Column(length = 50)
    private String jenisPelanggan;

    @Column(length = 255, unique = true)
    private String email;

    protected Pelanggan() { }

    public Pelanggan(String nama, String jenisKelamin, String alamat, String telepon, LocalDate tglLahir, String jenisPelanggan, String email) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.telepon = telepon;
        this.tglLahir = tglLahir;
        this.jenisPelanggan = jenisPelanggan;
        this.email = email;
    }

    // getter & setter
    public Long getIdPelanggan() { return idPelanggan; }
    public void setIdPelanggan(Long idPelanggan) { this.idPelanggan = idPelanggan; }
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
    public String getJenisPelanggan() { return jenisPelanggan; }
    public void setJenisPelanggan(String jenisPelanggan) { this.jenisPelanggan = jenisPelanggan; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
