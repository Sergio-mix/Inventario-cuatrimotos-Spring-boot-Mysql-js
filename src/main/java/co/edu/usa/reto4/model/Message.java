package co.edu.usa.reto4.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "message")
@Entity
@NonNull
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idMessage", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessage;

    @NotEmpty(message = "The messageText field must not be empty")
    @Column(name = "messageText", nullable = false, length = 250)
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "idQuadbike", nullable = false)
    @JsonIgnoreProperties({"messages", "reservations"})
    private Quadbike quadbike;

    @ManyToOne
    @JoinColumn(name = "idClient", nullable = false)
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Message message = (Message) o;
        return Objects.equals(idMessage, message.idMessage);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
