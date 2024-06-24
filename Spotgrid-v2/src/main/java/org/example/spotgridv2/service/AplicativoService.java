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

    public List<Aplicativo> listarTodos() {
        return aplicativoRepository.findAll();
    }

    public Optional<Aplicativo> buscarPorId(Long id) {
        return aplicativoRepository.findById(id);
    }

    public Aplicativo salvar(Aplicativo aplicativo) {
        return aplicativoRepository.save(aplicativo);
    }

    public void deletar(Long id) {
        aplicativoRepository.deleteById(id);
    }

    public Aplicativo atualizarCusto(Long id, double novoCusto) {
        Optional<Aplicativo> aplicativo = aplicativoRepository.findById(id);
        if (aplicativo.isPresent()) {
            Aplicativo app = aplicativo.get();
            app.setCustoMensal(novoCusto);
            return aplicativoRepository.save(app);
        }
        return null;
    }
}
