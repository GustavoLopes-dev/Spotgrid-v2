package org.example.spotgridv2.repository;


import org.example.spotgridv2.model.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("unused")
@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {
    List<Assinatura> findByClienteCodigo(Long clienteId);
    List<Assinatura> findByAplicativoCodigo(Long aplicativoId);
    List<Assinatura> findByFimVigenciaAfter(LocalDate date);
    List<Assinatura> findByFimVigenciaBefore(LocalDate date);
}
