package org.example.spotgridv2.controller;

import org.example.spotgridv2.model.Assinatura;
import org.example.spotgridv2.service.AssinaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servcad/assinaturas")
public class AssinaturaController {

    @Autowired
    private AssinaturaService assinaturaService;

    @PostMapping
    public Assinatura createAssinatura(@RequestBody Assinatura assinatura) {
        return assinaturaService.save(assinatura);
    }

    @GetMapping("/{tipo}")
    public List<Assinatura> getAssinaturasByTipo(@PathVariable String tipo) {
        if (tipo.equals("TODAS")) {
            return assinaturaService.findAll();
        } else {
            return assinaturaService.findByStatus(tipo);
        }
    }

    @GetMapping("/asscli/{codcli}")
    public List<Assinatura> getAssinaturasByCliente(@PathVariable Long codcli) {
        return assinaturaService.findByCodigoCliente(codcli);
    }

    @GetMapping("/assapp/{codapp}")
    public List<Assinatura> getAssinaturasByAplicativo(@PathVariable Long codapp) {
        return assinaturaService.findByCodigoAplicativo(codapp);
    }
}
