package com.bogus.carrental.database;

import com.bogus.carrental.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("Select distinct r from Reservation r where r.client.id=?1 ")
    List<Reservation> findAllByClientId(Long id);
}
