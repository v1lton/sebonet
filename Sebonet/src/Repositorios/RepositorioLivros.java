package Repositorios;

import ClassesBasicas.Livros;
import Excecoes.InventarioCheioException;
import Excecoes.LivroJaCadastradoException;
import Excecoes.LivroNaoEncontradoException;

public interface RepositorioLivros {
    void inserir(Livros livro) throws LivroJaCadastradoException, InventarioCheioException;

    void remover(String codigo) throws LivroNaoEncontradoException;

    void atualizar(Livros livro) throws LivroNaoEncontradoException;

    boolean existe(String codigo);

    Livros procurar(String codigo) throws LivroNaoEncontradoException;
}