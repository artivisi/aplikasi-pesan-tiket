package com.artivisi.tiket.controller;

import com.artivisi.tiket.entity.Seat;
import com.artivisi.tiket.dao.SeatDao;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@RestController
public class SeatController {

    @Autowired private SeatDao dao;

    @RequestMapping(value="/seat", method=RequestMethod.GET)
    public Page<Seat> daftarSeat(Pageable pr, @RequestParam(required=false)String kereta){
        if(kereta !=  null){
            return dao.findByKeretaNamaContaining(kereta, pr);
        }

        return dao.findAll(pr);
    }
}
