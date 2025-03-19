package com.example.duelocartas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.duelocartas.entidades.Carta;

import java.util.List;

@Repository
public interface CartaRepositorio extends JpaRepository<Carta, Long> {
    List<Carta> findByCantidadDisponibleGreaterThan(Integer cantidad);
}
