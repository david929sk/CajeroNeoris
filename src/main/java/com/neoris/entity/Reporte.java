package com.neoris.entity;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reporte {
    
	private Long clienteId;
    private Date fechaInicio;
    private Date fechaFin;
    private List<Cuenta> cuentas;
    private double totalDebitos;
    private double totalCreditos;
    
    public Reporte(Long clienteId2, java.util.Date fechaInicio2, java.util.Date fechaFin2, Optional<Cuenta> cuentas2,
			double totalDebitos2, double totalCreditos2) {
    	this.clienteId = clienteId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cuentas = cuentas;
        this.totalDebitos = totalDebitos;
        this.totalCreditos = totalCreditos;
	}
}