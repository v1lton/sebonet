package ClassesFachadaIndividual;

import Excecoes.LimiteLojaException;
import Excecoes.LojaNaoEncontradaException;
import Repositorios.RepositorioLojas;
import ClassesBasicas.Lojas;

public class CrudLojas {

    private RepositorioLojas rep;

    public CrudLojas(RepositorioLojas _rep){
        this.rep = _rep;
    }

    public void cadastrar(Lojas loja) throws LojaNaoEncontradaException, LimiteLojaException {
        if(this.existe(loja.getId())){
            rep.inserir(loja);
        }else {
            throw new LojaNaoEncontradaException();
        }
    }

    public void atualizar (Lojas loja) throws LojaNaoEncontradaException {
        if(this.existe(loja.getId())){
            rep.atualizar(loja);
        }else {
            throw new LojaNaoEncontradaException();
        }
    }

    public void remover (int id) throws LojaNaoEncontradaException {
        if(this.existe(id)){
            rep.remover(id);
        }else {
            throw new LojaNaoEncontradaException();
        }
    }

    public boolean existe(int id){
        return rep.existe(id);
    }

    public void procurar (int id) throws LojaNaoEncontradaException {
        rep.procurar(id);
    }
}
