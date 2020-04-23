package com.belajarJDBC.jdbcTemplate.Entity;
import lombok.*;

// Lombok : auto get,set,const,and toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Siswa {
    private Long siswaId;
    private String lastName;
    private String firstName;
    private String gender;
    private String religion;
    private String hobby;
    private String address;
    private String city;
}
