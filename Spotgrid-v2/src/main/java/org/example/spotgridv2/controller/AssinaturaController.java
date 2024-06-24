package org.example.spotgridv2.controller;

import org.example.spotgridv2.model.Assinatura;
import org.example.spotgridv2.service.AssinaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/assinaturas")
public class AssinaturaController {

    @Autowired
    private AssinaturaService assinaturaService;

    @GetMapping
    public List<Assinatura> listarTodas() {
        return assinaturaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assinatura> buscarPorId(@PathVariable Long id) {
        Optional<Assinatura> assinatura = assinaturaService.buscarPorId(id);
        if (assinatura.isPresent()) {
            return ResponseEntity.ok(assinatura.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Assinatura criarAssinatura(@RequestBody Assinatura assinatura) {
        return assinaturaService.salvar(assinatura);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAssinatura(@PathVariable Long id) {
        assinaturaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Assinatura> listarPorCliente(@PathVariable Long clienteId) {
        return assinaturaService.listarPorCliente(clienteId);
    }

    @GetMapping("/aplicativo/{aplicativoId}")
    public List<Assinatura> listarPorAplicativo(@PathVariable Long aplicativoId) {
        return assinaturaService.listarPorAplicativo(aplicativoId);
    }

    @GetMapping("/validas")
    public List<Assinatura> listarAtivas() {
        return assinaturaService.listarAtivas();
    }

    @GetMapping("/canceladas")
    public List<Assinatura> listarCanceladas() {
        return assinaturaService.listarCanceladas();
    }

    @GetMapping("/valida")
    public ResponseEntity<Boolean> isAssinaturaValida(
            @RequestParam Long clienteId, @RequestParam Long assinaturaId) {
        boolean valida = assinaturaService.isAssinaturaValida(clienteId, assinaturaId);
        return ResponseEntity.ok(valida);
    }
}
