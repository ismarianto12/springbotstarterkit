package com.edukasi.Service;

import com.edukasi.Models.Barang;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BarangInterface  {

    Barang createBarang(Barang barang);

    Barang updateBarang(Barang barang, Long id);

    Optional<Barang> getBarangById(Long id);

    List<Barang> getAllBarang();

    void deleteBarang(Long id);
}
