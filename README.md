# Sunergizer-api-mvc

Projeto de api full mvc para a global solution.

## Integrantes

### Leonardo Cordeiro Scotti- RM550769

### Gabriel de Andrade Baltazar- RM550870

### Enzo Ross Gallone- RM551754

### Vinicius de Araujo Camargo- RM99494

### Pedro Gomes Fernandes- RM551480


## Tecnologias

- [Java 21](https://docs.oracle.com/en/java/javase/21/)
- [GraalVM](https://www.graalvm.org/)
- [Gradle](https://gradle.org/)
- [Thymeleaf](https://www.thymeleaf.org/index.html)
- [Spring Boot 3.3.2](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://docs.spring.io/spring-data/jpa/reference/)
- [Spring Web Starter](https://docs.spring.io/spring-boot/reference/web/index.html)
- [Spring Validation Starter](https://docs.spring.io/spring-framework/reference/core/validation/beanvalidation.html)
- [Spring HATEOAS](https://docs.spring.io/spring-hateoas/docs/current/reference/html/)
- [Springdoc OpenAPI + Swagger](https://springdoc.org/)
- [Spring Security](https://docs.spring.io/spring-security/reference/index.html)
- [JWT](https://jwt.io/introduction)
- [Spring AI](https://spring.io/projects/spring-ai)
- [H2 Database](http://h2database.com/html/main.html)
- [REST](https://ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm)
- [DTO](https://martinfowler.com/eaaCatalog/dataTransferObject.html)

## Ferramentas

- [IntelliJ](https://www.jetbrains.com/pt-br/idea/)
- [Postman](https://www.postman.com/)

- ## API Reference e endpoints

- #### Obter todos os clientes 

```http
  GET /clientes
```

#### Obter cliente por id 

```http
  GET /clientes/${id}
```

| Parâmetro | Tipo   | Descrição                                    |
|:----------|:-------|:---------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id do cliente a ser buscado |

- #### Criar cliente 

```http
  POST /clientes
```

Body:

```json
{
    "nome": "João da Silva",
    "email": "joao.silva@example.com",
    "endereco": "Rua das Flores, 123",
    "dataCadastro": "2024-11-18T14:30:00"
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `nome`    | `String` | Nome do cliente a ser criado   |
| `email`   | `String` | E-mail do cliente a ser criado |
| `endereco`   | `String` | Endereço do cliente a ser criado  |
| `dataCadastro` | `LocalDateTime` | Data de cadastro do cliente a ser criado |

- #### Atualizar cliente 

```http
  PUT /clientes/${id}
```

| Parâmetro | Tipo   | Descrição                                       |
|:----------|:-------|:------------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id do cliente a ser atualizado |

Body:

```json
{
    "nome": "João da Silva",
    "email": "joao.silva@example.com",
    "endereco": "Rua das Flores, 123",
    "dataCadastro": "2024-11-18T14:30:00"
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `nome`    | `String` | Nome do cliente a ser atualizado   |
| `email`   | `String` | E-mail do cliente a ser atualizado |
| `endereco`   | `String` | Endereço do cliente a ser atualizado  |
| `dataCadastro` | `LocalDateTime` | Data de cadastro do cliente a ser atualizado |


- #### Excluir cliente 

```http
  DELETE /clientes/${id}
```

| Parâmetro | Tipo   | Descrição                                     |
|:----------|:-------|:----------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id do cliente a ser excluído |



- #### Obter todas as fontes de energia

```http
  GET /fontes
```

- #### Obter fonte de energia por id 

```http
  GET /fontes/${id}
```

| Parâmetro | Tipo   | Descrição                                    |
|:----------|:-------|:---------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da fonte de energia a ser buscada |

- #### Criar fonte de energia

```http
  POST /fontes
```

Body:

```json
{
     "tipo": "Painéis solares",
     "descricao": "Parque de painéis solares"
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `tipo`   | `String` | Tipo da fonte de energia a ser criada  |
| `descricao` | `String` | Descrição da fonte de energia a ser criada |

- #### Atualizar fonte de energia

```http
  PUT /fontes/${id}
```

| Parâmetro | Tipo   | Descrição                                       |
|:----------|:-------|:------------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da fonte a ser atualizada |

Body:

```json
{
     "tipo": "Painéis solares",
     "descricao": "Parque de painéis solares"
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `tipo`   | `String` | Tipo da fonte de energia a ser atualizada  |
| `descricao` | `String` | Descrição da fonte de energia a ser atualizada |


- #### Excluir fonte de energia

```http
  DELETE /fontes/${id}
```

| Parâmetro | Tipo   | Descrição                                     |
|:----------|:-------|:----------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da fonte a ser excluída |


- #### Obter todas as comunidades 

```http
  GET /comunidades
```

#### Obter comunidade por id 

```http
  GET /comunidades/${id}
```

| Parâmetro | Tipo   | Descrição                                    |
|:----------|:-------|:---------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da comunidade a ser buscada |

- #### Criar comunidade 

```http
  POST /comunidades
```

Body:

```json
{
    "nome": "Comunidade solar",
    "cidade": "São Paulo",
    "uf": "SP",
    "totalPessoas": 10
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `nome`    | `String` | Nome da comunidade a ser criada   |
| `cidade`   | `String` | Cidade da comunidade a ser criada |
| `uf`   | `String` | UF (unidade federativa) da comunidade a ser criada  |
| `totalPessoas` | `int` | Numero total de pessoas da comunidade a ser criada |

- #### Atualizar comunidade 

```http
  PUT /comunidades/${id}
```

| Parâmetro | Tipo   | Descrição                                       |
|:----------|:-------|:------------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da comunidade a ser atualizada |

Body:

```json
{
    "nome": "Comunidade solar",
    "cidade": "São Paulo",
    "uf": "SP",
    "totalPessoas": 10
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `nome`    | `String` | Nome da comunidade a ser atualizada   |
| `cidade`   | `String` | Cidade da comunidade a ser atualizada |
| `uf`   | `String` | UF (unidade federativa) da comunidade a ser atualizada  |
| `totalPessoas` | `int` | Numero total de pessoas da comunidade a ser atualizada |

- #### Excluir comunidade 

```http
  DELETE /comunidades/${id}
```

| Parâmetro | Tipo   | Descrição                                     |
|:----------|:-------|:----------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da comunidade a ser excluída |


- #### Obter todas os consumos 

```http
  GET /consumos
```

#### Obter consumo por id 

```http
  GET /consumos/${id}
```

| Parâmetro | Tipo   | Descrição                                    |
|:----------|:-------|:---------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id do consumo a ser buscado |

- #### Criar consumos 

```http
  POST /consumos
```

Body:

```json
{
    "idCliente": 2,
    "idFonte": 1,
    "dataRegistro": "2024-11-18T14:30:00",
    "kwhConsumidos": 200
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `idCliente`    | `Long` | id do cliente do consumo correspondente a ser criado   |
| `idFonte`   | `Long` | id da fonte de energia do consumo correspondente a ser criado |
| `dataRegistro`   | `LocalDateTime` | Data de registro do consumo a ser criado  |
| `kwhConsumidos` | `int` | kWh consumidos do consumo a ser criado |

- #### Atualizar consumo 

```http
  PUT /consumos/${id}
```

| Parâmetro | Tipo   | Descrição                                       |
|:----------|:-------|:------------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id do consumo a ser atualizado |

Body:

```json
{
    "idCliente": 2,
    "idFonte": 1,
    "dataRegistro": "2024-11-18T14:30:00",
    "kwhConsumidos": 200
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `idCliente`    | `Long` | id do cliente do consumo correspondente a ser atualizado   |
| `idFonte`   | `Long` | id da fonte de energia do consumo correspondente a ser atualizado |
| `dataRegistro`   | `LocalDateTime` | Data de registro do consumo a ser atualizado  |
| `kwhConsumidos` | `int` | kWh consumidos do consumo a ser atualizado |

- #### Excluir consumo 

```http
  DELETE /consumos/${id}
```

| Parâmetro | Tipo   | Descrição                                     |
|:----------|:-------|:----------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id do consumo a ser excluído |


## Link do vídeo explicativo do projeto

https://www.youtube.com/watch?v=cO6uMpZ8n6g


## Link do vídeo da apresentação PITCH

https://www.youtube.com/watch?v=PIyj0vSl3zk
