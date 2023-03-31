package com.neoris.Cajero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.Cajero.entity.Cuenta;
import com.neoris.Cajero.entity.Movimiento;
import com.neoris.Cajero.repository.MovimientoRepository;

@Service
public class MovimientoService {
	@Autowired
	private MovimientoRepository movimientoRepository;
	@Autowired
	private CuentaService cuentaservice;

	public List<Movimiento> getAllMovimientos() {
		return movimientoRepository.findAll();
	}

	public Movimiento getMovimientoById(Long id) {
		return movimientoRepository.findById(id).orElse(null);
	}

	public Movimiento createMovimiento(Movimiento movimiento) {

		Cuenta cuenta = cuentaservice.getCuentaById((long) movimiento.getCuenta_id());
		if (cuenta != null) {
			if ((cuenta.getSaldoInicial() == 0 || cuenta.getSaldoInicial() + movimiento.getValor() >= 0 ) && movimiento.getTipoMovimiento().equals("débito")) {
				throw new RuntimeException("Saldo no disponible");
			}

			cuenta.setSaldoInicial(cuenta.getSaldoInicial() + movimiento.getValor());
			cuentaservice.updateCuenta((long) movimiento.getCuenta_id(), cuenta);
			movimiento.setSaldo(cuenta.getSaldoInicial());
		}
		return movimientoRepository.save(movimiento);
	}

	public Movimiento updateMovimiento(Long id, Movimiento movimiento) {
		Movimiento existingMovimiento = getMovimientoById(id);
		if (existingMovimiento != null) {
			existingMovimiento.setFecha(movimiento.getFecha());
			existingMovimiento.setTipoMovimiento(movimiento.getTipoMovimiento());
			existingMovimiento.setValor(movimiento.getValor());
			existingMovimiento.setSaldo(movimiento.getSaldo());
			return movimientoRepository.save(existingMovimiento);
		}
		return null;
	}

	public void deleteMovimiento(Long id) {
		movimientoRepository.deleteById(id);
	}
}