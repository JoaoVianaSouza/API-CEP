# 🌍 BuscaCEP API

A BuscaCEP API é uma aplicação em Java que permite consultar e cadastrar informações de endereços a partir de um serviço de API externo.

## 🔍 Funcionalidades

- **Consulta e Cadastro de CEP**: Permite consultar informações de endereço a partir de um CEP fornecido. Os dados do endereço são obtidos de uma API externa e salvos no banco de dados da aplicação.

- **Restrições**:
  - A aplicação não permite cadastrar o mesmo CEP mais de uma vez.
  - CEPs inválidos não são salvos no banco de dados.

## 🛠️ Tecnologias Utilizadas

- Java 1.8
- Spring Boot
- Spring Data JPA
- OkHttp
- Gson
- Banco de dados SQL Server 2017
- DBeaver

## ⚙️ Como Usar

### 🛠️ Configuração

1. Clone o repositório.
2. Configure as propriedades do banco de dados no arquivo `application.properties`.

### ▶️ Execução

1. Compile o projeto e execute a classe `BuscaCepApplication`.
2. Acesse a API através da URL base `http://localhost:8080/api/cep`.

## 🚀 Desenvolvimento

Este projeto utiliza Spring Boot para facilitar o desenvolvimento de APIs RESTful e integração com bancos de dados usando Spring Data JPA.

## 📚 Tabela Explicativa das Classes

| Classe            | Descrição                                                                 |
|-------------------|---------------------------------------------------------------------------|
| EnderecoController | Controlador REST que gerencia as requisições relacionadas aos endereços.   |
| Endereco          | Modelo de dados que representa um endereço, persistido no banco de dados. |
| EnderecoRepository| Interface que estende JpaRepository para operações de banco de dados.     |
| ConsumoApi         | Serviço responsável por consumir a API externa e persistir os dados.       |
| InvalidCepException| Exceção personalizada para tratar erros de CEP inválido.                  |
| BuscaCepApplication| Classe principal que inicia a aplicação Spring Boot.                       |

## 🌐 Conecte-se comigo

Para saber mais sobre meus estudos e projetos em Java e POO, você pode me encontrar no [LinkedIn](https://www.linkedin.com/in/joao-pedro-gon%C3%A7alves-viana-de-souza-a33a84242/).
