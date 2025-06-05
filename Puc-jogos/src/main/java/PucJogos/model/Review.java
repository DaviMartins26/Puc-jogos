package PucJogos.model;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "jogoId")
    private Jogo jogo;

    private int nota;
    private boolean recomenda;

    public Review() {}

    public Review(Usuario usuario, Jogo jogo, int nota, boolean recomenda) {
        this.usuario = usuario;
        this.jogo = jogo;
        this.nota = nota;
        this.recomenda = recomenda;
    }

    // Getters e Setters
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
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

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public boolean isRecomenda() {
        return recomenda;
    }

    public void setRecomenda(boolean recomenda) {
        this.recomenda = recomenda;
    }
}
