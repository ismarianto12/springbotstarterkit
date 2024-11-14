package com.edukasi.Controllers;

import com.edukasi.Models.Barang;
import com.edukasi.Repository.BarangRepository;
import com.edukasi.Service.BarangImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/barang")
public class BarangController {


    @Autowired
    BarangRepository barangRepository;
    @Autowired
    private BarangImpl barangImpl;


    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ResponseEntity<?> index() throws Exception {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Barang> data = barangRepository.findAll();
            map.put("status", "success");
            map.put("data", data);
            map.put("message", "data barang");
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", e.getMessage());
            map.put("message", "error");
            return ResponseEntity.badRequest().body(map);
        }
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> Create(@RequestBody() Barang barang) throws Exception {
        Map<String, Object> map = new HashMap<>();
        try {
            barangImpl.createBarang(barang);
            map.put("status", "success");
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", e.getMessage());
            map.put("message", "error");
            return ResponseEntity.badRequest().body(map);
        }
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Barang barang, @PathVariable("id") Long id) throws Exception {
        Map<String, Object> map = new HashMap<>();
        try {
            barangImpl.updateBarang(barang, id);
            map.put("status", "success");
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", e.getMessage());
            map.put("message", "error");
            return ResponseEntity.badRequest().body(map);
        }
    }

    @RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> show(@PathVariable("id") Long id) throws Exception {
        Map<String, Object> map = new HashMap<>();
        try {
            Optional<Barang> databarang = barangImpl.getBarangById(id);
            map.put("data", databarang.get());
            map.put("status", "success");
            map.put("message", "200");
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", e.getMessage());
            map.put("message", "error");
            return ResponseEntity.badRequest().body(map);
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {
        Map<String, Object> map = new HashMap<>();
        try {
            barangImpl.deleteBarang(id);
            map.put("status", "data barang berhasil di hapus.");
            map.put("message", "200");
            map.put("http", "success");
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", e.getMessage());
            map.put("message", "error");
            return ResponseEntity.badRequest().body(map);
        }
    }

}
