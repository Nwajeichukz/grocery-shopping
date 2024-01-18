package customer.com.ginikascustomers.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kamara_customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_email", nullable = false, unique = true)
    private String email;

    @Column(name = "state", nullable = false)
    private String state;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Country country;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Bought> bought;


    @ManyToOne(cascade = CascadeType.PERSIST)
    private Role roles;
}