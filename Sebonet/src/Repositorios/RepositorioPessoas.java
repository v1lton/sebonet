package Repositorios;
import ClassesBasicas.Pessoas;
import Excecoes.PessoaNaoEncontradaException;

public interface RepositorioPessoas {
    void inserir(Pessoas pessoa);
    void atualizar(Pessoas pessoa) throws PessoaNaoEncontradaException;
    void remover(String CPF);
    Pessoas procurar(String CPF) throws PessoaNaoEncontradaException;
    boolean existe(String CPF);
}
