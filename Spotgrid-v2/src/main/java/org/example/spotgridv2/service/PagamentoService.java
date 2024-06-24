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

    @Autowired
    private AssinaturaRepository assinaturaRepository;

    public List<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }

    public Optional<Pagamento> buscarPorId(Long id) {
        return pagamentoRepository.findById(id);
    }

    public Pagamento salvar(Pagamento pagamento) {
        Optional<Assinatura> assinatura = assinaturaRepository.findById(pagamento.getAssinatura().getCodigo());
        if (assinatura.isPresent()) {
            Assinatura ass = assinatura.get();
            if (pagamento.getValorPago() == ass.getAplicativo().getCustoMensal()) {
                if (pagamento.getPromocao().equals("none")) {
                    if (ass.getFimVigencia().isAfter(LocalDate.now())) {
                        ass.setFimVigencia(ass.getFimVigencia().plusDays(30));
                    } else {
                        ass.setFimVigencia(LocalDate.now().plusDays(30));
                    }
                } else if (pagamento.getPromocao().equals("annual")) {
                    ass.setFimVigencia(ass.getFimVigencia().plusDays(365));
                } else if (pagamento.getPromocao().equals("promo45")) {
                    ass.setFimVigencia(ass.getFimVigencia().plusDays(45));
                }
                assinaturaRepository.save(ass);
                pagamento.setDataPagamento(LocalDate.now());
                return pagamentoRepository.save(pagamento);
            } else {
                pagamento.setValorPago(0);
            }
        }
        return pagamento;
    }

    public void deletar(Long id) {
        pagamentoRepository.deleteById(id);
    }
}
