package ui.ft.ccit.faculty.transaksi.transaksi;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaksi")
public class Transaksi {

    @Id
    @Column(length = 10)
    private String kodeTransaksi;

    private LocalDateTime tglTransaksi;

    @Column(length = 10)
    private String idPelanggan;

    @Column(length = 10)
    private String idKaryawan;

    public Transaksi() { }

    public Transaksi(String kodeTransaksi, LocalDateTime tglTransaksi, String idPelanggan, String idKaryawan) {
        this.kodeTransaksi = kodeTransaksi;
        this.tglTransaksi = tglTransaksi;
        this.idPelanggan = idPelanggan;
        this.idKaryawan = idKaryawan;
    }

    // getter & setter
    public String getKodeTransaksi() { return kodeTransaksi; }
    public void setKodeTransaksi(String kodeTransaksi) { this.kodeTransaksi = kodeTransaksi; }
    public LocalDateTime getTglTransaksi() { return tglTransaksi; }
    public void setTglTransaksi(LocalDateTime tglTransaksi) { this.tglTransaksi = tglTransaksi; }
    public String getIdPelanggan() { return idPelanggan; }
    public void setIdPelanggan(String idPelanggan) { this.idPelanggan = idPelanggan; }
    public String getIdKaryawan() { return idKaryawan; }
    public void setIdKaryawan(String idKaryawan) { this.idKaryawan = idKaryawan; }
}
