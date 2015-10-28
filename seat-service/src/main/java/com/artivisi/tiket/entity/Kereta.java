package com.artivisi.tiket.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import javax.validation.constraints.Size;

@Entity
@Table(name="kereta")
public class Kereta {

    @Id
    private String id;

    @Column(unique=true, nullable=false, name="kode")
    @Size(min=3, max=10)
    private String kode;
    private String nama;

    public String getKode(){
        return kode;
    }

    public void setKode(String x){
        kode = x;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String x){
        nama = x;
    }


}
