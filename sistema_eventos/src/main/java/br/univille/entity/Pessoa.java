package br.univille.entity;

public class Pessoa {
    //atributo (variável)
    private String nome;
    private long id;
    private String endereco;

    //FORIGN KEY 
    private Cidade cidade;

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
    public void setId(long id) {
        this.id = id;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public long getId() {
        return id;
    }
    public String getEndereco() {
        return endereco;
    }
    public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}