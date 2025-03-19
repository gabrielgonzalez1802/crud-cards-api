package com.example.duelocartas.servicio;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.duelocartas.dto.CartaDTO;
import com.example.duelocartas.entidades.Carta;
import com.example.duelocartas.modelo.TipoCarta;
import com.example.duelocartas.repositorio.CartaRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CartaServicioImpl implements ICartaServicio {

    @Autowired
    private CartaRepositorio cartaRepositorio;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CartaDTO crearCarta(CartaDTO carta) {
        if (carta.getCantidadDisponible() == null) {
            carta.setCantidadDisponible(3); // Por defecto, 3 copias de cada carta
        }
        
        Carta cartaEntity = modelMapper.map(carta, Carta.class);
        
        cartaEntity = cartaRepositorio.save(cartaEntity);
        
        return modelMapper.map(cartaEntity, CartaDTO.class);
    }
    
    @Override
    public CartaDTO actualizarCarta(Long id, CartaDTO cartaDTO) {
        Carta carta = cartaRepositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carta no encontrada con ID: " + id));

        modelMapper.map(cartaDTO, carta);
        carta = cartaRepositorio.save(carta);

        return modelMapper.map(carta, CartaDTO.class);
    }

    @Override
    public double calcularVentaja(CartaDTO cartaAtacante, CartaDTO cartaDefensora) {
        // Solo aplicar ventajas si ambas son cartas de monstruo
        if (cartaAtacante.getTipoCarta() != TipoCarta.CRIATURA || 
            cartaDefensora.getTipoCarta() != TipoCarta.CRIATURA) {
            return 1.0;
        }

        // Ventajas basadas en el tipo de monstruo
        return switch (cartaAtacante.getTipoMonstruo()) {
            case FUEGO -> switch (cartaDefensora.getTipoMonstruo()) {
                case TIERRA -> 1.5; // Fuego es fuerte contra Tierra
                case AGUA -> 0.5;   // Fuego es débil contra Agua
                default -> 1.0;
            };
            case AGUA -> switch (cartaDefensora.getTipoMonstruo()) {
                case FUEGO -> 1.5;  // Agua es fuerte contra Fuego
                case TIERRA -> 0.5; // Agua es débil contra Tierra
                default -> 1.0;
            };
            case TIERRA -> switch (cartaDefensora.getTipoMonstruo()) {
                case AGUA -> 1.5;   // Tierra es fuerte contra Agua
                case FUEGO -> 0.5;  // Tierra es débil contra Fuego
                default -> 1.0;
            };
            case LUZ -> switch (cartaDefensora.getTipoMonstruo()) {
                case OSCURIDAD -> 1.5; // Luz es fuerte contra Oscuridad
                default -> 1.0;
            };
            case OSCURIDAD -> switch (cartaDefensora.getTipoMonstruo()) {
                case LUZ -> 1.5;    // Oscuridad es fuerte contra Luz
                default -> 1.0;
            };
            case DRAGON -> 1.2;     // Los dragones tienen ventaja general
            default -> 1.0;
        };
    }

    @Override
    public CartaDTO obtenerCarta(Long id) {
        Carta carta = cartaRepositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carta no encontrada con ID: " + id));
        return modelMapper.map(carta, CartaDTO.class);
    }

    @Override
    public List<CartaDTO> listarCartas() {
        return cartaRepositorio.findAll().stream()
                .map(carta -> modelMapper.map(carta, CartaDTO.class))
                .toList();
    }

    public void eliminarCarta(Long id) {
        if (!cartaRepositorio.existsById(id)) {
            throw new EntityNotFoundException("Carta no encontrada con ID: " + id);
        }
        cartaRepositorio.deleteById(id);
    }
}
