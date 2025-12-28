package ui.ft.ccit.faculty.transaksi.pelanggan;

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
@RequestMapping("/api/pelanggan")
public class PelangganController {

    @Autowired
    private PelangganRepository pelangganRepo;

    // ===== GET ALL =====
    @GetMapping
    public List<Pelanggan> getAll() {
        return pelangganRepo.findAll();
    }

    // ===== GET BY ID =====
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return pelangganRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ===== POST =====
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Pelanggan p) {
        pelangganRepo.save(p);
        return ResponseEntity.ok(p);
    }

    // ===== PUT =====
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Pelanggan req) {
        return pelangganRepo.findById(id).map(p -> {
            p.setNama(req.getNama());
            p.setEmail(req.getEmail());
            p.setTelepon(req.getTelepon());
            p.setAlamat(req.getAlamat());
            pelangganRepo.save(p);
            return ResponseEntity.ok(p);
        }).orElse(ResponseEntity.notFound().build());
    }

    // ===== DELETE =====
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (pelangganRepo.existsById(id)) {
            pelangganRepo.deleteById(id);
            return ResponseEntity.ok(Map.of("message", "Pelanggan berhasil dihapus"));
        }
        return ResponseEntity.notFound().build();
    }
}
