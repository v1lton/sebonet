import ClassesBasicas.*;
import Excecoes.*;
import Repositorios.*;
import FachadaGeral.*;
import ClassesFachadaIndividual.*;

public class InterfaceUsuario {

    public static void main(String[] args)throws LivroNaoEncontradoException,LivroJaCadastradoException,InventarioCheioException{
        RepositorioPessoas repPessoas = new RepositorioPessoasArray(5);
        RepositorioLojas repLojas = new RepositorioLojasArray();
        RepositorioLivros repLivros = new RepositorioLivroArray(2);
        CadastroPessoas CadastroLojasPessoas = new CadastroPessoas(repPessoas);
        CadastroLojas CadastroLojas = new CadastroLojas(repLojas);
        CadastroLivro CadastroLojasLivros = new CadastroLivro(repLivros);
        Sebo sebo = new Sebo(CadastroLojasPessoas, CadastroLojas, CadastroLojasLivros);
        TesteLivro.main();
        try {
            sebo.cadastroPessoas(new Funcionarios("Jose", "11897419465", "81996571720", "js@cin.ufpe.br", 200, "Gerente", 10));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
