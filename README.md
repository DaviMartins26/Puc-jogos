# PucJogos 🎮

Projeto acadêmico em Java com Spring Boot que simula o backend de uma plataforma de jogos, similar à Steam. A aplicação realiza operações de CRUD em 7 entidades inter-relacionadas, representando a lógica de usuários, jogos, transações, reviews e conquistas.

## 📁 Entidades do Sistema

### 1. `Usuario`
- Campos: `id`, `nome`, `email`
- Relacionamentos:
  - Pode ter muitos jogos na **Biblioteca**
  - Pode ter muitas **Conquistas**
  - Pode escrever **Reviews**
  - Pode realizar **Transações**
  - Pode ter **Amigos**

### 2. `Jogo`
- Campos: `id`, `nome`, `descricao`, `preco`
- Relacionamentos:
  - Presente em várias **Bibliotecas**
  - Pode ter várias **Reviews**
  - Pode estar presente em várias **Transações**
  - Pode ter várias **Conquistas**

### 3. `Biblioteca`
- Representa os jogos que um usuário possui.
- Relacionamentos: muitos para um com `Usuario` e `Jogo`.

### 4. `Review`
- Avaliação textual de um jogo por um usuário.
- Campos: `comentario`, `nota`
- Relacionamentos: um `Usuario` e um `Jogo`.

### 5. `Amigos`
- Relaciona dois usuários como amigos (auto-relacionamento).
- Campos: `usuario`, `amigo`

### 6. `Conquista`
- Representa uma conquista desbloqueada por um usuário em um jogo.
- Campos: `descricao`
- Relacionamentos: um `Usuario`, um `Jogo`.

### 7. `Transacao`
- Registro de compra de um jogo por um usuário.
- Campos: `data`, `valor`
- Relacionamentos: um `Usuario`, um `Jogo`.

---

## ⚙️ Funcionalidades (via `main()`)

- ✅ Criação, leitura, atualização e exclusão (CRUD) de todas as 7 entidades.
- ✅ Relacionamentos populados diretamente no console, simulando uso real.
- ✅ Utilização de `Optional` com verificações seguras.
- ✅ Operações encadeadas para testar relacionamentos.
- ✅ Impressões de verificação no console (`System.out.println()`).

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database (para testes locais)
- Maven

---

