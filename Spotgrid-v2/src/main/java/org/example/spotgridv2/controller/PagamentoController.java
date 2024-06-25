package org.example.spotgridv2.controller;

import org.example.spotgridv2.model.Pagamento;
import org.example.spotgridv2.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/servcad")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/registrarpagamento")
    public ResponseEntity<Pagamento> registerPagamento(@RequestBody Pagamento pagamento) {
        return ResponseEntity.ok(pagamentoService.save(pagamento));
    }

    @GetMapping("/assinvalida/{codass}")
    public ResponseEntity<Boolean> isAssinaturaValida(@PathVariable Long codass) {
        Optional<Pagamento> pagamento = pagamentoService.findById(codass);
        return ResponseEntity.ok(pagamento.isPresent());
    }
}