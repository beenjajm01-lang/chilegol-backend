package com.chilegol.chilegol.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "comuna")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComuna;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_region", nullable = false)
    private Region region;
}