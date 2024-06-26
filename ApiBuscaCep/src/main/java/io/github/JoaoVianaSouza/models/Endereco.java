package io.github.JoaoVianaSouza.models;

import javax.persistence.*;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "cep")
    private String cep;

    @Column(name = "estado")
    private String state;

    @Column(name = "cidade")
    private String city;

    @Column(name = "bairro")
    private String neighborhood;

    @Column(name = "rua")
    private String street;

    @Column(name = "servico")
    private String service;

    @Override
    public String toString() {
        return "Endereco:  " +
                "id= " + id +
                ", cep= " + cep + '\'' +
                ", state= " + state + '\'' +
                ", city= " + city + '\'' +
                ", neighborhood= " + neighborhood + '\'' +
                ", street= " + street;
    }
}
