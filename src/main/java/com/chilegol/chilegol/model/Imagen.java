package com.chilegol.chilegol.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "imagen")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImagen;

    @NotBlank
    @Column(nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    @JsonBackReference
    private Producto producto;
}