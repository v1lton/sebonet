package Repositorios;

import ClassesBasicas.Livro;
import Excecoes.LivroJaCadastradoException;
import Excecoes.LivroNaoEncontradoException;
import Excecoes.InventarioCheioException;

public class RepositorioLivroArray implements RepositorioLivros {
    private Livro[] ListaLivros;
    private int posicao;

    public RepositorioLivroArray(int tam) {
        this.ListaLivros = new Livro[tam];
        this.posicao = 0;
    }

    public void inserir(Livro livro)throws InventarioCheioException {
        if (this.posicao < 150) {
            this.ListaLivros[this.posicao] = livro;
            this.posicao = this.posicao + 1;
        } else {
            throw new InventarioCheioException();
        }
    }

    public void remover(String codigo)throws LivroNaoEncontradoException {
        if (existe(codigo) == true) {
            for (int i = 0; i < 150; i++) {
                if (codigo.equals(this.ListaLivros[i].getCodigo())) {
                    this.ListaLivros[i] = null;
                    this.posicao = this.posicao - 1;
                }
            }
        } else {
            throw new LivroNaoEncontradoException();
        }
    }

    public void atualizar(Livro livro)throws LivroNaoEncontradoException {
        if (existe(livro.getCodigo()) == true) {
            for (int i = 0; i < 150; i++) {
                if (this.ListaLivros[i].equals(livro.getCodigo())) {
                    this.ListaLivros[i] = livro;
                }
            }
        } else {
            throw new LivroNaoEncontradoException();
        }
    }

    public boolean existe(String codigo) {
        for (int i = 0; i < 150; i++) {
            if (this.ListaLivros[i].getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public Livro procurar(String codigo) throws LivroNaoEncontradoException{
        boolean check = false;
        for (int i = 0; i < 150; i++) {
            if (this.ListaLivros[i].getCodigo().equals(codigo)) {
                check = true;
                return ListaLivros[i];
            }
        }
        if (check == false) {
            throw new LivroNaoEncontradoException();
        }
        return null;
    }

}