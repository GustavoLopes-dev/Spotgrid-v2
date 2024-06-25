package org.example.spotgridv2.repository;


import org.example.spotgridv2.model.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("unused")
@Repository
public interface AssinaturaRepository extends CrudRepository<Assinatura, Long> {
    List<Assinatura> findByClienteCodigo(Long codigoCliente);
    List<Assinatura> findByAplicativoCodigo(Long codigoAplicativo);
    List<Assinatura> findByStatus(String status);
}
