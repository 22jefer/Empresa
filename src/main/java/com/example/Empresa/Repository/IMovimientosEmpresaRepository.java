package com.example.Empresa.Repository;

import com.example.Empresa.Entity.MovimientosEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovimientosEmpresaRepository extends JpaRepository<MovimientosEmpresa,Integer> {
}
