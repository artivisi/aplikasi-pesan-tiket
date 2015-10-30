package com.artivisi.tiket.controller;

import com.artivisi.tiket.dao.BookingDao;
import com.artivisi.tiket.dao.SeatDao;
import com.artivisi.tiket.entity.Booking;
import com.artivisi.tiket.entity.Seat;
import com.artivisi.tiket.entity.AuditLog;
import com.artivisi.tiket.exception.DataTidakAdaException;
import com.artivisi.tiket.service.AuditLogService;


import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookingController {
    
    @Autowired private BookingDao bookingDao;
    @Autowired private SeatDao seatDao;
    @Autowired private AuditLogService auditLogService;
    
    @Transactional
    @RequestMapping(value="/booking", method=RequestMethod.POST)
    public void createBooking(@RequestBody @Valid Booking b){
        auditLogService.log(b.getNamaCustomer(), "Check Seat", 
            "Kereta "+b.getKereta().getId()+", kelas "+b.getKelas().getId());

        List<Seat> daftarSeatTersedia = 
            seatDao.findByKeretaIdAndKelasId(b.getKereta().getId(), 
            b.getKelas().getId());

        if(daftarSeatTersedia.isEmpty()){
            throw new DataTidakAdaException("Data seat tidak ada");
        }

        Seat s = daftarSeatTersedia.get(0);
        
        if(s.getJumlah() < b.getJumlah()){
            throw new DataTidakAdaException("Seat tidak cukup");
        }

        auditLogService.log(b.getNamaCustomer(), "Seat Tersedia", 
            "Jumlah : "+s.getJumlah());

        // set expire
        DateTime waktuBooking = new DateTime(b.getWaktuBooking());
        DateTime waktuExpire = waktuBooking.plusMinutes(3);
        b.setWaktuKadaluarsa(waktuExpire.toDate());

        bookingDao.save(b);
        s.setJumlah(s.getJumlah() - b.getJumlah());
        if(b.getKereta().getId().equals("aa")){
            auditLogService.log(b.getNamaCustomer(), "Booking Tiket", "Gagal");
            throw new IllegalStateException("Pura-puranya error");
        }
        seatDao.save(s);

        auditLogService.log(b.getNamaCustomer(), "Booking Tiket", "Sukses");
    }
}
