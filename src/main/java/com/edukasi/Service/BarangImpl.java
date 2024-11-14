package com.edukasi.Service;


import com.edukasi.Models.Barang;
import com.edukasi.Repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarangImpl implements BarangInterface {

    @Autowired
    BarangRepository barangRepo;

    @Override
    public Barang createBarang(Barang barang) {
        return barangRepo.save(barang);

    }

    @Override
    public Barang updateBarang(Barang barang, Long id) {
        barang.setId(barang.getId());
        return barangRepo.save(barang);

    }

    @Override
    public Optional<Barang> getBarangById(Long id) {
        return barangRepo.findById(id);

    }

    @Override
    public List<Barang> getAllBarang() {
        return barangRepo.findAll();
    }

    @Override
    public void deleteBarang(Long id) {
        barangRepo.deleteById(id);
    }
}
