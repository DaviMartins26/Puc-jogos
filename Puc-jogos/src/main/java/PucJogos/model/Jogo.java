package PucJogos.model;

import jakarta.persistence.*;

@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jogoId;

    private String titulo;
    private String desenvolvedora;
    private float preco;

    public Jogo() {
    }

    public Jogo(String titulo, String desenvolvedora, float preco) {
        this.titulo = titulo;
        this.desenvolvedora = desenvolvedora;
        this.preco = preco;
    }

    // Getters e Setters

    public int getJogoId() {
        return jogoId;
    }

    public void setJogoId(int jogoId) {
        this.jogoId = jogoId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
