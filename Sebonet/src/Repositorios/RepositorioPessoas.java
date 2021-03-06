package Repositorios;
import ClassesBasicas.Pessoas;
import Excecoes.PessoaNaoEncontradaException;

public interface RepositorioPessoas {
    void inserir(Pessoas pessoa);
    void atualizar(Pessoas pessoa);
    void remover(String CPF);
    Pessoas procurar(String CPF);
    boolean existe(String CPF);
}
