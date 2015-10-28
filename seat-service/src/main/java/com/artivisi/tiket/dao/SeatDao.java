package com.artivisi.tiket.dao;

import com.artivisi.tiket.entity.Seat;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SeatDao extends PagingAndSortingRepository<Seat, String>{
    public Page<Seat> findByKeretaNamaContaining(String nama, Pageable p);
}
