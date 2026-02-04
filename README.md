# ☕ Blog API (Spring Boot)

> Um sistema backend robusto focado em integridade de dados, performance e arquitetura limpa.

## 📖 Visão Geral

O **Blog API** é uma aplicação RESTful desenvolvida para gerenciar uma plataforma de conteúdo completa. O projeto segue o padrão de **Monolito Modular em Camadas**, garantindo uma separação clara de responsabilidades entre Controladores, Serviços e Repositórios.

O ambiente de desenvolvimento é **100% containerizado**, utilizando Docker para orquestrar o banco de dados e o cache, facilitando o setup em qualquer máquina ("Write once, run anywhere").

## 🛠️ Tech Stack

| Categoria | Tecnologias |
| --- | --- |
| **Core** | Java 21, Spring Boot 3.x, Maven |
| **Banco de Dados** | PostgreSQL 16 (Persistência Principal) |
| **Cache/Performance** | Valkey (Compatível com Redis) |
| **ORM & Migrations** | Spring Data JPA (Hibernate), Flyway |
| **DevOps** | Docker, Docker Compose |
| **Utils** | Lombok, Bean Validation, Spring DevTools |

---

## 🏗️ Arquitetura e Dados

O sistema foi desenhado pensando na escalabilidade do modelo de dados. As entidades se relacionam seguindo a lógica de **Desacoplamento**, onde o lado "Muitos" (Child) detém a chave estrangeira, permitindo consultas otimizadas via Repository.

### Entidades Principais

* **👤 User:** Gerencia identidade e acesso (`id`, `email`, `roles`).
* **📝 Post:** Conteúdo textual vinculado a um autor (`title`, `content`, `user_id`).
* **💬 Comment:** Interações dos usuários nos posts (`content`, `user_id`, `post_id`).

---

## 🚀 Roadmap do Projeto

Abaixo, o status atual do desenvolvimento guiado por fases.

### ✅ Fase 0: Alicerce & Infraestrutura

*Setup do ambiente "Chão de Fábrica".*

* [x] Criação do Repositório Git.
* [x] Configuração do `docker-compose.yaml` (Postgres + Valkey).
* [x] Setup do projeto no Spring Initializr.
* [x] Health Check (Aplicação rodando na porta 8080).

### ✅ Fase 1: Módulo de Usuários (Identity)

*Quem manda no sistema.*

* [x] Flyway V1: Tabelas `users` e `roles`.
* [x] Criação das Entidades `User` e `Role`.
* [x] Repository e Service com validação de email único.
* [x] Endpoints: `POST /users` e `GET /users/{id}`.

### ✅ Fase 2: Conteúdo & Relacionamentos (Core)

*Vinculando autores ao conteúdo.*

* [x] Flyway V2: Tabela `posts` com FK.
* [x] Entidade `Post` com relacionamento `@ManyToOne`.
* [x] Service "Link": Busca User -> Cria Post.
* [x] Endpoint: `POST /posts`.

### 🚧 Fase 3: Interação & Complexidade (Em Progresso)

*Relacionamentos duplos e regras de negócio.*

* [ ] Flyway V3: Tabela `comments`.
* [ ] Entidade `Comment` (User + Post).
* [ ] Endpoint Aninhado: `POST /posts/{postId}/comments`.
* [ ] Validações de integridade (Comentário vazio, User inexistente).

### ⏳ Fase 4: Performance & Otimização (Futuro)

*Cache distribuído.*

* [ ] Configuração do Redis/Valkey no Spring.
* [ ] Cache Strategy: `@Cacheable` em leituras (`findAll`).
* [ ] Cache Eviction: `@CacheEvict` em escritas (`save`).

