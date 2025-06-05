package PucJogos.model;

import jakarta.persistence.*;

@Entity
public class Conquista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConquista;

    private String nome;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "jogo_id")
    private Jogo jogo;

    public Conquista() {}

    public Conquista(String nome, String descricao, Usuario usuario, Jogo jogo) {
        this.nome = nome;
        this.descricao = descricao;
        this.usuario = usuario;
        this.jogo = jogo;
    }

    // Getters e Setters
    public int getIdConquista() {
        return idConquista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
}
