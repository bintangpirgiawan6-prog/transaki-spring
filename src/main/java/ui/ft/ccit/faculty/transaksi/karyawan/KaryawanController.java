package ui.ft.ccit.faculty.transaksi.karyawan;

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
@RequestMapping("/api/karyawan")
public class KaryawanController {

    @Autowired
    private KaryawanRepository karyawanRepo;

    @GetMapping
    public List<Karyawan> getAll() {
        return karyawanRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return karyawanRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Karyawan k) {
        karyawanRepo.save(k);
        return ResponseEntity.ok(k);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Karyawan req) {
        return karyawanRepo.findById(id).map(k -> {
            k.setNama(req.getNama());
            k.setJenisKelamin(req.getJenisKelamin());
            k.setAlamat(req.getAlamat());
            k.setTelepon(req.getTelepon());
            k.setTglLahir(req.getTglLahir());
            k.setGaji(req.getGaji());
            karyawanRepo.save(k);
            return ResponseEntity.ok(k);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (karyawanRepo.existsById(id)) {
            karyawanRepo.deleteById(id);
            return ResponseEntity.ok(Map.of("message", "Karyawan berhasil dihapus"));
        }
        return ResponseEntity.notFound().build();
    }
}
