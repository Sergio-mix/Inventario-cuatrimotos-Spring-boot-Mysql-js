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
@Table(name = "message")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Message implements Serializable {

    @Id
    @NonNull
    @Column(name = "idMessage", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessage;

    @NonNull
    @Column(name = "messageText", nullable = false, length = 250)
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "idQuadbike")
    @JsonIgnoreProperties({"messages","reservations"})
    private Quadbike quadbike;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;

    public Message() {

    }

    public Message(@NonNull Long idMessage) {
        this.idMessage = idMessage;
    }

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
