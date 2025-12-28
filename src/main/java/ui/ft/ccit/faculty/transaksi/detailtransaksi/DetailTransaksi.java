package ui.ft.ccit.faculty.transaksi.detailtransaksi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "detail_transaksi")
public class DetailTransaksi {

    @Id
    @Column(name = "kode_transaksi", length = 10)
    private String kodeTransaksi;  // primary key string

    @Column(name = "id_barang", length = 10)
    private String idBarang;

    @Column(name = "jumlah")
    private int jumlah;

    public DetailTransaksi() { }

    public DetailTransaksi(String kodeTransaksi, String idBarang, int jumlah) {
        this.kodeTransaksi = kodeTransaksi;
        this.idBarang = idBarang;
        this.jumlah = jumlah;
    }

    // getter & setter
    public String getKodeTransaksi() { return kodeTransaksi; }
    public void setKodeTransaksi(String kodeTransaksi) { this.kodeTransaksi = kodeTransaksi; }
    public String getIdBarang() { return idBarang; }
    public void setIdBarang(String idBarang) { this.idBarang = idBarang; }
    public int getJumlah() { return jumlah; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }
}
