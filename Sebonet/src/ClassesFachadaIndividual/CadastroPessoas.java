package ClassesFachadaIndividual;

import Excecoes.PessoaCadastradaException;
import Excecoes.PessoaNaoEncontradaException;
import Excecoes.LimitePessoasException;
import Repositorios.RepositorioPessoas;
import ClassesBasicas.Pessoas;

public class CadastroPessoas {
    private RepositorioPessoas rep;

    public CadastroPessoas(RepositorioPessoas rep) {
        this.rep = rep;
    }

    public void cadastrar(Pessoas pessoa) throws LimitePessoasException, PessoaCadastradaException{
        if (!this.existe(pessoa.getCPF())) {
            rep.inserir(pessoa);
        } else {
            throw new PessoaCadastradaException();
        }
    }

    public void atualizar(Pessoas pessoa) throws PessoaNaoEncontradaException{
        if (this.existe(pessoa.getCPF())) {
            rep.atualizar(pessoa);
        } else {
            throw new PessoaNaoEncontradaException();
        }
    }

    public void remover(String CPF) throws PessoaNaoEncontradaException{
        if (this.existe(CPF)) {
            rep.remover(CPF);
        } else {
            throw new PessoaNaoEncontradaException();
        }
    }

    public boolean existe(String CPF) {
        return rep.existe(CPF);
    }

    public Pessoas procurar(String CPF) throws PessoaNaoEncontradaException {
        if (this.rep.existe(CPF)) {
            return this.rep.procurar(CPF);
        } else {
            throw new PessoaNaoEncontradaException();
        }
    }


}
// FACHADA
// NEGOCIO
// CLASSE
// REPOSITORIO