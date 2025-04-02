@startuml
package br.univille.projfabsofteventos.entity {

    class Evento {
        - Long id
        - String nome
        - String descricao
        - String data
        - String local
        - String organizador
        -- 
        + Long getId()
        + void setId(Long id)
        + String getNome()
        + void setNome(String nome)
        + String getDescricao()
        + void setDescricao(String descricao)
    }

    class Usuario {
        - Long id
        - String nome
        - String email
        - String senha
        - String tipo
        --
        + Long getId()
        + void setId(Long id)
        + String getNome()
        + void setNome(String nome)
        + String getEmail()
        + void setEmail(String email)
    }

    class Inscricao {
        - Long id
        - Evento evento
        - Usuario usuario
        - String dataInscricao
        --
        + Long getId()
        + void setId(Long id)
        + Evento getEvento()
        + void setEvento(Evento evento)
        + Usuario getUsuario()
        + void setUsuario(Usuario usuario)
        + String getDataInscricao()
    }

    class Suporte {
        - Long id
        - Usuario usuario
        - String mensagem
        - String dataEnvio
        --
        + Long getId()
        + void setId(Long id)
        + Usuario getUsuario()
        + void setUsuario(Usuario usuario)
        + String getMensagem()
    }

    Evento "1" --> "*" Inscricao : inscricoes
    Usuario "1" --> "*" Inscricao : inscricoes
    Usuario "1" --> "*" Suporte : suporte
}
@enduml