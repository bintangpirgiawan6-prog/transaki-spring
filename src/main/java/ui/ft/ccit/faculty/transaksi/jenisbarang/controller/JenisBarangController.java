package ui.ft.ccit.faculty.transaksi.jenisbarang.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ui.ft.ccit.faculty.transaksi.jenisbarang.model.JenisBarang;
import ui.ft.ccit.faculty.transaksi.jenisbarang.model.JenisBarangRepository;

@RestController
@RequestMapping("/api/jenis-barang")
public class JenisBarangController {

    private final JenisBarangRepository repository;

    public JenisBarangController(JenisBarangRepository repository) {
        this.repository = repository;
    }

    // GET ALL
    @GetMapping
    public List<JenisBarang> getAll() {
        return repository.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public JenisBarang getById(@PathVariable Integer id) {
        return repository.findById(id.byteValue())
                .orElseThrow(() ->
                        new RuntimeException("jenis barang tidak ditemukan"));
    }

    // POST
    @PostMapping
    public JenisBarang create(@RequestBody JenisBarang jenisBarang) {
        return repository.save(jenisBarang);
    }

    // PUT
    @PutMapping("/{id}")
    public JenisBarang update(
            @PathVariable Integer id,
            @RequestBody JenisBarang jenisBarang
    ) {
        JenisBarang existing = repository.findById(id.byteValue())
                .orElseThrow(() ->
                        new RuntimeException("jenis barang tidak ditemukan"));

        existing.setNamaJenis(jenisBarang.getNamaJenis());
        return repository.save(existing);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id.byteValue());
    }
}
