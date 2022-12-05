package com.fti.pl.PLSpringBootHibernate.controllers.apis;

import com.fti.pl.PLSpringBootHibernate.models.Mahasiswa;
import com.fti.pl.PLSpringBootHibernate.repositories.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/mahasiswa")
public class MahasiswaApiController {

    @Autowired
    private MahasiswaRepository _mahasiswaRepository;

    @GetMapping("/")
    public ResponseEntity<List<Mahasiswa>> getAllMahasiswa() {
        return new ResponseEntity<>(
            _mahasiswaRepository.findAll(),
            HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mahasiswa> getMahasiswa(@PathVariable int id) {
        return new ResponseEntity<>(_mahasiswaRepository.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Mahasiswa> addMahasiswa(@RequestBody Mahasiswa mahasiswa){
        Mahasiswa mhs = mahasiswa;
        _mahasiswaRepository.save(mhs);

        return new ResponseEntity<>(mhs, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mahasiswa> editMahasiswa(@RequestBody Mahasiswa mahasiswa, @PathVariable int id) {
        Mahasiswa mhs = mahasiswa;
        mhs.setId(id);
        _mahasiswaRepository.save(mhs);

        return new ResponseEntity<>(mhs, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMahasiswa(@PathVariable int id) {
        _mahasiswaRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
