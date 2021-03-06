package com.artivisi.tiket.controller;

import com.artivisi.tiket.entity.Kereta;
import com.artivisi.tiket.dao.KeretaDao;
import com.artivisi.tiket.exception.DataTidakAdaException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.HttpStatus;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import javax.validation.Valid;

@RestController
public class KeretaController {

    @Autowired private KeretaDao dao;

    @RequestMapping(value="/kereta", method=RequestMethod.GET)
    public Page<Kereta> daftarKereta(Pageable pr){
        return dao.findAll(pr);
    }

    
    @RequestMapping(value="/kereta", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createKereta(@RequestBody @Valid Kereta k){
        dao.save(k);
    }
    
    @RequestMapping(value="/kereta/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateKereta(@PathVariable String id, @RequestBody @Valid Kereta k){

        Kereta kx = dao.findOne(id);
        if(kx == null){
            throw new DataTidakAdaException("Kereta dengan id "+id+" tidak ada dalam database");
        }

        k.setId(id);
        dao.save(k);
    }

    @RequestMapping(value="/kereta/{id}", method=RequestMethod.GET)
    public Kereta keretaById(@PathVariable String id){

        Kereta kx = dao.findOne(id);
        if(kx == null){
            throw new DataTidakAdaException("Kereta dengan id "+id+" tidak ada dalam database");
        }
        return kx;
    }

    @RequestMapping(value="/kereta/{id}", method=RequestMethod.DELETE)
    public void deleteKeretaById(@PathVariable String id){

        Kereta kx = dao.findOne(id);
        if(kx == null){
            throw new DataTidakAdaException("Kereta dengan id "+id+" tidak ada dalam database");
        }
        dao.delete(kx);
    }
}
