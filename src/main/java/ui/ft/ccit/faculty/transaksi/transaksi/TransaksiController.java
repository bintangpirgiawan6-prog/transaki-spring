package ui.ft.ccit.faculty.transaksi.transaksi;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaksi")
public class TransaksiController {

    @Autowired
    private TransaksiRepository transaksiRepo;

    // ===== GET ALL =====
    @GetMapping
    public List<Transaksi> getAll() {
        return transaksiRepo.findAll();
    }

    // ===== GET BY ID =====
    @GetMapping("/{kode}")
    public ResponseEntity<?> getById(@PathVariable String kode) {
        return transaksiRepo.findById(kode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ===== POST =====
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Transaksi t) {
        transaksiRepo.save(t);
        return ResponseEntity.ok(t);
    }

    // ===== PUT =====
    @PutMapping("/{kode}")
    public ResponseEntity<?> update(@PathVariable String kode, @RequestBody Transaksi req) {
        return transaksiRepo.findById(kode).map(t -> {
            t.setTglTransaksi(req.getTglTransaksi());
            t.setIdPelanggan(req.getIdPelanggan());
            t.setIdKaryawan(req.getIdKaryawan());
            transaksiRepo.save(t);
            return ResponseEntity.ok(t);
        }).orElse(ResponseEntity.notFound().build());
    }

    // ===== DELETE =====
    @DeleteMapping("/{kode}")
    public ResponseEntity<?> delete(@PathVariable String kode) {
        if (transaksiRepo.existsById(kode)) {
            transaksiRepo.deleteById(kode);
            return ResponseEntity.ok(Map.of("message", "Transaksi berhasil dihapus"));
        }
        return ResponseEntity.notFound().build();
    }
}
