package com.belajarJDBC.jdbcTemplate.Repository;

import com.belajarJDBC.jdbcTemplate.Entity.Siswa;

import java.util.List;
import java.util.Optional;

public interface SiswaRepository {
    int count();
    int save(Siswa siswa);
    int update(Siswa siswa);
    int deleteById(Long id);

    List<Siswa> findAll();
    List<Siswa> findByLastName(String lastName);
    Optional<Siswa> findById(Long id);
}
