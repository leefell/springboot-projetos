# Cadastro de Ninjas

Uma API REST para gerenciar o cadastro de ninjas e suas missões, desenvolvida com Spring Boot.

## Descrição

Este projeto consiste em uma API para realizar operações de CRUD (Criar, Ler, Atualizar e Deletar) para entidades de Ninjas e Missões. A aplicação utiliza um banco de dados em memória (H2) para persistência dos dados e Flyway para o versionamento do banco.

## Tecnologias Utilizadas

- **Java 17**: Versão da linguagem Java utilizada.
- **Spring Boot 3**: Framework principal para a construção da aplicação.
- **Spring Web**: Para a criação de APIs REST.
- **Spring Data JPA**: Para a persistência de dados.
- **Maven**: Gerenciador de dependências e build do projeto.
- **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
- **Flyway**: Ferramenta para versionamento e migração de banco de dados.
- **Lombok**: Biblioteca para reduzir código boilerplate (getters, setters, construtores).
- **Springdoc OpenAPI (Swagger)**: Para documentação interativa da API.
- **Validation**: Para validação dos dados de entrada.

## Estrutura do Projeto

O projeto está organizado nos seguintes pacotes principais:
- `dev.leefell.CadastroDeNinjas`: Raiz da aplicação.
- `Ninjas`: Contém o Controller, Service, Repository, Model e DTO para a entidade Ninja.
- `Missoes`: Contém o Controller, Service, Repository, Model e DTO para a entidade Missão.
- `Exceptions`: Contém o handler para tratamento de exceções globais.

## Endpoints da API

A URL base da API é `http://localhost:8080`.

### Ninjas (`/ninjas`)

- **GET /**: Lista todos os ninjas cadastrados.
- **GET /{id}**: Busca um ninja pelo ID.
- **POST /**: Cria um novo ninja.
- **PATCH /{id}**: Atualiza os dados de um ninja existente.
- **DELETE /{id}**: Deleta um ninja pelo ID.
- **GET /status**: Verifica o status da API.

### Missões (`/missoes`)

- **GET /**: Lista todas as missões.
- **GET /{id}**: Busca uma missão pelo ID.
- **POST /**: Cria uma nova missão.
- **PATCH /{id}**: Atualiza os dados de uma missão existente.
- **DELETE /{id}**: Deleta uma missão pelo ID.

## Interface do Usuário (UI)

A aplicação também oferece uma interface de usuário simples baseada em Thymeleaf para gerenciamento dos ninjas.

Os endpoints da UI para ninjas são acessíveis através da base `/ninjas/ui`:

- **GET /ninjas/ui/listar**: Exibe uma lista de todos os ninjas e permite acesso rápido às ações de adicionar, editar e deletar.
- **GET /ninjas/ui/adicionar**: Apresenta um formulário para adicionar um novo ninja.
- **POST /ninjas/ui/salvar**: Salva um novo ninja (redireciona para a listagem).
- **GET /ninjas/ui/editar/{id}**: Exibe um formulário preenchido para editar um ninja existente.
- **POST /ninjas/ui/atualizar/{id}**: Atualiza os dados de um ninja (redireciona para a listagem).
- **GET /ninjas/ui/deletar/{id}**: Deleta um ninja (redireciona para a listagem).

## Como Executar

1.  **Pré-requisitos**:
    - JDK 17 ou superior.
    - Maven 3.8 ou superior.

2.  **Clone o repositório:**
    ```bash
    git clone https://github.com/leefell/springboot-projetos
    cd CadastroDeNinjas
    ```

3.  **Configuração de Ambiente:**
    A aplicação utiliza variáveis de ambiente para configurar a conexão com o banco de dados. Crie um arquivo `.env` na raiz do projeto, utilizando o `.env.example` como referência.
    ```bash
    # Exemplo de conteúdo para o arquivo .env
    DATABASE_URL=jdbc:h2:mem:testdb
    DATABASE_USERNAME=sa
    DATABASE_PASSWORD=
    ```

4.  **Execute a aplicação com o Maven Wrapper:**
    - No Windows:
      ```bash
      ./mvnw spring-boot:run
      ```
    - No Linux/macOS:
      ```bash
      ./mvnw spring-boot:run
      ```
A aplicação estará disponível em `http://localhost:8080`.

## Banco de Dados

A aplicação utiliza o banco de dados em memória H2. O console do H2 pode ser acessado em `http://localhost:8080/h2-console` após iniciar a aplicação.

- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (deixe em branco)

As migrações do banco de dados são gerenciadas pelo Flyway e os scripts se encontram em `src/main/resources/db/migrations`.

## Documentação da API (Swagger)

A documentação interativa da API, gerada com o Springdoc OpenAPI, está disponível em:

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`

Nesta interface, é possível visualizar todos os endpoints, seus parâmetros, e testá-los diretamente.
