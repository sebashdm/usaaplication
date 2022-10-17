package com.example.demo.Interface;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.Modelo.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;


public interface ReservationInterface extends CrudRepository<Reservation, Integer> {

    public List<Reservation> findAllByStatus (String status);

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore (Date datoUno, Date datoDos);

    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationByClient();

}