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

## Run

```bash
./gradlew bootRun
```

## Documentation

http://localhost:8080/swagger-ui/index.html#

## Stack

* **Java 17**
* **Spring Boot 2.7.0**
* **Gradle 7.4.1**
* **Junit 5**
* **Mockito**
* **OpenAPI 3**
* **Swagger 3**
* **JUnit 5**