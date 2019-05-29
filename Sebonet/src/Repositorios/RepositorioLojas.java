package Repositorios;
import ClassesBasicas.Lojas;
import Excecoes.LojaNaoEncontradaException;
import Excecoes.LimiteLojaException;

public interface RepositorioLojas {

    void inserir(Lojas loja) throws LimiteLojaException;


    void remover(int id) throws LojaNaoEncontradaException;


    void atualizar (Lojas loja) throws LojaNaoEncontradaException;

    boolean existe (int id);

    Lojas procurar (int id) throws LojaNaoEncontradaException;
}
