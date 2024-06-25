package org.example.spotgridv2.service;

import org.example.spotgridv2.model.Aplicativo;
import org.example.spotgridv2.repository.AplicativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
@Service
public class AplicativoService {

    @Autowired
    private AplicativoRepository aplicativoRepository;

    public List<Aplicativo> findAll() {
        return (List<Aplicativo>) aplicativoRepository.findAll();
    }

    public Aplicativo save(Aplicativo aplicativo) {
        return aplicativoRepository.save(aplicativo);
    }

    public Optional<Aplicativo> findById(Long id) {
        return aplicativoRepository.findById(id);
    }

    public Optional<Aplicativo> updateCusto(Long id, double novoCustoMensal) {
        Optional<Aplicativo> optionalAplicativo = aplicativoRepository.findById(id);
        if (optionalAplicativo.isPresent()) {
            Aplicativo aplicativo = optionalAplicativo.get();
            aplicativo.setCustoMensal(novoCustoMensal);
            return Optional.of(aplicativoRepository.save(aplicativo));
        }
        return Optional.empty();
    }
}