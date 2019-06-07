package Repositorios;

import Excecoes.LivroJaCadastradoException;
import Excecoes.LivroNaoEncontradoException;
import ClassesBasicas.Livro;

public class RepositorioLivroLista implements RepositorioLivros {
    private Livro livro;
    private RepositorioLivroLista proximo;

    public RepositorioLivroLista() {
        this.livro = null;
        this.proximo = null;
    }

    public void inserir(Livro livro)throws LivroJaCadastradoException {
        if (this.livro == null) {
            this.livro = livro;
            this.proximo = new RepositorioLivroLista();
        }if(this.livro.getCodigo().equals(livro.getCodigo())) {
            throw new LivroJaCadastradoException();
        }
        else {
            this.proximo.inserir(livro);
        }
    }

    @Override
    public void remover(String codigo) throws LivroNaoEncontradoException {
        if (this.livro == null) {
            throw new LivroNaoEncontradoException();
        } else if (this.livro.getCodigo().equals(livro.getCodigo())) {
            this.livro = this.proximo.livro;
            this.proximo = this.proximo.proximo;
        } else {
            this.proximo.remover(codigo);
        }
    }

    @Override
    public void atualizar(Livro livro)throws LivroNaoEncontradoException {
        if (this.livro == null) {
            throw new LivroNaoEncontradoException();
        } else if (this.livro.getCodigo().equals(livro.getCodigo())) {
            this.livro = livro;
        }

    }

    @Override
    public boolean existe(String codigo) {
        if (this.livro == null) {
            return false;
        } else if (this.livro.getCodigo().equals(codigo)) {
            return true;
        }
        return false;
    }

    @Override
    public Livro procurar(String codigo)throws LivroNaoEncontradoException {
        if (this.livro == null) {
            throw new LivroNaoEncontradoException();
        } else if (this.livro.getCodigo().equals(codigo)) {
            return this.livro;
        }
        return this.proximo.procurar(codigo);
    }
}