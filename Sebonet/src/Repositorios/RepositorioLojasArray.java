package Repositorios;

import ClassesBasicas.Livros;
import ClassesBasicas.Lojas;
import Excecoes.LojaNaoEncontradaException;
import Excecoes.LimiteLojaException;

public class RepositorioLojasArray  implements  RepositorioLojas {
    private Lojas[] lojas;
    private int indice;

    public RepositorioLojasArray(){
        this.lojas = new Lojas[50];
        this.indice = 0;
    }

   public void inserir(Lojas loja) throws LimiteLojaException {
        if(this.indice < this.lojas.length){
            lojas[this.indice] = loja;
            this.indice++;
        }else{
            throw new LimiteLojaException();
        }
    }

    public void remover(int id) throws LojaNaoEncontradaException{

        if(this.existe(id)){
            for(int i = 0; i < this.lojas.length; i++){
                if(this.lojas[i].getId() == id){
                    this.lojas[i] = null;
                    i = this.lojas.length;
                    this.indice--;
                }
            }

            //organizando a lista
            for(int i = 0; i < this.lojas.length-1; i++){
                if(this.lojas[i+1] != null && this.lojas[i] == null){
                    this.lojas[i] = this.lojas[i+1];
                    this.lojas[i+1] = null;
                }
            }

        }else{
            throw new LojaNaoEncontradaException();
        }
    }

    public void atualizar (Lojas loja) throws LojaNaoEncontradaException{
        if(this.existe(loja.getId())){
            for(int i = 0; i < this.lojas.length; i++){
                if(loja.getId() == this.lojas[i].getId()){
                    this.lojas[i] = loja;
                    i = this.lojas.length;
                }
            }
        }else{
            throw new LojaNaoEncontradaException();
        }
    }

    public boolean existe (int id){

        for(int i = 0; i < this.lojas.length; i++){
            if(this.lojas[i] != null && this.lojas[i].getId() == id){
                return true;
            }
        }
       return false;
    }

    public Lojas procurar (int id) throws LojaNaoEncontradaException{
        if(this.existe(id)){
            for(int i = 0; i < this.lojas.length; i++){
                if(this.lojas[i].getId() == id){
                    return this.lojas[i];
                }
            }
        }else{
            throw new LojaNaoEncontradaException();
        }
        return null;
    }
    public void inserirLivro(Livros livro, Lojas loja) {
        loja.inserirLivro(livro);
    }

    public void removerLivro(Livros livro, Lojas loja){
        loja.removerLivro(livro);
    }

}
