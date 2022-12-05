package com.fti.pl.PLSpringBootHibernate.controllers;

import com.fti.pl.PLSpringBootHibernate.models.Mahasiswa;
import com.fti.pl.PLSpringBootHibernate.repositories.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String addMahasiswa(Model model) {
        Mahasiswa mhs = new Mahasiswa();
        model.addAttribute("mahasiswa", mhs);
        return "mahasiswa/formMahasiswa";
    }

    @RequestMapping(path = "doProcess", method = RequestMethod.POST)
    public String doProcessMahasiswa(Mahasiswa mahasiswa) {
        _mahasiswaRepository.save(mahasiswa);
        return "redirect:/mahasiswa/";
    }

    @RequestMapping(path = "edit")
    public String editMahasiswa(Model model, @RequestParam(name = "idMahasiswa") String idMahasiswa) {
        Mahasiswa mhs = _mahasiswaRepository.findById(Integer.valueOf(idMahasiswa)).get();
        model.addAttribute("mahasiswa", mhs);
        return "mahasiswa/formMahasiswa";
    }

    @RequestMapping(path = "delete")
    public String doDeleteMahasiswa(@RequestParam(name = "idMahasiswa") String idMahasiswa) {
        _mahasiswaRepository.deleteById(Integer.valueOf(idMahasiswa));
        return "redirect:/mahasiswa/";
    }
}