package br.univille;
public class Pessoa {
    //atributo (variável)
    private String nome;

    //construtor(ctor)
    //obriga a passar alguma coisa dentro de (), ou é um inicializador.
    public Pessoa(String nome) {
        this.nome=nome;
    }
    public Pessoa() {
        
    }

    //método
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString(){
        return getNome();
    }
}