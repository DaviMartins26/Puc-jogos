package PucJogos;

import java.util.Scanner;

import PucJogos.model.*;
import PucJogos.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JogosApplication implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private AmigosRepository amigosRepository;

    @Autowired
    private ConquistaRepository conquistaRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;


    public static void main(String[] args) {

        SpringApplication.run(JogosApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== CRUD de Usuario ===");

        // CREATE
        Usuario novoUsuario = new Usuario("Adilson", "Adilson@gmail.com", "123", 50.0f);
        Usuario userDelete = new Usuario("Jurandir","jurandir@email.com","321",2050.0f);
        usuarioRepository.save(novoUsuario);
        usuarioRepository.save(userDelete);
        System.out.println("Usuário criado: " + novoUsuario.getUserId());
        System.out.println("Usuário criado: " + userDelete.getUserId());

        // READ
        List<Usuario> usuarios = usuarioRepository.findAll();
        System.out.println("Lista de usuários:");
        for (Usuario u : usuarios) {
            System.out.println(u.getUserId() + " - " + u.getNome() + " - " + u.getEmail());
        }

     //   pausar(scanner);

        // UPDATE
        Optional<Usuario> usuarioUpdate = usuarioRepository.findById(novoUsuario.getUserId());
        if (usuarioUpdate.isPresent()) {
            Usuario updateUser = usuarioUpdate.get();
            updateUser.setSaldo(250.0f);
            usuarioRepository.save(updateUser);
            System.out.println("Usuário atualizado: " + updateUser.getUserId() + " - novo saldo: " + updateUser.getSaldo());
        }

     //   pausar(scanner);

        System.out.println("\n=== CRUD de Jogo ===");

        //Create
        Jogo novoJogo1 = new Jogo("Dark Souls", "FromSoftware", 199.99f);
        Jogo novoJogo2 = new Jogo("Mario 64 4k", "Nintendo", 500.00f);
        jogoRepository.save(novoJogo1);
        jogoRepository.save(novoJogo2);

        //Querry
        List<Jogo> jogos = jogoRepository.findAll();
        System.out.println("Jogos no DataBase");
        for (Jogo j : jogos) {
            System.out.println(j.getJogoId() + " - " + j.getTitulo());
        }

     //   pausar(scanner);

        //Update
        Optional<Jogo> jogoOptional = jogoRepository.findById(novoJogo1.getJogoId());
        if (jogoOptional.isPresent()) {
            Jogo jogo1 = jogoOptional.get();
            jogo1.setPreco(149.99f);
            jogoRepository.save(jogo1);
            System.out.println("Preço atualizado: " + jogo1.getJogoId() + " - novo Preço: " + jogo1.getPreco());
        }

       // pausar(scanner);

        System.out.println("\n=== CRUD de Biblioteca ===");

        //  CREATE
        Biblioteca novaBiblioteca = new Biblioteca(novoUsuario, novoJogo1, 12, new Date());
        Biblioteca deleteBiblioteca = new Biblioteca(novoUsuario,novoJogo2,8001,new Date());
        bibliotecaRepository.save(novaBiblioteca);
        bibliotecaRepository.save(deleteBiblioteca);
        System.out.println("Bibliotecas Criadas");

        // READ
        List<Biblioteca> bibliotecas = bibliotecaRepository.findAll();
        for (Biblioteca b1 : bibliotecas) {
            System.out.println("Usuário: " + b1.getUsuario().getNome() +
                    " - Jogo: " + b1.getJogo().getTitulo() +
                    " - Horas: " + b1.getHorasJogadas());
        }

        pausar(scanner);

        // UPDATE
        Optional<Biblioteca> bOptional = bibliotecaRepository.findById(novaBiblioteca.getBibliotecaId());
        if (bOptional.isPresent()) {
            Biblioteca b2 = bOptional.get();
            b2.setHorasJogadas(25);
            bibliotecaRepository.save(b2);
        }

        pausar(scanner);

        System.out.println("\n=== CRUD de Review ===");

        //Criar
        //Pegando Instancias de objetos dentro do banco
        Usuario usuarioReview = usuarioRepository.findById(1).orElse(null);
        Jogo jogoReview = jogoRepository.findById(1).orElse(null);


        // teste pq tada dando erro
        if (usuarioReview != null && jogoReview != null) {
            Review novaReview = new Review(usuarioReview, jogoReview, 8, true);
            reviewRepo.save(novaReview);
            System.out.println("Review criada com ID: " + novaReview.getReviewId());
        }
        Review novaReview2 = new Review(usuarioReview, jogoReview, 8, true);
        reviewRepo.save(novaReview2);
        System.out.println("Review criada com ID: " + novaReview2.getReviewId());

        // READ
        System.out.println("Listando todas as reviews:");
        for (Review r : reviewRepo.findAll()) {
            System.out.println("ID: " + r.getReviewId() +
                    " | Usuario: " + r.getUsuario().getNome() +
                    " | Jogo: " + r.getJogo().getTitulo() +
                    " | Nota: " + r.getNota() +
                    " | Recomenda: " + r.isRecomenda());
        }

       // pausar(scanner);

        //UPDATE
        Review reviewExistente = reviewRepo.findById(1).orElse(null);
        reviewExistente.setNota(10);
        reviewExistente.setRecomenda(false);
        reviewRepo.save(reviewExistente);
        System.out.println("Review atualizada com sucesso.");


        pausar(scanner);

        System.out.println("\n=== CRUD de Amigos ===");

        // --- CRIAR AMIZADE ENTRE USUÁRIOS ---
        Usuario usuarioAmigo1 = usuarioRepository.findById(1).orElse(null);
        Usuario usuarioAmigo2 = usuarioRepository.findById(2).orElse(null);

        Amigos amizade = new Amigos(usuarioAmigo1, usuarioAmigo2, true); // Aceita
        amigosRepository.save(amizade);
        System.out.println("Amizade criada entre " + usuarioAmigo1.getNome() + " e " + usuarioAmigo2.getNome());


        // --- LER TODAS AS AMIZADES ---
        System.out.println("Lista de amizades:");
        for (Amigos a : amigosRepository.findAll()) {
            System.out.println("ID: " + a.getAmizadeId() + " | De: " + a.getUser1().getNome() + " -> Para: " + a.getUser2().getNome() + " | Status: " + (a.isStatus() ? "Aceito" : "Recusado"));
        }

        pausar(scanner);

        // --- UPDATE: alterar status de uma amizade ---
        Amigos amizadeExistente = amigosRepository.findById(1).orElse(null);
        if (amizadeExistente != null) {
            amizadeExistente.setStatus(false); // Recusar
            amigosRepository.save(amizadeExistente);
            System.out.println("Amizade ID 1 foi atualizada para recusada.");
        }

        pausar(scanner);

        System.out.println("\n=== CRUD de Conquista ===");

        // --- CRIAR CONQUISTA ---
        Usuario userConquista = usuarioRepository.findById(1).orElse(null);
        Jogo JogoConquista = jogoRepository.findById(1).orElse(null);

        Conquista c = new Conquista("Explorador Mestre", "Descobriu todas as áreas secretas", userConquista, JogoConquista);
        Conquista c2 = new Conquista("Ao Resgate", "Resgatou todos os personagens", userConquista, JogoConquista);
        conquistaRepository.save(c);
        System.out.println("Conquista criada para " + userConquista.getNome());
        conquistaRepository.save(c2);
        System.out.println("Conquista criada para " + userConquista.getNome());


        // --- LISTAR CONQUISTAS ---
        System.out.println("Conquistas cadastradas:");
        for (Conquista conquista : conquistaRepository.findAll()) {
            System.out.println("ID: " + c.getIdConquista() + " | " + c.getNome() +
                    " - " + conquista.getDescricao() +
                    " | Usuário: " + c.getUsuario().getNome() +
                    " | Jogo: " + conquista.getJogo().getTitulo());
        }

        pausar(scanner);

        // --- UPDATE CONQUISTA ---
        Conquista cUpdate = conquistaRepository.findById(1).orElse(null);
        if (cUpdate != null) {
            cUpdate.setDescricao("Descobriu 100% do mapa e áreas ocultas");
            conquistaRepository.save(cUpdate);
            System.out.println("Conquista atualizada.");
        }

        pausar(scanner);

        System.out.println("\n=== CRUD de Transacao ===");

        // --- CRIAR TRANSACAO ---
        Usuario userTransacao = usuarioRepository.findById(1).orElse(null);
        Jogo jogoTransacao = jogoRepository.findById(1).orElse(null);
        Biblioteca BiblioTransacao = bibliotecaRepository.findById(1).orElse(null);

        if (userTransacao != null && jogoTransacao != null && BiblioTransacao != null) {
            Transacao t = new Transacao("COMPRA", "2025-06-05", userTransacao, jogoTransacao, BiblioTransacao);
            transacaoRepository.save(t);
            System.out.println("Transação criada.");
        }

        pausar(scanner);

        // --- LISTAR TRANSACOES ---
        System.out.println("Transações registradas:");
        for (Transacao t : transacaoRepository.findAll()) {
            System.out.println("ID: " + t.getIdTransacao() +
                    " | Tipo: " + t.getTipo() +
                    " | Data: " + t.getData() +
                    " | Usuário: " + t.getUsuario().getNome() +
                    " | Jogo: " + t.getJogo().getTitulo() +
                    " | Biblioteca: " + t.getBiblioteca().getBibliotecaId());
        }

        pausar(scanner);

        // --- UPDATE TRANSACAO ---
        Transacao tUpdate = transacaoRepository.findById(1).orElse(null);
        if (tUpdate != null) {
            tUpdate.setTipo("EMPRESTIMO");
            transacaoRepository.save(tUpdate);
            System.out.println("Transação atualizada.");
        }

        pausar(scanner);

        System.out.println("-------Momento dos DELETES---------");

        pausar(scanner);

        // --- DELETE TRANSACAO ---
        Transacao tDelete = transacaoRepository.findById(1).orElse(null);
        if (tDelete != null) {
            transacaoRepository.delete(tDelete);
            System.out.println("Transação deletada.");
        }

        // --- DELETE CONQUISTA ---
        Conquista conquistaDelete = conquistaRepository.findById(1).orElse(null);
        if (conquistaDelete != null) {
            conquistaRepository.delete(conquistaDelete);
            System.out.println("Conquista deletada.");
        }

        // --- DELETE: remover amizade ---
        if (amizadeExistente != null) {
            amigosRepository.delete(amizadeExistente);
            System.out.println("Amizade ID 1 removida.");
        }


        // DELETE REVIEW
        reviewRepo.deleteById(2);
        System.out.println("Review deletada com Sucesso.");

        // DELETE Biblioteca
        bibliotecaRepository.deleteById(deleteBiblioteca.getBibliotecaId());
        System.out.println("Biblioteca Deletada");


        //DELETE Jogo
        jogoRepository.deleteById(2);
        System.out.println("Jogo Deletado");

        //DELETE Usuario
        Usuario deletarUsuario = usuarioRepository.findById(2).orElse(null);
        if (deletarUsuario != null){
        usuarioRepository.delete(deletarUsuario);
        System.out.println("Usuário deletado.");
        }

        scanner.close();
        System.out.println("Fim dos CRUD");
        System.exit(0); // pro sistema parar pq ta em loop
    }
    // Método auxiliar para pausar a execução
    private void pausar(Scanner scanner) {
        System.out.println("\nPressione ENTER para continuar para a próxima parte...");
        scanner.nextLine();
    }
}
