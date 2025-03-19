package com.example.duelocartas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.duelocartas.dto.CartaDTO;
import com.example.duelocartas.servicio.ICartaServicio;

@RestController
@RequestMapping("/api/cartas")
public class CartaControlador {

	@Autowired
	private ICartaServicio cartaServicio;

	@GetMapping
	public ResponseEntity<List<CartaDTO>> listarCartas() {
		return ResponseEntity.ok(cartaServicio.listarCartas());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CartaDTO> obtenerCarta(@PathVariable Long id) {
		return ResponseEntity.ok(cartaServicio.obtenerCarta(id));
	}

	@PostMapping
	public ResponseEntity<CartaDTO> crearCarta(@RequestBody CartaDTO cartaDTO) {
		return ResponseEntity.ok(cartaServicio.crearCarta(cartaDTO));
	}

	@PutMapping("/{id}")
	public ResponseEntity<CartaDTO> actualizarCarta(@PathVariable Long id, @RequestBody CartaDTO cartaDTO) {
		return ResponseEntity.ok(cartaServicio.actualizarCarta(id, cartaDTO));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarCarta(@PathVariable Long id) {
		cartaServicio.eliminarCarta(id);
		return ResponseEntity.ok().build();
	}
}
