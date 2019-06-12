package ClassesFachadaIndividual;

import Excecoes.LojaJaCadastradaException;
import Excecoes.LojaNaoEncontradaException;
import Repositorios.RepositorioLojas;
import ClassesBasicas.*;


public class CadastroLojas {

    private RepositorioLojas rep;

    public CadastroLojas(RepositorioLojas _rep) {
        this.rep = _rep;
    }

    public void cadastrar(Lojas loja) throws  LojaJaCadastradaException {
        if (!this.existe(loja.getId())) {
            rep.inserir(loja);
        } else {
            throw new LojaJaCadastradaException();
        }
    }

    public void atualizar(Lojas loja) throws LojaNaoEncontradaException {
        if (this.existe(loja.getId())) {
            rep.atualizar(loja);
        } else {
            throw new LojaNaoEncontradaException();
        }
    }

    public void remover(int id) throws LojaNaoEncontradaException {
        if (this.existe(id)) {
            rep.remover(id);
        } else {
            throw new LojaNaoEncontradaException();
        }
    }

    public boolean existe(int id) {
        return rep.existe(id);
    }

    public Lojas procurar(int id) throws LojaNaoEncontradaException {
        return rep.procurar(id);
    }

}


