package com.belajarJDBC.jdbcTemplate.Controller;

import com.belajarJDBC.jdbcTemplate.Entity.Siswa;
import com.belajarJDBC.jdbcTemplate.Repository.SiswaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SiswaController {

    @Autowired
    @Qualifier("SiswaRepository") // sesuai dengan nama @repository di impl
    private SiswaImpl siswaRepository;

    @GetMapping("/siswaGetting")
    public List<Siswa> getSiswa(){
        return siswaRepository.findAll();
    }

    @PostMapping("/siswaAdding")
    public int PostSiswa(@Valid @RequestBody Siswa siswa){
        return siswaRepository.save(siswa);
    }

    @DeleteMapping("/siswaDeleteting")
    public int deleteSiswa(@RequestParam("id") Long id){
        return siswaRepository.deleteById(id);
    }

    @PutMapping("/siswaUpdating")
    public int updateSiswa(@Valid @RequestBody Siswa siswa){
        return siswaRepository.update(siswa);
    }

}
