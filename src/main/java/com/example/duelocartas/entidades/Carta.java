package com.example.duelocartas.entidades;

import com.example.duelocartas.modelo.TipoCarta;
import com.example.duelocartas.modelo.TipoMonstruo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Carta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private Integer ataque;
    private Integer defensa;
    private Integer cantidadDisponible = 3;
    private String descripcion;
    
    @Column(name = "imagen_url")
    private String imagenUrl;

    @Enumerated(EnumType.STRING)
    private TipoCarta tipoCarta;

    @Enumerated(EnumType.STRING)
    private TipoMonstruo tipoMonstruo;
}