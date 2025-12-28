package ui.ft.ccit.faculty.transaksi.detailtransaksi;

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
@RequestMapping("/api/detail-transaksi")
public class DetailTransaksiController {

    @Autowired
    private DetailTransaksiRepository repo;

    // GET all
    @GetMapping
    public List<DetailTransaksi> getAll() {
        return repo.findAll();
    }

    // GET by kodeTransaksi
    @GetMapping("/{kodeTransaksi}")
    public ResponseEntity<?> getById(@PathVariable String kodeTransaksi) {
        return repo.findById(kodeTransaksi)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // POST
    @PostMapping
    public ResponseEntity<?> create(@RequestBody DetailTransaksi dt) {
        repo.save(dt);
        return ResponseEntity.ok(dt);
    }

    // PUT
    @PutMapping("/{kodeTransaksi}")
    public ResponseEntity<?> update(@PathVariable String kodeTransaksi, @RequestBody DetailTransaksi req) {
        return repo.findById(kodeTransaksi).map(dt -> {
            dt.setIdBarang(req.getIdBarang());
            dt.setJumlah(req.getJumlah());
            repo.save(dt);
            return ResponseEntity.ok(dt);
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping("/{kodeTransaksi}")
    public ResponseEntity<?> delete(@PathVariable String kodeTransaksi) {
        if (repo.existsById(kodeTransaksi)) {
            repo.deleteById(kodeTransaksi);
            return ResponseEntity.ok(Map.of("message", "Detail transaksi berhasil dihapus"));
        }
        return ResponseEntity.notFound().build();
    }
}
