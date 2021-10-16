package co.edu.usa.Reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "reservation")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reservation implements Serializable {

    @Id
    @NonNull
    @Column(name = "idReservation", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @NonNull
    @Column(name = "startDate", nullable = false)
    private String startDate;

    @NonNull
    @Column(name = "devolutionDate", nullable = false)
    private String devolutionDate;

    @Column(name = "status")
    private String status;

    @NonNull
    @OneToOne
    @JoinColumn(name = "idScord")
    @JsonIgnoreProperties(value = "score")
    private Score score;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;

    @ManyToOne
    @JoinColumn(name = "idQuadbike")
    @JsonIgnoreProperties({"messages","reservations"})
    private Quadbike quadbike;

    public Reservation() {

    }

    public Reservation(@NonNull Long idReservation) {
        this.idReservation = idReservation;
    }

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
