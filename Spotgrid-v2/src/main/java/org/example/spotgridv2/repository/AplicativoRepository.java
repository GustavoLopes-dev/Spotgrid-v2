package org.example.spotgridv2.repository;

import org.example.spotgridv2.model.Aplicativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface AplicativoRepository extends CrudRepository<Aplicativo, Long> {
}
