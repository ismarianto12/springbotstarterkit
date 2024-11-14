package com.edukasi.Repository;

import com.edukasi.Models.Barang;
import org.aspectj.apache.bcel.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarangRepository extends JpaRepository<Barang, Long> {
}
