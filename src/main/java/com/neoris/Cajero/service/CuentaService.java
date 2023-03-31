package com.neoris.Cajero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.Cajero.entity.Cuenta;
import com.neoris.Cajero.repository.CuentaRepository;

import java.util.List;

@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }

    public Cuenta getCuentaById(Long id) {
        return cuentaRepository.findById(id).orElse(null);
    }

    public Cuenta createCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Cuenta updateCuenta(Long id, Cuenta cuenta) {
        Cuenta existingCuenta = getCuentaById(id);
        if (existingCuenta != null) {
            existingCuenta.setNumeroCuenta(cuenta.getNumeroCuenta());
            existingCuenta.setTipoCuenta(cuenta.getTipoCuenta());
            existingCuenta.setSaldoInicial(cuenta.getSaldoInicial());
            existingCuenta.setEstado(cuenta.getEstado());
            return cuentaRepository.save(existingCuenta);
        }
        return null;
    }

    public void deleteCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }
}
