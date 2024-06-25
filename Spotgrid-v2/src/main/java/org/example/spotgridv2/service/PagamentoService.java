package org.example.spotgridv2.service;

import org.example.spotgridv2.model.Assinatura;
import org.example.spotgridv2.model.Pagamento;
import org.example.spotgridv2.repository.AssinaturaRepository;
import org.example.spotgridv2.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento save(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public Optional<Pagamento> findById(Long id) {
        return pagamentoRepository.findById(id);
    }
}