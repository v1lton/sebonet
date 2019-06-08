import ClassesBasicas.*;
import Excecoes.*;
import Repositorios.*;
import FachadaGeral.*;
import ClassesFachadaIndividual.*;

public class InterfaceUsuario {

    public static void main(String[] args){
        RepositorioPessoas repPessoas = new RepositorioPessoasArray(5);
        RepositorioLojas repLojas = new RepositorioLojasArray();
        RepositorioLivros repLivros = new RepositorioLivroArray(2);
        CadastroPessoas crudPessoas = new CadastroPessoas(repPessoas);
        CrudLojas crudLojas = new CrudLojas(repLojas);
        CadastroLivro crudLivros = new CadastroLivro(repLivros);
        Sebo sebo = new Sebo(crudPessoas, crudLojas, crudLivros);
    }

}
