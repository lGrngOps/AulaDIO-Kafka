package com.grngenterprise.tutodiomicroservicekafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grngenterprise.tutodiomicroservicekafka.entity.Pedido;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Slf4j
@Service
public class SalvarPedidoService {
    @KafkaListener(topics = "SalvarPedido", groupId = "MicroservicoSalvaPedido")
    private void executar(ConsumerRecord<String, String> record){

        log.info("Chave =  {}", record.key());
        log.info("Cabecalho = {}", record.headers());
        log.info("Particao = {}", record.partition());

        String strDados = record.value();

        ObjectMapper mapper = new ObjectMapper();
        Pedido pedido;

        try {
            pedido = mapper.readValue(strDados, Pedido.class);
        } catch (JsonProcessingException e) {
            log.error("Falha converter evento [dado={}]",strDados,e);
            return;
        }
        log.info("Evento recebido ={}", pedido);
    }
}
