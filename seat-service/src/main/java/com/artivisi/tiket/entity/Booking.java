package com.artivisi.tiket.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="booking")
public class Booking {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid",strategy="uuid2")
    private String id;

    @NotNull @Past
    @Column(name="waktu_booking", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuBooking;
    
    @Column(name="waktu_kadaluarsa", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuKadaluarsa;

    @NotNull @NotEmpty
    @Column(name="nama_customer", nullable=false)
    private String namaCustomer;

    @NotNull @Min(1)
    private Integer jumlah;

    @ManyToOne
    @JoinColumn(name="id_kereta", nullable=false)
    private Kereta kereta;

    @ManyToOne
    @JoinColumn(name="id_kelas", nullable=false)
    private Kelas kelas;

    @Enumerated(EnumType.STRING)
    private StatusBooking status = StatusBooking.BARU;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getWaktuBooking() {
        return waktuBooking;
    }

    public void setWaktuBooking(Date waktuBooking) {
        this.waktuBooking = waktuBooking;
    }

    public Date getWaktuKadaluarsa() {
        return waktuKadaluarsa;
    }

    public void setWaktuKadaluarsa(Date waktuKadaluarsa) {
        this.waktuKadaluarsa = waktuKadaluarsa;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Kereta getKereta() {
        return kereta;
    }

    public void setKereta(Kereta kereta) {
        this.kereta = kereta;
    }

    public Kelas getKelas() {
        return kelas;
    }

    public void setKelas(Kelas kelas) {
        this.kelas = kelas;
    }

    public StatusBooking getStatus() {
        return status;
    }

    public void setStatus(StatusBooking status) {
        this.status = status;
    }
    
    

    
}
