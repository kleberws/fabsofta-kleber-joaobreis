package br.univille.projfabsofteventos.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

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
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public String getData() {
        return data;
    }

    public String getLocal() {
        return local;
    }

    public String getOrganizador() {
        return organizador;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    
    
}