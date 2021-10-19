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
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "quadbike")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Quadbike implements Serializable {

    @Id
    @NonNull
    @Column(name = "idQuadbike", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @NonNull
    @Column(name = "brand", nullable = false, length = 45)
    private String brand;

    @NonNull
    @Column(name = "year", nullable = false)
    private Integer year;

    @NonNull
    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties(value = "quadbikes")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "quadbike")
    @JsonIgnoreProperties(value = {"quadbike", "client"})
    @ToString.Exclude
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "quadbike")
    @JsonIgnoreProperties(value = {"quadbike"})
    @ToString.Exclude
    private List<Reservation> reservations;


    public Quadbike() {

    }

    public Quadbike(@NonNull Long idQuadbike) {
        this.id = idQuadbike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Quadbike quadBike = (Quadbike) o;
        return Objects.equals(id, quadBike.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
