package org.example.spotgridv2.repository;

import org.example.spotgridv2.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {
}
