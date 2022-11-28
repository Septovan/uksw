package com.fti.pl.PLSpringBootHibernate.repositories;

import com.fti.pl.PLSpringBootHibernate.models.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Integer> {
}
