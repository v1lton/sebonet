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
           else if (this.posicao < ListaLivros.length) {
               this.ListaLivros[this.posicao] = livro;
               this.posicao = this.posicao + 1;
           } else {
               throw new InventarioCheioException();
           }
       }


    public void remover(String codigo)throws LivroNaoEncontradoException {
        if (existe(codigo)) {
            for (int i = 0; i < ListaLivros.length; i++) {
                if (codigo.equals(this.ListaLivros[i].getCodigo())) {
                    this.ListaLivros[i] = null;
                    this.posicao = this.posicao - 1;
                    i = ListaLivros.length;
                }
            }

            //========  reorganização do array ======================

            for(int i = 0; i < ListaLivros.length-1; i++){
                if(this.ListaLivros[i] == null && this.ListaLivros[i+1] != null){
                    this.ListaLivros[i] = this.ListaLivros[i+1];
                    this.ListaLivros[i+1] = null;
                }
            }
        } else {
            throw new LivroNaoEncontradoException();
        }
    }

    public void atualizar(Livros livro)throws LivroNaoEncontradoException {
        if (existe(livro.getCodigo()) ) {
            for (int i = 0; i < ListaLivros.length; i++) {
                if (this.ListaLivros[i]==livro) {
                    this.ListaLivros[i] = livro;
                }
            }
        } else {
            throw new LivroNaoEncontradoException();
        }
    }

    public boolean existe(String codigo) {
        for (int i = 0; i < ListaLivros.length; i++) {
            if ( ListaLivros[i]!= null && codigo.equals(ListaLivros[i].getCodigo())) {
                return true;
            }
        }
        return false;
    }

    public Livros procurar(String codigo) throws LivroNaoEncontradoException{

        for (int i = 0; i < ListaLivros.length; i++) {
            if (this.ListaLivros[i].getCodigo().equals(codigo)) {
                return ListaLivros[i];

            }
        }if(!existe(codigo)){
            throw new LivroNaoEncontradoException();
        }

        return null;
    }

}