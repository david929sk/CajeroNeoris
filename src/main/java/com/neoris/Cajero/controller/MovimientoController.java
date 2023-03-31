package com.neoris.Cajero.controller;
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

import com.neoris.Cajero.entity.Movimiento;
import com.neoris.Cajero.service.MovimientoService;


@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllMovimientos() {
        return ResponseEntity.ok(movimientoService.getAllMovimientos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getMovimientoById(@PathVariable Long id) {
        return ResponseEntity.ok(movimientoService.getMovimientoById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createMovimiento(@RequestBody Movimiento movimiento) {
        return ResponseEntity.ok(movimientoService.createMovimiento(movimiento));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateMovimiento(@PathVariable Long id, @RequestBody Movimiento movimiento) {
        return ResponseEntity.ok(movimientoService.updateMovimiento(id, movimiento));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable Long id) {
        movimientoService.deleteMovimiento(id);
        return ResponseEntity.ok().build();
    }
}