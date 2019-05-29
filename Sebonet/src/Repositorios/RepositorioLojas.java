package Repositorios;
import ClassesBasicas.Lojas;

public interface RepositorioLojas {

    void inserir(Lojas loja);


    void remover(int id);


    void atualizar (Lojas loja);

    boolean existe (int id);

    Lojas procurar (int id);
}
