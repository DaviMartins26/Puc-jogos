package PucJogos.model;

import jakarta.persistence.*;

@Entity
public class Amigos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int amizadeId;

    @ManyToOne
    @JoinColumn(name = "userId1")
    private Usuario user1;

    @ManyToOne
    @JoinColumn(name = "userId2")
    private Usuario user2;

    private boolean status; // true = aceito, false = recusado

    public Amigos() {}

    public Amigos(Usuario user1, Usuario user2, boolean status) {
        this.user1 = user1;
        this.user2 = user2;
        this.status = status;
    }

    // Getters e Setters
    public int getAmizadeId() {
        return amizadeId;
    }

    public Usuario getUser1() {
        return user1;
    }

    public void setUser1(Usuario user1) {
        this.user1 = user1;
    }

    public Usuario getUser2() {
        return user2;
    }

    public void setUser2(Usuario user2) {
        this.user2 = user2;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
