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

    public List<Assinatura> listarTodas() {
        return assinaturaRepository.findAll();
    }

    public Optional<Assinatura> buscarPorId(Long id) {
        return assinaturaRepository.findById(id);
    }

    public Assinatura salvar(Assinatura assinatura) {
        assinatura.setInicioVigencia(LocalDate.now());
        assinatura.setFimVigencia(LocalDate.now().plusDays(7));
        return assinaturaRepository.save(assinatura);
    }

    public void deletar(Long id) {
        assinaturaRepository.deleteById(id);
    }

    public List<Assinatura> listarPorCliente(Long clienteId) {
        return assinaturaRepository.findByClienteCodigo(clienteId);
    }

    public List<Assinatura> listarPorAplicativo(Long aplicativoId) {
        return assinaturaRepository.findByAplicativoCodigo(aplicativoId);
    }

    public List<Assinatura> listarAtivas() {
        return assinaturaRepository.findByFimVigenciaAfter(LocalDate.now());
    }

    public List<Assinatura> listarCanceladas() {
        return assinaturaRepository.findByFimVigenciaBefore(LocalDate.now());
    }

    public boolean isAssinaturaValida(Long clienteId, Long assinaturaId) {
        Optional<Assinatura> assinatura = assinaturaRepository.findById(assinaturaId);
        return assinatura.isPresent() &&
                assinatura.get().getCliente().getCodigo().equals(clienteId) &&
                assinatura.get().getFimVigencia().isAfter(LocalDate.now());
    }
}
