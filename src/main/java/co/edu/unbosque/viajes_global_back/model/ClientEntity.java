package co.edu.unbosque.viajes_global_back.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_client;
    private String email;
    private String user;
    private String telephone;
    private String password;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clientEntity", cascade = CascadeType.ALL)
    private Set<BookingEntity> bookingEntities;
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private NotificationChoiceEntity notificationChoiceEntity;
    public ClientEntity() {

    }

    public ClientEntity(int id_client, String email, String user, String telephone, String password, Set<BookingEntity> bookingEntities, NotificationChoiceEntity notificationChoiceEntity) {
        this.id_client = id_client;
        this.email = email;
        this.user = user;
        this.telephone = telephone;
        this.password = password;
        this.bookingEntities = bookingEntities;
        this.notificationChoiceEntity = notificationChoiceEntity;
    }
}