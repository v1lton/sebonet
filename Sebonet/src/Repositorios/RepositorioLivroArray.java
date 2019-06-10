package Repositorios;

import ClassesBasicas.Livros;
import Excecoes.LivroJaCadastradoException;
import Excecoes.LivroNaoEncontradoException;
import Excecoes.InventarioCheioException;

public class RepositorioLivroArray implements RepositorioLivros {
    private Livros[] ListaLivros;
    private int posicao;

    public RepositorioLivroArray(int tam) {
        this.ListaLivros = new Livros[tam];
        this.posicao = 0;
    }

    public void inserir(Livros livro)throws InventarioCheioException, LivroJaCadastradoException {
       if(existe(livro.getCodigo())) {
           throw new LivroJaCadastradoException();
       }
           else if (this.posicao < 150) {
               this.ListaLivros[this.posicao] = livro;
               this.posicao = this.posicao + 1;
           } else {
               throw new InventarioCheioException();
           }
       }


    public void remover(String codigo)throws LivroNaoEncontradoException {
        if (existe(codigo)) {
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

    public void atualizar(Livros livro)throws LivroNaoEncontradoException {
        if (existe(livro.getCodigo()) ) {
            for (int i = 0; i < 150; i++) {
                if (this.ListaLivros[i]==livro) {
                    this.ListaLivros[i] = livro;
                }
            }
        } else {
            throw new LivroNaoEncontradoException();
        }
    }

    public boolean existe(String codigo) {
        for (int i = 0; i < 150; i++) {
            if ( ListaLivros[i]!= null && codigo.equals(ListaLivros[i].getCodigo())) {
                return true;
            }
        }
        return false;
    }

    public Livros procurar(String codigo) throws LivroNaoEncontradoException{
        boolean check = false;
        for (int i = 0; i < 150; i++) {
            if (this.ListaLivros[i].getCodigo().equals(codigo)) {
                check = true;
                return ListaLivros[i];
            }
        }
        if (!check ) {
            throw new LivroNaoEncontradoException();
        }
        return null;
    }

}