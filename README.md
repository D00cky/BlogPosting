# ☕ Blog API (Spring Boot)

> A robust backend system focused on data integrity, performance, and clean architecture.

## 📖 Overview

The **Blog API** is a RESTful application developed to manage a complete content platform. The project follows the **Layered Modular Monolith** pattern, ensuring a clear separation of responsibilities between Controllers, Services, and Repositories.

The development environment is **100% containerized**, using Docker to orchestrate the database and cache, facilitating setup on any machine ("Write once, run anywhere").

## 🛠️ Tech Stack

| Category | Technologies |
| --- | --- |
| **Core** | Java 21, Spring Boot 3.x, Maven |
| **Database** | PostgreSQL 16 (Primary Persistence) |
| **Cache/Performance** | Valkey (Redis Compatible) |
| **ORM & Migrations** | Spring Data JPA (Hibernate), Flyway |
| **DevOps** | Docker, Docker Compose |
| **Utils** | Lombok, Bean Validation, Spring DevTools |

---

## 🏗️ Architecture & Data

The system was designed with data model scalability in mind. Entities are related following a **Decoupling** logic, where the "Many" side (Child) holds the foreign key, allowing for optimized queries via Repository.

### Main Entities

* **👤 User:** Manages identity and access (`id`, `email`, `roles`).
* **📝 Post:** Textual content linked to an author (`title`, `content`, `user_id`).
* **💬 Comment:** User interactions on posts (`content`, `user_id`, `post_id`).

---

## 🚀 Project Roadmap

Below is the current development status, guided by phases.

### ✅ Phase 0: Foundation & Infrastructure

*Setting up the "Factory Floor" environment.*

* [x] Git Repository creation.
* [x] `docker-compose.yaml` configuration (Postgres + Valkey).
* [x] Spring Initializr project setup.
* [x] Health Check (Application running on port 8080).

### ✅ Phase 1: User Module (Identity)

*Who rules the system.*

* [x] Flyway V1: `users` and `roles` tables.
* [x] Creation of `User` and `Role` Entities.
* [x] Repository and Service with unique email validation.
* [x] Endpoints: `POST /users` and `GET /users/{id}`.

### ✅ Phase 2: Content & Relationships (Core)

*Linking authors to content.*

* [x] Flyway V2: `posts` table with FK.
* [x] `Post` Entity with `@ManyToOne` relationship.
* [x] "Link" Service: Fetch User -> Create Post.
* [x] Endpoint: `POST /posts`.

### 🚧 Phase 3: Interaction & Complexity (In Progress)

*Double relationships and business rules.*

* [x] Flyway V3: `comments` table.
* [x] `Comment` Entity (User + Post).
* [ ] Nested Endpoint: `POST /posts/{postId}/comments`.
* [ ] Integrity validations (Empty comment, nonexistent User).

### ⏳ Phase 4: Performance & Optimization (Future)

*Distributed caching.*

* [ ] Redis/Valkey configuration in Spring.
* [ ] Cache Strategy: `@Cacheable` on reads (`findAll`).
* [ ] Cache Eviction: `@CacheEvict` on writes (`save`).
