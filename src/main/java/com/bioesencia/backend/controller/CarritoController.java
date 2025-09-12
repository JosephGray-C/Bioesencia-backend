package com.bioesencia.backend.controller;

import com.bioesencia.backend.model.CarritoItem;
import com.bioesencia.backend.service.CarritoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrito")
@RequiredArgsConstructor
public class CarritoController {

    private final CarritoService carritoService;
    
    @PostMapping("/agregar")
    public ResponseEntity<CarritoItem> agregarItem(@RequestParam Long usuarioId,@RequestParam Long productoId,@RequestParam int cantidad) {
        CarritoItem nuevo = carritoService.agregarItem(usuarioId, productoId, cantidad);
        return ResponseEntity.ok(nuevo);
    }
    
    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<CarritoItem>> obtenerPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(carritoService.listarPorUsuario(usuarioId));
    }

    @DeleteMapping("/eliminar/{itemId}")
    public ResponseEntity<Void> eliminarItem(@PathVariable Long itemId) {
        boolean eliminado = carritoService.eliminarItem(itemId);
        if (eliminado) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/limpiar/{usuarioId}")
    public ResponseEntity<Void> limpiarCarrito(@PathVariable Long usuarioId) {
        boolean eliminado = carritoService.limpiarPorUsuario(usuarioId);
        if(eliminado){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
