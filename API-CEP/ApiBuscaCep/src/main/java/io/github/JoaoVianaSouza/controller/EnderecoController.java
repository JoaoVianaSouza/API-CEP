package io.github.JoaoVianaSouza.controller;

import io.github.JoaoVianaSouza.models.Endereco;
import io.github.JoaoVianaSouza.service.ConsumoApi;
import io.github.JoaoVianaSouza.service.InvalidCepException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cep")
public class EnderecoController {

    @Autowired
    private ConsumoApi consumoApi;

    @PostMapping("/cadastrar")
    public <T> ResponseEntity<T> cadastrarCep(@RequestParam String cep) {
        try {
            Endereco endereco = consumoApi.obterRequisicao(cep);
            if (endereco == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
            return ResponseEntity.ok((T) ("Dados Cadastrados: " + endereco.toString()));

        } catch (InvalidCepException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
