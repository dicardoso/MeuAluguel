package com.example.meualuguel.models;

import com.example.meualuguel.dtos.user.UserUpdateDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String registry;
    private String email;
    private String phone;
    private String address;
    private String password;
    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;
    private Boolean is_active;
}
