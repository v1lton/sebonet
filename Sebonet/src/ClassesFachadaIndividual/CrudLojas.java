package ClassesFachadaIndividual;

import ClassesBasicas.Livros;
import Excecoes.LimiteLojaException;
import Excecoes.LojaJaCadastradaException;
import Excecoes.LojaNaoEncontradaException;
import Repositorios.RepositorioLojas;
import ClassesBasicas.Lojas;


public class CrudLojas {

    private RepositorioLojas rep;

    public CrudLojas(RepositorioLojas _rep) {
        this.rep = _rep;
    }

    public void cadastrar(Lojas loja) throws LimiteLojaException, LojaJaCadastradaException {
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

    public void inserirLivro(Livros livro, Lojas loja) {
        rep.inserirLivro(livro, loja);
    }

    public void removerLivro(Livros livro, Lojas loja) {
        rep.removerLivro(livro, loja);
    }
}
