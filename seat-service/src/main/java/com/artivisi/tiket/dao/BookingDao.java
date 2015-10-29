
package com.artivisi.tiket.dao;

import com.artivisi.tiket.entity.Booking;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookingDao extends PagingAndSortingRepository<Booking, String>{

}
