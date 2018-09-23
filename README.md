# x-gene

API para encontrar genes mutantes em uma matrix de DNA

## Getting Started

Para executar o projeto local execute os comandos:
Criar imagem docker
```
  make build
```
Criar o container e subir a aplicação
```
  make run
```

A aplicação ficará exposta na porta 8081

### Prerequisites

Docker
Java 8
Maven

## Running the tests

```
mvn test
```

### And coding style tests

Testes unitários na camada de negócio e conecxão com banco de dados.
89% de cobertura desconsiderando classes de domain, json e exception.

![coverage](./doc/images/coverage.png)

## Authors

* **Bruno Rodrigues**
