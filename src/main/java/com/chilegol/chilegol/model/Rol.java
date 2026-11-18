package com.chilegol.chilegol.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "rol")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String nombre; // ADMIN, VENDEDOR, CLIENTE
}
