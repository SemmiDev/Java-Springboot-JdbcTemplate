package com.belajarJDBC.jdbcTemplate.Repository;

import com.belajarJDBC.jdbcTemplate.Entity.Siswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
* some people use impl / DAO( data acceess object)
**/

@Repository("SiswaRepository")
public class SiswaImpl implements SiswaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from siswa",Integer.class);
    }

    @Override
    public int save(Siswa siswa) {
        return jdbcTemplate
                .update(
                        "INSERT INTO public.siswa(lastname,firstname,gender,religion,hobby,address,city) values(?,?,?,?,?,?,?)",
                        siswa.getLastName(),
                        siswa.getFirstName(),
                        siswa.getGender(),
                        siswa.getReligion(),
                        siswa.getHobby(),
                        siswa.getAddress(),
                        siswa.getCity()
                );
    }

    @Override
    public int update(Siswa siswa) {
        return jdbcTemplate.update(
                "UPDATE siswa set lastname=?, firstname=?, gender=?,religion=?,hobby=?,address=?, city=? where siswaId=?",
                    siswa.getLastName(),
                    siswa.getFirstName(),
                    siswa.getGender(),
                    siswa.getReligion(),
                    siswa.getHobby(),
                    siswa.getAddress(),
                    siswa.getCity(),
                    siswa.getSiswaId()
        );
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("delete from siswa where siswaId=?",id);
    }

    @Override
    public List<Siswa> findAll() {
        return jdbcTemplate.query(
                "select * from siswa",
                (rs,rowNum) -> new Siswa(
                        rs.getLong("siswaId"),
                        rs.getString("lastname"),
                        rs.getString("firstname"),
                        rs.getString("gender"),
                        rs.getString("religion"),
                        rs.getString("hobby"),
                        rs.getString("address"),
                        rs.getString("city")
                )
        );
    }

    @Override
    public List<Siswa> findByLastName(String lastName) {
        return null;
    }

    @Override
    public Optional<Siswa> findById(Long id) {
        return Optional.empty();
    }
}
