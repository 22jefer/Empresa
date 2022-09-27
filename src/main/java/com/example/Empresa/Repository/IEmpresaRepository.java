package com.example.Empresa.Repository;

import com.example.Empresa.Entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface IEmpresaRepository extends JpaRepository<Empresa,Integer> {
}
