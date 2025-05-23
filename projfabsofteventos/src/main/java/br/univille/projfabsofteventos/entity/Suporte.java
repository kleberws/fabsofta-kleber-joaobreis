package br.univille.projfabsofteventos.entity;

import jakarta.persistence.*;

@Entity
public class Suporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String mensagem;

    //ainda nao utilizado:
    private String dataEnvio;

    // Getters and Setters
    
    
        public long getId() {
            return id;
        }
    
        public void setId(long id) {
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

        public void setMensagem(String mensagem) {
            this.mensagem = mensagem;
        }

        public String getDataEnvio() {
            return dataEnvio;
        }

        public void setDataEnvio(String dataEnvio) {
            this.dataEnvio = dataEnvio;
        }
}