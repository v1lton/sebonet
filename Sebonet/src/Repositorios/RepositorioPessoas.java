package Repositorios;
import ClassesBasicas.Pessoas;
import Excecoes.*;

public interface RepositorioPessoas {
    void inserir(Pessoas pessoa) throws LimitePessoasException;
    void atualizar(Pessoas pessoa) throws PessoaNaoEncontradaException;
    void remover(String CPF) throws PessoaNaoEncontradaException;
    Pessoas procurar(String CPF) throws PessoaNaoEncontradaException;
    boolean existe(String CPF);
}
