package org.example.spotgridv2.controller;

import org.example.spotgridv2.model.Aplicativo;
import org.example.spotgridv2.service.AplicativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servcad/aplicativos")
public class AplicativoController {

    @Autowired
    private AplicativoService aplicativoService;

    @GetMapping
    public List<Aplicativo> getAllAplicativos() {
        return aplicativoService.findAll();
    }

    @PostMapping("/atualizacusto/{idAplicativo}")
    public ResponseEntity<Aplicativo> updateCusto(@PathVariable Long idAplicativo, @RequestBody Aplicativo aplicativoDetails) {
        Optional<Aplicativo> aplicativo = aplicativoService.findById(idAplicativo);
        if (aplicativo.isPresent()) {
            Aplicativo updatedAplicativo = aplicativo.get();
            updatedAplicativo.setCustoMensal(aplicativoDetails.getCustoMensal());
            return ResponseEntity.ok(aplicativoService.save(updatedAplicativo));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
