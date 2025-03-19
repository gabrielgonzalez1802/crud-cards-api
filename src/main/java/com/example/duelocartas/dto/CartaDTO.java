package com.example.duelocartas.dto;

import com.example.duelocartas.modelo.TipoCarta;
import com.example.duelocartas.modelo.TipoMonstruo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CartaDTO {
	
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    @NotNull(message = "El ataque no puede ser nulo")
    @Min(value = 0, message = "El ataque no puede ser menor que 0")
    private Integer ataque;

    @NotNull(message = "La defensa no puede ser nula")
    @Min(value = 0, message = "La defensa no puede ser menor que 0")
    private Integer defensa;

    @NotNull(message = "La cantidad disponible no puede ser nula")
    @Min(value = 0, message = "La cantidad disponible no puede ser menor que 0")
    private Integer cantidadDisponible;

    @NotBlank(message = "La URL de la imagen no puede estar vacía")
    private String imagenUrl;

    @NotNull(message = "El tipo de carta no puede ser nulo")
    private TipoCarta tipoCarta;

    @NotNull(message = "El tipo de monstruo no puede ser nulo")
    private TipoMonstruo tipoMonstruo;
}