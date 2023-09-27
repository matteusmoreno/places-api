# Place API

Este é um projeto de exemplo de uma API de lugares (places) usando Spring Boot e MySQL.

## Tecnologias Utilizadas

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.4-brightgreen)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8-blue)](https://www.mysql.com/)
[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)
[![Lombok](https://img.shields.io/badge/Lombok-1.18.22-blue)](https://projectlombok.org/)
[![Hibernate](https://img.shields.io/badge/Hibernate-5.5.6-green)](https://hibernate.org/)
[![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-2.5.5-brightgreen)](https://spring.io/projects/spring-data-jpa)

## Configuração do Banco de Dados

A aplicação está configurada para usar um banco de dados MySQL. Certifique-se de ter o MySQL instalado e configurado corretamente em sua máquina. As configurações do banco de dados podem ser encontradas no arquivo "application.properties".

spring.datasource.url=jdbc:mysql://localhost/places_api?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=Davi3498#

## Executando a Aplicação

Você pode executar a aplicação usando o comando Maven:

mvn spring-boot:run

A API estará disponível em "http://localhost:8080/place".

## Endpoints

### Criar um lugar

- Método: POST
- URL: /place
- Corpo da Requisição:
  {
  "name": "Nome do Lugar",
  "city": "Nome da Cidade",
  "state": "UF"
  }
- Exemplo de Resposta:
  {
  "id": 1,
  "name": "Nome do Lugar",
  "city": "Nome da Cidade",
  "state": "UF",
  "createdAt": "2023-09-27T10:00:00",
  "updatedAt": null,
  "status": true
  }

### Listar lugares

- Método: GET
- URL: /place
- Parâmetros de Paginação Opcionais:
    - page (Página desejada, padrão: 0)
    - size (Tamanho da página, padrão: 10)
- Exemplo de Resposta:
  {
  "content": [
  {
  "name": "Nome do Lugar 1",
  "city": "Cidade 1",
  "state": "UF"
  },
  {
  "name": "Nome do Lugar 2",
  "city": "Cidade 2",
  "state": "UF"
  }
  ],
  "totalElements": 2,
  "totalPages": 1,
  "number": 0,
  "size": 10
  }

### Detalhes de um lugar

- Método: GET
- URL: /place/{id}
- Exemplo de Resposta:
  {
  "id": 1,
  "name": "Nome do Lugar",
  "city": "Nome da Cidade",
  "state": "UF",
  "createdAt": "2023-09-27T10:00:00",
  "updatedAt": null,
  "status": true
  }

### Atualizar um lugar

- Método: PUT
- URL: /place
- Corpo da Requisição (somente campos que deseja atualizar):
  {
  "id": 1,
  "name": "Novo Nome do Lugar",
  "city": "Nova Cidade",
  "state": "Nova UF"
  }
- Exemplo de Resposta:
  {
  "id": 1,
  "name": "Novo Nome do Lugar",
  "city": "Nova Cidade",
  "state": "Nova UF",
  "createdAt": "2023-09-27T10:00:00",
  "updatedAt": "2023-09-27T11:00:00",
  "status": true
  }

### Desativar um lugar

- Método: DELETE
- URL: /place/{id}
- Resposta de Sucesso: HTTP 204 No Content
