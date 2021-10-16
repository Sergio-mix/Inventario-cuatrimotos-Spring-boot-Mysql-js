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
    @Column(name = "brand", nullable = false, length = 45)
    private String brand;

    @NonNull
    @Column(name = "year", nullable = false)
    private Integer year;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties(value = "category")
    private Category category;

    @NonNull
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @NonNull
    @Column(name = "description", nullable = false, length = 250)
    private String description;


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
