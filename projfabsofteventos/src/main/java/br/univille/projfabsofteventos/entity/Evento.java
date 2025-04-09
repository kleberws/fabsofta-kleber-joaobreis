package br.univille.projfabsofteventos.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private String data;

    @Column(nullable = false)
    private String local;

    @Column(nullable = false)
    private String organizador;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Inscricao> inscricoes;

    // Getters and Setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}