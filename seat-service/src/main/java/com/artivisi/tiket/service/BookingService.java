package com.artivisi.tiket.service;

import com.artivisi.tiket.dao.BookingDao;
import com.artivisi.tiket.entity.Booking;
import com.artivisi.tiket.entity.StatusBooking;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookingService {
    
    @Autowired private BookingDao bookingDao;
    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    @Scheduled(fixedDelay = 3000) 
    public void cekBookingKadaluarsa(){
        logger.debug("[CHECK BOOKING EXPIRY]");
        List<Booking> yangKadaluarsa = 
            bookingDao.findByWaktuKadaluarsaLessThan(new Date());

        logger.debug("[FOUND {} EXPIRED BOOKING]", yangKadaluarsa.size());

        for(Booking b : yangKadaluarsa){
            b.setStatus(StatusBooking.KADALUARSA);
            bookingDao.save(b);
        }

        logger.debug("[{} BOOKING EXPIRED]", yangKadaluarsa.size());

    }
}
