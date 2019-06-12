package FachadaGeral;

import ClassesFachadaIndividual.*;
import Excecoes.*;
import ClassesBasicas.*;

public class Sebo {
    private CadastroPessoas cadastroPessoas;
    private CadastroLojas cadastroLojas;
    private CadastroLivros cadastroLivros;

    public Sebo (CadastroPessoas cadastroPessoas, CadastroLojas crudLojas, CadastroLivros cadastroLivros) {
        this.cadastroPessoas = cadastroPessoas;
        this.cadastroLojas = crudLojas;
        this.cadastroLivros = cadastroLivros;
    }

    public void cadastroPessoas(Pessoas pessoa) throws PessoaJaCadastradaException, LojaNaoEncontradaException {
        if (pessoa instanceof Funcionarios) {
            if (cadastroLojas.existe(((Funcionarios) pessoa).getLoja())) {
                this.cadastroPessoas.cadastrar(pessoa);
            } else {
                throw new LojaNaoEncontradaException();
            }
        } else {
            this.cadastroPessoas.cadastrar(pessoa);
        }
    }

    public void cadastroLojas(Lojas loja) throws LojaJaCadastradaException, LimiteLojaException {
        this.cadastroLojas.cadastrar(loja);
    }

    public void cadastroLivros(Livros livro) throws InventarioCheioException, LivroJaCadastradoException {
        this.cadastroLivros.cadastrar(livro);
    }

    public void atualizarPessoas(Pessoas pessoa) throws PessoaNaoEncontradaException {
        this.cadastroPessoas.atualizar(pessoa);
    }

    public void atualizarLojas(Lojas loja) throws LojaNaoEncontradaException {
        this.cadastroLojas.atualizar(loja);
    }

    public void atualizarLivros(Livros livro) throws LivroNaoEncontradoException {
        this.cadastroLivros.atualizar(livro);
    }


    public void removerPessoas(String CPF) throws PessoaNaoEncontradaException {
        this.cadastroPessoas.remover(CPF);
    }

    public void removerLojas(int id) throws LojaNaoEncontradaException {
        this.cadastroLojas.remover(id);
    }


    public void removerLivros(String codigo) throws LivroNaoEncontradoException {
        this.cadastroLivros.remover(codigo);
     }


    public boolean existePessoas(String CPF) {
        return this.cadastroPessoas.existe(CPF);
    }

    public boolean existeLojas(int id) {
        return this.cadastroLojas.existe(id);
    }

    public boolean existeLivros(String codigo) {
        return this.cadastroLivros.existe(codigo);
    }

    public Pessoas procurarPessoas(String CPF) throws PessoaNaoEncontradaException{
        return this.cadastroPessoas.procurar(CPF);
    }

    public Lojas procurarLojas(int id) throws LojaNaoEncontradaException {
        return this.cadastroLojas.procurar(id);
    }

    public Livros procurarLivros(String codigo) throws LivroNaoEncontradoException {
        return  this.cadastroLivros.procurar(codigo);
    }

    public void venderLivros(Livros livro, Pessoas pessoa, Lojas loja) throws PessoaNaoEncontradaException, LivroNaoEncontradoException, LojaNaoEncontradaException, SaldoInsuficienteException {
        if (!this.existePessoas(pessoa.getCPF())) {
            throw new PessoaNaoEncontradaException();
        } else if (!this.existeLivros(livro.getCodigo())) {
            throw new LivroNaoEncontradoException();
        } else if (!this.existeLojas(loja.getId())) {
            throw new LojaNaoEncontradaException();
        } else {
            if (loja.existeLivro()) {
                if (pessoa.getCredito() >= livro.getPreco()) {
                    loja.removerLivro(livro);
                    pessoa.retirarCredito(livro.getPreco());
                    this.atualizarLojas(loja);
                    this.atualizarPessoas(pessoa);
                } else {
                    throw new SaldoInsuficienteException();
                }
            } else {
                throw new LivroNaoEncontradoException();
            }
        }
    }

}
