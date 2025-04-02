package br.univille.projfabsofteventos.entity;

import jakarta.persistence.*;

@Entity
public class Suporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String mensagem;

    private String dataEnvio;

    // Getters and Setters
    
    
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public Usuario getUsuario() {
            return usuario;
        }
    
        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }
    
        public String getMensagem() {
            return mensagem;
        }
}