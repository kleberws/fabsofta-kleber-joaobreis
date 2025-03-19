package br.univille;

import br.univille.entity.Cidade;
import br.univille.entity.Pessoa;
import br.univille.entity.Pokemon;

public class App {
    public static void main(String[] args) throws Exception {

        Cidade joinville = new Cidade();
        joinville.setNome("Joinville");
        joinville.setEstado("Santa Catarina");

        Pokemon pokemon1 = new Pokemon("Sla123");


        //caso 1- cadastrar evento
        Pessoa mariazinha = new Pessoa("Mariazinha");

        //caso 2 - contato com suporte do site
        Pessoa zezinho = new Pessoa("Zezinho");

        //caso 3 - editar um evento cadastrado
        Pessoa kleber = new Pessoa("Kleber");

        //caso 4 - realizar a inscrição de usuarios para um evento(disparo de email)
        Pessoa joao = new Pessoa("Joao");
 
        //caso 5 - visualizar o nome das pessoas que estão na lista do evento
        Pessoa arthur = new Pessoa("Arthur");

        //caso 6 - login no site
        Pessoa bruno = new Pessoa("Bruno");

        //caso 7 - pré-formulario para o usuario se entrar no evento
        Pessoa giovana = new Pessoa("Giovana");

        //caso 8 - visualizar eventos disponiveis
        Pessoa isadora = new Pessoa("Isadora");
        
        Pokemon pokemon123 = new Pokemon("123");
        zezinho.getListPokemon().add(pokemon123);

    }
}