package Repositorios;
import ClassesBasicas.Pessoas;
import Excecoes.LimitePessoasException;
import Excecoes.PessoaNaoEncontradaException;

public class RepositorioPessoasLista implements RepositorioPessoas {
    private Pessoas pessoa;
    private RepositorioPessoasLista proximo;

    public RepositorioPessoasLista() {
        this.pessoa = null;
        this.proximo = null;
    }

    public void inserir(Pessoas pessoa) throws LimitePessoasException {
        if (this.pessoa == null) {
            this.pessoa = pessoa;
            this.proximo = new RepositorioPessoasLista();
        } else {
            this.proximo.inserir(pessoa);
        }
    }

    public void atualizar(Pessoas pessoa) throws PessoaNaoEncontradaException { // Criar a exceção
        if (this.pessoa == null) {
            throw new PessoaNaoEncontradaException();
        } else if (this.pessoa.getNome().equals(pessoa.getNome())) {
            this.pessoa = pessoa;
        } else {
            this.proximo.atualizar(pessoa);
        }
    }

    public void remover(String nome) throws PessoaNaoEncontradaException { // Criar a exceção
        if (this.pessoa == null) {
            throw new PessoaNaoEncontradaException();
        } else if (this.pessoa.getNome().equals(nome)) {
            this.pessoa = this.proximo.pessoa;
            this.proximo = this.proximo.proximo;
        }

        this.proximo.remover(nome);
    }

    public Pessoas procurar(String nome) throws PessoaNaoEncontradaException { // Criar a exceção
        if (this.pessoa == null) {
            throw new PessoaNaoEncontradaException();
        } else if (this.pessoa.getNome().equals(nome)) {
            return this.pessoa;
        } else {
            return this.proximo.procurar(nome);
        }
    }

    public boolean existe(String nome) {
        boolean aux = false;
        if (this.pessoa == null) {
            return false;
        } else if (this.pessoa.getNome().equals(nome)) {
            aux = true;
        } else {
            this.proximo.existe(nome);
        }
        return aux;
    }
}