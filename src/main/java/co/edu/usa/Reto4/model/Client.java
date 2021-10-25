package co.edu.usa.Reto4.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
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

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idClient", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    @Email
    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @NotEmpty(message = "The password field must not be empty")
    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @NotEmpty(message = "The name field must not be empty")
    @Column(name = "name", nullable = false, length = 250)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    @ToString.Exclude
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    @ToString.Exclude
    private List<Reservation> reservations;

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
