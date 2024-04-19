package com.grngenterprise.tutodiorestkafka.controller;

import com.grngenterprise.tutodiorestkafka.entity.Pedido;
import com.grngenterprise.tutodiorestkafka.service.RegistraEventoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidosController {
    private final RegistraEventoService eventoService;
    public PedidosController(RegistraEventoService eventoService) {
        this.eventoService = eventoService;
    }
    @PostMapping(path = "/api/pedido")
    public ResponseEntity<String> SalvarPedido(@RequestBody Pedido pedido){
        eventoService.adicionarEvento("SalvarPedido", pedido);
        return ResponseEntity.ok("Sucess");
    }
}
