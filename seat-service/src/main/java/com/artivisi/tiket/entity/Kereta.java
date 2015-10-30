package com.artivisi.tiket.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;


import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="kereta")
@XmlRootElement
public class Kereta {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid",strategy="uuid2")
    private String id;

    @Column(unique=true, nullable=false, name="kode")
    @Size(min=3, max=10)
    private String kode;
    private String nama;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

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
