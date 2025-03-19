package com.example.duelocartas.servicio;

import java.util.List;

import com.example.duelocartas.dto.CartaDTO;

public interface ICartaServicio {
    CartaDTO crearCarta(CartaDTO carta);
    double calcularVentaja(CartaDTO cartaAtacante, CartaDTO cartaDefensora);
    CartaDTO obtenerCarta(Long id);
    List<CartaDTO> listarCartas();
    void eliminarCarta(Long id);
    CartaDTO actualizarCarta(Long id, CartaDTO cartaDTO);
}