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
        CadastroPessoas crudPessoas = new CadastroPessoas(repPessoas);
        CadastroLojas crudLojas = new CadastroLojas(repLojas);
        CadastroLivros crudLivros = new CadastroLivros(repLivros);
        Sebo sebo = new Sebo(crudPessoas, crudLojas, crudLivros);
        TesteLivro.main();
        try {
            sebo.cadastroPessoas(new Funcionarios("Jose", "11897419465", "81996571720", "js@cin.ufpe.br", 200, "Gerente", 01));
        } catch (PessoaJaCadastradaException e) {
            System.out.println(e.getMessage());
        } catch (CargoNaoExistenteException e) {
            System.out.println(e.getMessage());
        } catch (LojaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }
        try {
            sebo.cadastroPessoas(new Funcionarios("Artur", "2212212213", "888885", "edurom@gmail.com", 100, "Vendedor", 01));
            sebo.cadastroPessoas(new Funcionarios("Artur", "2212212213", "888885", "edurom@gmail.com", 100, "Vendedor", 01));
        } catch (PessoaJaCadastradaException e) {
            System.out.println(e.getMessage());
        } catch (CargoNaoExistenteException e) {
            System.out.println(e.getMessage());
        } catch (LojaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }
        try {
            sebo.removerPessoas("2212212214");
        } catch (PessoaNaoEncontradaException e){
            System.out.println(e.getMessage());
        }
        try {
            sebo.removerPessoas("2212212213");
        } catch (PessoaNaoEncontradaException e){
            System.out.println(e.getMessage());
        }
    }

}
