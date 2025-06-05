package PucJogos.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bibliotecaId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "jogoId")
    private Jogo jogo;

    private int horasJogadas;
    private Date dataCompra;

    public Biblioteca() {
    }

    public Biblioteca(Usuario usuario, Jogo jogo, int horasJogadas, Date dataCompra) {
        this.usuario = usuario;
        this.jogo = jogo;
        this.horasJogadas = horasJogadas;
        this.dataCompra = dataCompra;
    }

    // Getters e Setters

    public int getBibliotecaId() {
        return bibliotecaId;
    }

    public void setBibliotecaId(int bibliotecaId) {
        this.bibliotecaId = bibliotecaId;
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

    public int getHorasJogadas() {
        return horasJogadas;
    }

    public void setHorasJogadas(int horasJogadas) {
        this.horasJogadas = horasJogadas;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
}
