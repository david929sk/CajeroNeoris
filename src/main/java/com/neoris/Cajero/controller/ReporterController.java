package com.neoris.Cajero.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neoris.Cajero.service.ReporterService;


@RestController
@RequestMapping("/reportes")
public class ReporterController {
    @Autowired
    private ReporterService reporteService;

    @GetMapping
    public ResponseEntity<Object> getReporte(
            @RequestParam Long clienteId,
            @RequestParam Date fechaInicio,
            @RequestParam Date fechaFin) {
        return ResponseEntity.ok(reporteService.getReporte(clienteId, fechaInicio, fechaFin));
    }
}

