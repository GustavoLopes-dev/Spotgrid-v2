package org.example.spotgridv2.repository;

import org.example.spotgridv2.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unused")
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
