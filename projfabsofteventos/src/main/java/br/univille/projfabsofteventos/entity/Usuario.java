package br.univille.projfabsofteventos.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 1000, nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String tipo; // e.g., "promotor" ou "participante"

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date dataDeNascimento;

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
    
        public String getEmail() {
            return email;
        }
}