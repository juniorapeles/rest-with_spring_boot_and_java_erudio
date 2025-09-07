# Rest with Spring Boot and Java - Curso Completo

> Aprenda Spring Boot, Swagger, Docker, Kubernetes, JWT, JUnit 5, Mockito e React JS do 0 à AWS e GCP.

---

## Funcionalidades

* APIs RESTful com operações matemáticas (`sum`, `sub`, `mul`, `div`, `sqrt`, `average`)
* Validação de entradas
* Tratamento global de exceções
* Documentação Swagger `/swagger-ui.html`
* Testes unitários com JUnit 5 e Mockito
* Autenticação JWT
* Front-end React consumindo APIs
* Deploy em Docker, Kubernetes, AWS e GCP

---

## Tecnologias

* Java 21 + Spring Boot 3
* React JS
* H2/PostgreSQL
* Docker & Docker Compose
* Kubernetes
* JWT, JUnit 5, Mockito
* AWS / GCP

---

## Rodando o Projeto

```bash
# Clone
git clone git@github.com:SEU_USUARIO/projeto-spring-boot.git
cd projeto-spring-boot

# Back-end
mvn spring-boot:run

# Front-end
cd frontend
npm install
npm start
```

Swagger: `http://localhost:8080/swagger-ui.html`
Testes: `mvn test`

---

## Estrutura

```
src
├─ main/java/.../controller
├─ main/java/.../service
├─ main/java/.../validator
├─ main/java/.../exception
├─ main/java/.../commons
└─ resources/application.yml
```

---

## Contribuição

Issues e pull requests são bem-vindos.

---

## Licença

MIT
