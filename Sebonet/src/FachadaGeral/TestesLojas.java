package FachadaGeral;

import ClassesBasicas.Lojas;
import ClassesFachadaIndividual.CrudLojas;
import Excecoes.LimiteLojaException;
import Excecoes.LojaNaoEncontradaException;
import Repositorios.RepositorioLojas;
import Repositorios.RepositorioLojasArray;
import Repositorios.RepositorioLojasLista;

public class TestesLojas {

    public static void main() throws LimiteLojaException, LojaNaoEncontradaException {
        RepositorioLojas rep = new RepositorioLojasArray();
        //RepositorioLojas rep = new RepositorioLojasLista();

        CrudLojas cadastro = new CrudLojas(rep);

        Lojas loja = new Lojas(0, 10, "rua das palmeiras");
        rep.inserir(loja);

        Lojas loja2 = new Lojas(1, 10, "rua dass");
        rep.inserir(loja2);


        Lojas loja3 = new Lojas(2, 10, "rua s");
        rep.inserir(loja3);

        loja.setCapacidadeMax(20);
        rep.atualizar(loja);

        rep.remover(loja2.getId());
    }
}
