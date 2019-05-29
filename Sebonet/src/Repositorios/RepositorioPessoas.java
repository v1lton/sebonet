package Repositorios;
import ClassesBasicas.Pessoas;

public interface RepositorioPessoas {
    public void inserir(Pessoas pessoa);
    public void atualizar(Pessoas pessoa); // Criar a exceção
    public void remover(Pessoas pessoa); // Criar a exceção
    public Pessoas procurar(String nome); // Criar a exceção
    public boolean existe(String nome); // Criar a exceção
}
