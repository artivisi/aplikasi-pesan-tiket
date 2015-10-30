
package com.artivisi.tiket.dao;

import com.artivisi.tiket.entity.Booking;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookingDao extends PagingAndSortingRepository<Booking, String>{

    public List<Booking> findByWaktuKadaluarsaLessThan(Date date);

}
