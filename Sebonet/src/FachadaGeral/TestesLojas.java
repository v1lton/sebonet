package FachadaGeral;

import ClassesBasicas.Lojas;
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
    }
}
