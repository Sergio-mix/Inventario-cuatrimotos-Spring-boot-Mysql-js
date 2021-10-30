package co.edu.usa.inventario_cuatrimotos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "admin")
@Entity
@NonNull
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The name field must not be empty")
    @Column(name = "name", nullable = false, length = 250)
    private String name;

    @Email
    @NotEmpty(message = "The email field must not be empty")
    @Column(name = "email", nullable = false, length = 45, unique = true)
    private String email;

    @NotEmpty(message = "The password field must not be empty")
    @Column(name = "password", nullable = false, length = 250)
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Admin admin = (Admin) o;
        return Objects.equals(id, admin.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
