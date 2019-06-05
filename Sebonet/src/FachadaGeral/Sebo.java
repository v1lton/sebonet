package FachadaGeral;

import ClassesFachadaIndividual.CadastroPessoas;
import ClassesFachadaIndividual.CrudLojas;
import Excecoes.*;
import ClassesBasicas.*;

public class Sebo {
    private CadastroPessoas cadastroPessoas;
    private CrudLojas crudLojas;
    //private CadastroLivros cadastroLivros;

    public Sebo (CadastroPessoas cadastroPessoas, CrudLojas crudLojas) {
        this.cadastroPessoas = cadastroPessoas;
        this.crudLojas = crudLojas;
        // this.cadastroLivros = cadastroLivros;
    }

    public void cadastroPessoas(Pessoas pessoa) throws LimitePessoasException, PessoaCadastradaException {
        this.cadastroPessoas.cadastrar(pessoa);
    }

    public void cadastroLojas(Lojas loja) throws LojaNaoEncontradaException, LimiteLojaException {
        this.crudLojas.cadastrar(loja);
    }

    /*public void cadastroLivros(Livros livro) throws LivroNaoEncontradoException, LimiteLivrosException {
        this.cadastroLivros.cadastrar(livro);
    }*/

    public void atualizarPessoas(Pessoas pessoa) throws PessoaNaoEncontradaException {
        this.cadastroPessoas.atualizar(pessoa);
    }

    public void atualizarLojas(Lojas loja) throws LojaNaoEncontradaException {
        this.crudLojas.atualizar(loja);
    }

    /*public void atualizarLivros(Livros livro) throws LivroNaoEncontradoException {
        this.cadastroLojas.atualizar(loja);
    }
     */

    public void removerPessoas(String CPF) throws PessoaNaoEncontradaException {
        this.cadastroPessoas.remover(CPF);
    }

    public void removerLojas(int id) throws LojaNaoEncontradaException {
        this.crudLojas.remover(id);
    }

    /*
    public void removerLivros() throws LivroNaoEncontradoException {
        this.cadastrolivros.remover();
     }
     */

    public boolean existePessoas(String CPF) {
       return this.cadastroPessoas.existe(CPF);
    }

    public boolean existeLojas(int id) {
        return this.crudLojas.existe(id);
    }

    /*public boolean existeLivros() {
        return this.cadastroLivros.existe();
    }*/

}

/*
* Trocar livro (pega um qualquer e troca pelo oq eu der)
* Vende livro
* Promover funcionário
* Organizar livros -- talvezzzzzzTALVEZMSM
* Trocar Funcionario
* Demitir Funcionario
* Contratar
* Pensar mais coisas pra livro
* */