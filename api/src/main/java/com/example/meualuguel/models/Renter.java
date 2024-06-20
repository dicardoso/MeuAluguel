package com.example.meualuguel.models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "renters")
@Entity(name = "renters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Renter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;
}