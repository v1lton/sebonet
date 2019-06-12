package Repositorios;
import ClassesBasicas.Lojas;
import Excecoes.LojaNaoEncontradaException;

public interface RepositorioLojas {

    void inserir(Lojas loja);


    void remover(int id) throws LojaNaoEncontradaException;


    void atualizar (Lojas loja) throws LojaNaoEncontradaException;

    boolean existe (int id);

    Lojas procurar (int id) throws LojaNaoEncontradaException;
}