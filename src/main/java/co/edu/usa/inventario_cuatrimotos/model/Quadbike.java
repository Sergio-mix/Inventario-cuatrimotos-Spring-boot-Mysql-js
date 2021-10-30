package co.edu.usa.inventario_cuatrimotos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "quadbike")
@Entity
@NonNull
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Quadbike implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idQuadbike", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The name field must not be empty")
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @NotEmpty(message = "The brand field must not be empty")
    @Column(name = "brand", nullable = false, length = 45)
    private String brand;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "description", length = 250)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties(value = "quadbikes")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "quadbike")
    @JsonIgnoreProperties(value = {"quadbike", "client"})
    @ToString.Exclude
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "quadbike")
    @JsonIgnoreProperties(value = {"quadbike"})
    @ToString.Exclude
    private List<Reservation> reservations;

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
