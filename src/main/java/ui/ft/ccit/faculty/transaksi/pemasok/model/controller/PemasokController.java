package ui.ft.ccit.faculty.transaksi.pemasok.model.controller;

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

import ui.ft.ccit.faculty.transaksi.pemasok.model.Pemasok;
import ui.ft.ccit.faculty.transaksi.pemasok.model.PemasokRepository;

@RestController
@RequestMapping("/api/pemasok")
public class PemasokController {

    @Autowired
    private PemasokRepository pemasokRepo;

    // ===== GET ALL =====
    @GetMapping
    public List<Pemasok> getAll() {
        return pemasokRepo.findAll();
    }

    // ===== GET BY ID =====
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        return pemasokRepo.findById(id)
                .map(p -> ResponseEntity.ok(p))
                .orElse(ResponseEntity.notFound().build());
    }

    // ===== POST =====
    @PostMapping
    public ResponseEntity<?> createPemasok(@RequestBody Pemasok pemasok) {
        if(pemasokRepo.existsById(pemasok.getIdPemasok())){
            return ResponseEntity.badRequest()
                    .body(Map.of("message", "ID Pemasok sudah ada"));
        }
        pemasokRepo.save(pemasok);
        return ResponseEntity.ok(pemasok);
    }

    // ===== PUT =====
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePemasok(@PathVariable String id, @RequestBody Pemasok req) {
        return pemasokRepo.findById(id).map(p -> {
            p.setNamaPemasok(req.getNamaPemasok());
            p.setAlamat(req.getAlamat());
            p.setTelepon(req.getTelepon());
            p.setEmail(req.getEmail());
            pemasokRepo.save(p);
            return ResponseEntity.ok(p);
        }).orElse(ResponseEntity.notFound().build());
    }

    // ===== DELETE =====
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePemasok(@PathVariable String id) {
        if(pemasokRepo.existsById(id)){
            pemasokRepo.deleteById(id);
            return ResponseEntity.ok(Map.of("message", "Pemasok berhasil dihapus"));
        }
        return ResponseEntity.notFound().build();
    }
}
