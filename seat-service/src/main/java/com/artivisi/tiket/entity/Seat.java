package com.artivisi.tiket.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import javax.validation.constraints.Min;

@Entity
@Table(name="seat_tersedia")
public class Seat {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name="id_kereta", nullable=false)
    private Kereta kereta;
    @ManyToOne
    @JoinColumn(name="id_kelas", nullable=false)
    private Kelas kelas;

    @Min(0)
    private Integer jumlah;

    public Kereta getKereta(){
        return kereta;
    }

    public void setKereta(Kereta x){
        kereta = x;
    }

    public Kelas getKelas(){
        return kelas;
    }

    public void setKelas(Kelas x){
        kelas = x;
    }

    public Integer getJumlah(){
        return jumlah;
    }

    public void setJumlah(Integer x){
        jumlah = x;
    }
}
