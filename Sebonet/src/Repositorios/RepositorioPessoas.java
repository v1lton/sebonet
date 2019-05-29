package Repositorios;
import ClassesBasicas.Pessoas;
import Excecoes.*;

public interface RepositorioPessoas {
    public void inserir(Pessoas pessoa) throws LimitePessoasException;
    public void atualizar(Pessoas pessoa) throws PessoaNaoEncontradaException; // Criar a exceção
    public void remover(String nome) throws PessoaNaoEncontradaException; // Criar a exceção
    public Pessoas procurar(String nome) throws PessoaNaoEncontradaException; // Criar a exceção
    public boolean existe(String nome); // Criar a exceção
}
