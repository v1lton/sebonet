package Repositorios;

import Excecoes.InventarioCheioException;
import Excecoes.LivroJaCadastradoException;
import Excecoes.LivroNaoEncontradoException;
import ClassesBasicas.Livro;

public interface RepositorioLivros {
    void inserir(Livro livro) throws LivroJaCadastradoException, InventarioCheioException;

    void remover(String codigo) throws LivroNaoEncontradoException;

    void atualizar(Livro livro) throws LivroNaoEncontradoException;

    boolean existe(String codigo);

    Livro procurar(String codigo) throws LivroNaoEncontradoException;
}