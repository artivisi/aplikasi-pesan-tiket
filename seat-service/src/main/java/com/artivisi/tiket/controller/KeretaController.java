package com.artivisi.tiket.controller;

import com.artivisi.tiket.entity.Kereta;
import com.artivisi.tiket.dao.KeretaDao;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@RestController
public class KeretaController {

    @Autowired private KeretaDao dao;

    @RequestMapping(value="/kereta", method=RequestMethod.GET)
    public Page<Kereta> daftarKereta(Pageable pr){
        return dao.findAll(pr);
    }
}
