package com.example.meualuguel.models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "owners")
@Entity(name = "owners")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;
}