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

import com.neoris.Cajero.entity.Cuenta;
import com.neoris.Cajero.service.CuentaService;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllCuentas() {
        return ResponseEntity.ok(cuentaService.getAllCuentas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCuentaById(@PathVariable Long id) {
        return ResponseEntity.ok(cuentaService.getCuentaById(id));
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Object> createCuenta(@RequestBody Cuenta cuenta) {
        return ResponseEntity.ok(cuentaService.createCuenta(cuenta));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCuenta(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        return ResponseEntity.ok(cuentaService.updateCuenta(id, cuenta));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable Long id) {
        cuentaService.deleteCuenta(id);
        return ResponseEntity.ok().build();
    }
}
