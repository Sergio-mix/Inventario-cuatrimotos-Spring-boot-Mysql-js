package co.edu.usa.Reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "score")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Score implements Serializable {

    @Id
    @Column(name = "idScord", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idScord;

    @Column(name = "qualification", length = 1)
    private Integer qualification ;

    @Column(name = "message", length = 250)
    private Integer message;

    @NonNull
    @OneToOne
    @JoinColumn(name = "idReservation")
    @JsonIgnoreProperties(value = "reservation")
    private Reservation reservation;

    public Score() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Score score = (Score) o;
        return Objects.equals(idScord, score.idScord);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
