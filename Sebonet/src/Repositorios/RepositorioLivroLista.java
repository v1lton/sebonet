package Repositorios;

import ClassesBasicas.Livros;
import Excecoes.LivroJaCadastradoException;
import Excecoes.LivroNaoEncontradoException;

public class RepositorioLivroLista implements RepositorioLivros {
    private Livros livro;
    private RepositorioLivroLista proximo;

    public RepositorioLivroLista() {
        this.livro = null;
        this.proximo = null;
    }

    public void inserir(Livros livro)throws LivroJaCadastradoException {
        if (this.livro == null) {
            this.livro = livro;
            this.proximo = new RepositorioLivroLista();
        }else if(existe(livro.getCodigo())) {
            throw new LivroJaCadastradoException();
        }
        else {
            this.proximo.inserir(livro);
        }
    }

    @Override
    public void remover(String codigo) throws LivroNaoEncontradoException {
        if (!existe(codigo)) {
            throw new LivroNaoEncontradoException();
        } else if (this.livro.getCodigo().equals(codigo)) {
            this.livro = this.proximo.livro;
            this.proximo = this.proximo.proximo;
        } else {
            this.proximo.remover(codigo);
        }
    }

    @Override
    public void atualizar(Livros livro)throws LivroNaoEncontradoException {
        if (!existe(livro.getCodigo())) {
            throw new LivroNaoEncontradoException();
        } else if(this.livro.getCodigo().equals(livro.getCodigo())){
            this.livro = livro;
        }else{
            this.proximo.atualizar(livro);
        }

    }

    @Override
    public boolean existe(String codigo) {
        if (this.livro == null) {
            return false;
        } else if (this.livro.getCodigo().equals(codigo)) {
            return true;
        }else{
            return this.proximo.existe(codigo);
        }
    }

    @Override
    public Livros procurar(String codigo)throws LivroNaoEncontradoException {
        if (this.livro == null) {
            throw new LivroNaoEncontradoException();
        } else if (existe(codigo)) {
            return this.livro;
        }
        return this.proximo.procurar(codigo);
    }
}