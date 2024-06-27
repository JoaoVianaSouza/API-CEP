package io.github.JoaoVianaSouza.controller;

import io.github.JoaoVianaSouza.models.Endereco;
import io.github.JoaoVianaSouza.repository.EnderecoRepository;
import io.github.JoaoVianaSouza.service.ConsumoApi;
import io.github.JoaoVianaSouza.service.InvalidCepException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cep")
public class EnderecoController {

    @Autowired
    private ConsumoApi consumoApi;

    @Autowired
    private EnderecoRepository enderecoRepository;


    @PostMapping("/cadastrar")
    public ResponseEntity<String> incluirCep(@RequestParam String cep) {
        Optional<Endereco> cepExistente = enderecoRepository.findByCep(cep);
        if (cepExistente.isPresent()){
            return ResponseEntity.ok("[AVISO] Endereço com o CEP " + cep + " já está cadastrado");
        } else {
            try {
                Endereco endereco = consumoApi.obterRequisicao(cep);
                return ResponseEntity.ok("Endereço cadastrado com sucesso!" + "\n" + endereco.toString());
            } catch (InvalidCepException e) {
                return ResponseEntity.badRequest().body("[ERRO] CEP inválido: " + cep);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("[ERRO] Não foi possível estabelecer conexão com a API");
            }
        }
    }


    @PostMapping("/excluir")
    public ResponseEntity<String> excluirCep(@RequestParam String cep) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findByCep(cep);
        if (enderecoOptional.isPresent()){
            enderecoRepository.delete(enderecoOptional.get());
            return ResponseEntity.ok("Endereço com o CEP " + cep + " excluido com sucesso");

        } return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado");
    }

    @PostMapping("/consultar")
    public ResponseEntity<String> consultarCep(@RequestParam String cep) {
        Optional<Endereco> enderecoDeConsulta = enderecoRepository.findByCep(cep);
        if (enderecoDeConsulta.isPresent()){
            Endereco endereco = enderecoDeConsulta.get();
            return ResponseEntity.ok("Endereço encontrado!!" + "\n" + endereco.toString());
        } return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado");
    }

    @PostMapping("/listar")
    public ResponseEntity<String> listarCep(){
        List<Endereco> listaDeEndereco= enderecoRepository.findAll();
        if(listaDeEndereco.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("[ERRO] Nenhum CEP cadastrado");
        } listaDeEndereco.forEach(System.out::println);
        return ResponseEntity.ok(listaDeEndereco.toString());
    }

}
