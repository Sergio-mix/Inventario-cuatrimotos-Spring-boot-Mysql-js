package co.edu.usa.inventario_cuatrimotos.repositories.jpa;

import co.edu.usa.inventario_cuatrimotos.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ReservationJpaRepository extends JpaRepository<Reservation, Long> {

     List<Reservation> findAllByStatus(String status);

     List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    @Query ("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();


}
