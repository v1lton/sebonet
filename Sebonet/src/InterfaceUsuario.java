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
            Lojas loja01 = new Lojas(01, "Recife");
            sebo.cadastroLojas(loja01);
        } catch (LojaJaCadastradaException e) {
            System.out.println(e.getMessage());

        } catch (LimiteLojaException e) {
            System.out.println(e.getMessage());
        }
        try {
            Pessoas f01 = new Funcionarios("Jose", "11897419465", "81996571720", "js@cin.ufpe.br", 200, "Gerente", 01);
            sebo.cadastroPessoas(f01);
            if (sebo.existePessoas("11897419465")) {
                System.out.println("Existe");
            } else {
                System.out.println("NãoExiste");
            }
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
        try {
            Livros livro01 = new Livros("A Elite do Atraso", 35, "Jessé Souza", "01", "Viver");
            sebo.cadastroLivros(livro01);
        } catch (LivroJaCadastradoException e) {
            System.out.println(e.getMessage());
        } catch (InventarioCheioException e) {
            System.out.println(e.getMessage());
        }
        try {
            Pessoas cli01 = new Clientes("Nalbert", "1189741455", "81996574214", "nms@cin.ufpe.br", 33);
            sebo.cadastroPessoas(cli01);
        } catch (PessoaJaCadastradaException e) {
            System.out.println(e.getMessage());
        } catch (LojaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }
        try {

           Livros livro01 = new Livros("A Elite do Atraso", 35, "Jessé Souza", "01", "Viver");
            //sebo.cadastroLivros(livro01);
            Pessoas cli01 = new Clientes("Nalbert", "1189741455", "81996574214", "nms@cin.ufpe.br", 33);
            //sebo.cadastroPessoas(cli01);
            Lojas loja01 = new Lojas(01, "Recife");
            //sebo.cadastroLojas(loja01);
            sebo.cadastroLojas.inserirLivro(livro01, loja01);
            sebo.venderLivros(livro01, cli01, loja01);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }




    }

}
