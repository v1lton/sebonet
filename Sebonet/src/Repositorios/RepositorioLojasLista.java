package Repositorios;
import ClassesBasicas.Lojas;
import Excecoes.LojaNaoEncontradaException;

public class RepositorioLojasLista implements RepositorioLojas {
    private Lojas loja;
    private RepositorioLojasLista proximo;

    public RepositorioLojasLista(){
        this.loja = null;
        this.proximo = null;
    }

    public void inserir(Lojas loja) {
        if(this.loja == null){
            this.loja = loja;
            this.proximo = new RepositorioLojasLista();
        }else {
            this.proximo.inserir(loja);
        }
    }

    public void remover(int id)  throws LojaNaoEncontradaException {
        if(this.loja == null){
            throw new LojaNaoEncontradaException();
        }else if(this.loja.getId() == id){
            this.loja = this.proximo.loja;
            this.proximo = this.proximo.proximo;
        }else{
            this.proximo.remover(id);
        }
    }

    public void atualizar(Lojas loja)  throws LojaNaoEncontradaException{
        if(this.loja == null){
            throw new LojaNaoEncontradaException();
        }else if(this.loja.getId() == loja.getId()){
            this.loja = loja;
        }else{
            this.proximo.atualizar(loja);
        }
    }

    public boolean existe(int id) {
        if(this.loja == null){
            return false;
        }else if(this.loja.getId() == id){
            return true;
        }else{
            return this.proximo.existe(id);
        }
    }

    public Lojas procurar(int id)  throws LojaNaoEncontradaException{
        if(this.loja == null){
            throw new LojaNaoEncontradaException();
        }else if(this.loja.getId() == id){
            return this.loja;
        }else{
            return this.proximo.procurar(id);
        }
    }

}
