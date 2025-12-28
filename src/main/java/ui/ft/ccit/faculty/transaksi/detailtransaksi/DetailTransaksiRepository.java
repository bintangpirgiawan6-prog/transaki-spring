package ui.ft.ccit.faculty.transaksi.detailtransaksi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailTransaksiRepository extends JpaRepository<DetailTransaksi, String> {
    // String karena primary key sekarang kode_transaksi
}
