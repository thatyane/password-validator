# password-validator

Serviço resposável por validar uma senha com as seguintes regras:
- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
    - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto
- Não possuir espaços em branco

## Stack

* **Java 17**
* **Spring Boot 2.7**
* **Gradle 7.4.1**
* **Junit 5**
* **Mockito**
* **OpenAPI 3**
* **Swagger 3**
* **JUnit 5**

## Executar a aplicação

```bash
./gradlew bootRun
```
### Executar os testes

#### Testes de unidade
```bash
./gradlew test
```
#### Testes de integração
```bash
./gradlew integrationTest
```

## Documentação da API

http://localhost:8080/swagger-ui/index.html#

## Sobre

#### Linguagem de programção, frameworks e bibliotecas
Para o desenvolvimento, utilizei a linguagem de programação Java com o framework Spring. Optei por fazer as validações das regras com expressão regular, de forma isolada para garantir a coesão e o desacoplamento. 

Utilizei o padrão de projeto chain of responsabilty, para reduzir o acoplamento, dando ainda flexibilidade adicional na atribuição de novas regras.

Adicionei logs durante o processo para ajudar em futuros debugs e a biblioteca do lombok foi utilizada para reduzir linhas de código.

#### Documentação técnica
Para documentação técnica, utilizei o Swagger que dispõe de uma interface para testes do recurso, além do yaml com o contrato para facilitar integrações.

#### Premissas
* Não ficou claro se a senha deveria ter um limite máximo de caracteres, portanto, decidi deixa-la com o tamanho máximo de uma string.
