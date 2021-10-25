package co.edu.usa.Reto4.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "reservation")
@Entity
@NonNull
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idReservation", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @Column(name = "startDate", nullable = false)
    private String startDate;

    @Column(name = "devolutionDate", nullable = false)
    private String devolutionDate;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "idQuadbike", nullable = false)
    @JsonIgnoreProperties(value = {"reservations", "client"})
    private Quadbike quadbike;

    @ManyToOne
    @JoinColumn(name = "idClient", nullable = false)
    @JsonIgnoreProperties(value = {"messages", "reservations"})
    private Client client;

    @Column(name = "score")
    private String score;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(idReservation, that.idReservation);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
