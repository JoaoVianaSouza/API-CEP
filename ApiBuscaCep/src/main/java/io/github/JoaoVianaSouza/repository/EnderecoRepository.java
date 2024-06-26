package io.github.JoaoVianaSouza.repository;

import io.github.JoaoVianaSouza.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
     Optional<Endereco> findByCep(String cep);
}
