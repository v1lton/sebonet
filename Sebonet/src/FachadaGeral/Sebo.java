package FachadaGeral;

import ClassesFachadaIndividual.*;
import Excecoes.*;
import ClassesBasicas.*;

public class Sebo {
    private CadastroPessoas cadastroPessoas;
    private CadastroLojas CadastroLojas;
    private CadastroLivro cadastroLivros;

    public Sebo (CadastroPessoas cadastroPessoas, CadastroLojas cadastroLojas, CadastroLivro cadastroLivros) {
        this.cadastroPessoas = cadastroPessoas;
        this.CadastroLojas = cadastroLojas;
        this.cadastroLivros = cadastroLivros;
    }

    public void cadastroPessoas(Pessoas pessoa) throws LimitePessoasException, PessoaCadastradaException, LojaNaoEncontradaException {
        if (pessoa instanceof Funcionarios) {
            if (CadastroLojas.existe(((Funcionarios) pessoa).getLoja())) {
                this.cadastroPessoas.cadastrar(pessoa);
            } else {
                throw new LojaNaoEncontradaException();
            }
        } else {
            this.cadastroPessoas.cadastrar(pessoa);
        }
    }

    public void cadastroLojas(Lojas loja) throws LojaJaCadastradaException, LimiteLojaException {
        this.CadastroLojas.cadastrar(loja);
    }

    public void cadastroLivros(Livros livro) throws InventarioCheioException, LivroJaCadastradoException {
        this.cadastroLivros.cadastrar(livro);
    }

    public void atualizarPessoas(Pessoas pessoa) throws PessoaNaoEncontradaException {
        this.cadastroPessoas.atualizar(pessoa);
    }

    public void atualizarLojas(Lojas loja) throws LojaNaoEncontradaException {
        this.CadastroLojas.atualizar(loja);
    }

    public void atualizarLivros(Livros livro) throws LivroNaoEncontradoException {
        this.cadastroLivros.atualizar(livro);
    }


    public void removerPessoas(String CPF) throws PessoaNaoEncontradaException {
        this.cadastroPessoas.remover(CPF);
    }

    public void removerLojas(int id) throws LojaNaoEncontradaException {
        this.CadastroLojas.remover(id);
    }


    public void removerLivros(String codigo) throws LivroNaoEncontradoException {
        this.cadastroLivros.remover(codigo);
     }


    public boolean existePessoas(String CPF) {
        return this.cadastroPessoas.existe(CPF);
    }

    public boolean existeLojas(int id) {
        return this.CadastroLojas.existe(id);
    }

    public boolean existeLivros(String codigo) {
        return this.cadastroLivros.existe(codigo);
    }

    public Pessoas procurarPessoas(String CPF) throws PessoaNaoEncontradaException{
        return this.cadastroPessoas.procurar(CPF);
    }

    public Lojas procurarLojas(int id) throws LojaNaoEncontradaException {
        return this.CadastroLojas.procurar(id);
    }

    public Livros procurarLivros(String codigo) throws LivroNaoEncontradoException {
        return  this.cadastroLivros.procurar(codigo);
    }

}
