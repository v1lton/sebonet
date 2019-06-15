package Repositorios;
import ClassesBasicas.Pessoas;
import Excecoes.PessoaNaoEncontradaException;

public class RepositorioPessoasLista implements RepositorioPessoas {
    private Pessoas pessoa;
    private RepositorioPessoasLista proximo;

    public RepositorioPessoasLista() {
        this.pessoa = null;
        this.proximo = null;
    }

    public void inserir(Pessoas pessoa) {
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
        } else if (this.pessoa.getCPF().equals(pessoa.getCPF())) {
            this.pessoa = pessoa;
        } else {
            this.proximo.atualizar(pessoa);
        }
    }

    public void remover(String CPF){
       if (this.pessoa.getCPF().equals(CPF)) {
            this.pessoa = this.proximo.pessoa;
            this.proximo = this.proximo.proximo;
        } else {
            this.proximo.remover(CPF);
        }
    }

    public Pessoas procurar(String CPF) throws PessoaNaoEncontradaException { // Criar a exceção
        if (this.pessoa == null) {
            throw new PessoaNaoEncontradaException();
        } else if (this.pessoa.getCPF().equals(CPF)) {
            return this.pessoa;
        } else {
            return this.proximo.procurar(CPF);
        }
    }

    public boolean existe(String CPF) {
        boolean aux = false;
        if (this.pessoa == null) {
            return false;
        } else if (this.pessoa.getCPF().equals(CPF)) {
            aux = true;
        } else {
            this.proximo.existe(CPF);
        }
        return aux;
    }
}