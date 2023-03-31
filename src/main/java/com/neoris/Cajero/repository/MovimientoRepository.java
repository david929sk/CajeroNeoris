package com.neoris.Cajero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neoris.Cajero.entity.Movimiento;


@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
}
