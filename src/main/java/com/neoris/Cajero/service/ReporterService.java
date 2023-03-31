package com.neoris.Cajero.service;


import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.Cajero.entity.Cuenta;
import com.neoris.Cajero.entity.Reporte;
import com.neoris.Cajero.repository.ClienteRepository;
import com.neoris.Cajero.repository.CuentaRepository;
import com.neoris.Cajero.repository.MovimientoRepository;

@Service
public class ReporterService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    public Reporte getReporte(Long clienteId, Date fechaInicio, Date fechaFin) {
        if (clienteId == null) {
            throw new IllegalArgumentException("El ID del cliente es requerido");
        }
        if (fechaInicio == null || fechaFin == null) {
            throw new IllegalArgumentException("El rango de fechas es requerido");
        }
        if (fechaInicio.after(fechaFin)) {
            throw new IllegalArgumentException("La fecha de inicio debe ser anterior a la fecha de fin");
        }
        if (!clienteRepository.existsById(clienteId)) {
            throw new IllegalArgumentException("El cliente con el ID especificado no existe");
        }

        Optional<Cuenta> cuentas = cuentaRepository.findById(clienteId);
        double totalDebitos = 0;
        double totalCreditos = 0;
	/*	for (Cuenta cuenta : cuentas) {
			List<Movimiento> movimientos = movimientoRepository.findByCuentaIdAndFechaBetween(cuenta.getId(),
					fechaInicio, fechaFin);
			for (Movimiento movimiento : movimientos) {
				if (movimiento.getTipoMovimiento().equals("debito")) {
					totalDebitos += movimiento.getValor();
				} else if (movimiento.getTipoMovimiento().equals("credito")) {
					totalCreditos += movimiento.getValor();
				}
			}
		}
		*/
        return new Reporte(clienteId, fechaInicio, fechaFin, cuentas, totalDebitos, totalCreditos);
    }
}