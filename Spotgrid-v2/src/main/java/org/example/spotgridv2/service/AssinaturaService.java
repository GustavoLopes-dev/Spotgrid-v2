package org.example.spotgridv2.service;

import org.example.spotgridv2.model.Assinatura;
import org.example.spotgridv2.repository.AssinaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
@Service
public class AssinaturaService {

    @Autowired
    private AssinaturaRepository assinaturaRepository;

    public Assinatura save(Assinatura assinatura) {
        return assinaturaRepository.save(assinatura);
    }

    public List<Assinatura> findAll() {
        return assinaturaRepository.findAll();
    }

    public Optional<Assinatura> findById(Long id) {
        return assinaturaRepository.findById(id);
    }

    public List<Assinatura> findByStatus(String status) {
        return assinaturaRepository.findByStatus(status);
    }

    public List<Assinatura> findByCodigoCliente(Long codigoCliente) {
        return assinaturaRepository.findByClienteCodigo(codigoCliente);
    }

    public List<Assinatura> findByCodigoAplicativo(Long codigoAplicativo) {
        return assinaturaRepository.findByAplicativoCodigo(codigoAplicativo);
    }
}
