package com.chilegol.chilegol.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "metodo_envio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetodoEnvio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMetodoEnvio;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String nombre;

    @NotNull
    @Column(nullable = false)
    private Integer costo;
}