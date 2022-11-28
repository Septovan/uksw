package com.fti.pl.PLSpringBootHibernate.controllers;

import com.fti.pl.PLSpringBootHibernate.models.Mahasiswa;
import com.fti.pl.PLSpringBootHibernate.repositories.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaRepository _mahasiswaRepository;

    @RequestMapping(path = {"/", "index"})
    public String index(Model model) {
        List<Mahasiswa> mahasiswaList = _mahasiswaRepository.findAll();
        model.addAttribute("mahasiswaList", mahasiswaList);
        return "mahasiswa/index";
    }

    @RequestMapping(path = "add")
    public String addMahasiswa() {
        return "mahasiswa/addMahasiswa";
    }

}
