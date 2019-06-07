package FachadaGeral;

import ClassesBasicas.Lojas;
import ClassesBasicas.Livro;
import ClassesFachadaIndividual.CrudLojas;
import Excecoes.LimiteLojaException;
import Excecoes.LojaJaCadastradaException;
import Excecoes.LojaNaoEncontradaException;
import Repositorios.RepositorioLojas;
import Repositorios.RepositorioLojasArray;
import Repositorios.RepositorioLojasLista;

public class TestesLojas {

    public static void main() throws LimiteLojaException, LojaNaoEncontradaException, LojaJaCadastradaException {
        //RepositorioLojas rep = new RepositorioLojasArray();
        RepositorioLojas rep = new RepositorioLojasLista();

        CrudLojas cadastro = new CrudLojas(rep);
        Lojas loja = new Lojas(1, "");
        Lojas loja1 = new Lojas(2, "adds");
        Lojas loja2 = new Lojas(3, "331233");
        cadastro.cadastrar(loja);
        cadastro.cadastrar(loja1);
        cadastro.cadastrar(loja2);
        loja.setEndereco("2121");
        cadastro.atualizar(cadastro.procurar(loja.getId()));
        cadastro.remover(loja1.getId());
        Livro livro = new Livro("asd", 21, "1", "1", "1");
        Livro livro1 = new Livro("21", 21, "2", "2", "1");
        cadastro.inserirLivro(livro, loja);
        cadastro.inserirLivro(livro1, loja);
        cadastro.removerLivro(livro1, loja);
    }
}
