package co.edu.usa.Reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
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
@Table(name = "client")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client implements Serializable {
    @Id
    @NonNull
    @Column(name = "idClient", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    @NonNull
    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @NonNull
    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @NonNull
    @Column(name = "name", nullable = false, length = 250)
    private String name;

    @NonNull
    @Column(name = "age", nullable = false)
    private Integer age;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    @ToString.Exclude
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    @ToString.Exclude
    private List<Reservation> reservations;

    public Client() {

    }

    public Client(@NonNull Long idClient) {
        this.idClient = idClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Client client = (Client) o;
        return Objects.equals(idClient, client.idClient);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
