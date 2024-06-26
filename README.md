# 📦 Projeto de Consulta e Gerenciamento de Endereços por CEP

Este projeto é uma aplicação Spring Boot que permite consultar, cadastrar, excluir e listar endereços a partir de um CEP fornecido. Utiliza uma API externa para obter as informações do endereço e armazena essas informações em um banco de dados relacional.

## ✨ Funcionalidades

- **Consulta de Endereço**: Consulta um endereço a partir de um CEP fornecido e retorna as informações detalhadas.
- **Cadastro de Endereço**: Cadastra um novo endereço no banco de dados a partir de um CEP fornecido.
- **Exclusão de Endereço**: Exclui um endereço cadastrado no banco de dados a partir de um CEP fornecido.

## 🚀 Como Usar

### Pré-requisitos

- Java 11 ou superior
- Maven
- Banco de dados configurado (neste caso, SQL Server)

### Configuração

1. Clone o repositório:
    ```sh
    git clone https://github.com/seu-usuario/seu-repositorio.git
    ```
2. Configure o banco de dados no arquivo `application.properties`:
    ```properties
    spring.datasource.url=jdbc:sqlserver://localhost;databaseName=ApiConsultaCep
    spring.datasource.username=seu-usuario
    spring.datasource.password=sua-senha
    spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServerDialect

    logging.file.name=app.log
    logging.level.root=INFO
    ```

### Executando a Aplicação

1. Navegue até o diretório do projeto:
    ```sh
    cd seu-repositorio
    ```
2. Execute o projeto utilizando Maven:
    ```sh
    mvn spring-boot:run
    ```

### Endpoints

#### Consultar Endereço

- **URL**: `/api/cep/consultar`
- **Método**: `POST`
- **Parâmetros**: `cep` (String)
- **Descrição**: Consulta um endereço pelo CEP fornecido.

#### Cadastrar Endereço

- **URL**: `/api/cep/cadastrar`
- **Método**: `POST`
- **Parâmetros**: `cep` (String)
- **Descrição**: Cadastra um novo endereço no banco de dados.

#### Excluir Endereço

- **URL**: `/api/cep/excluir`
- **Método**: `DELETE`
- **Parâmetros**: `cep` (String)
- **Descrição**: Exclui um endereço do banco de dados pelo CEP fornecido.

## 📂 Estrutura do Projeto

| Classe                | Função                                                                 |
|-----------------------|------------------------------------------------------------------------|
| `EnderecoController`  | Controlador REST para gerenciar os endpoints de consulta, cadastro, exclusão e listagem de endereços. |
| `Endereco`            | Modelo de dados para representar um endereço.                                           |
| `EnderecoRepository`  | Repositório JPA para realizar operações de banco de dados com o modelo `Endereco`.        |
| `ConsumoApi`          | Serviço para consumir a API externa e obter informações de endereço a partir de um CEP.  |
| `InvalidCepException` | Exceção personalizada para tratar CEPs inválidos.                                       |
| `BuscaCepApplication` | Classe principal para iniciar a aplicação Spring Boot.                                  |

## 🌐 Conecte-se comigo

Para saber mais sobre meus estudos e projetos em Java e POO, você pode me encontrar no [LinkedIn](https://www.linkedin.com/in/joao-pedro-gon%C3%A7alves-viana-de-souza-a33a84242/).

