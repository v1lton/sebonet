import ClassesBasicas.*;
import Excecoes.*;
import Repositorios.*;
import FachadaGeral.*;
import ClassesFachadaIndividual.*;

import java.security.spec.ECField;

public class InterfaceUsuario {

    public static void main(String[] args)throws LivroNaoEncontradoException,LivroJaCadastradoException,InventarioCheioException{
        RepositorioPessoas repPessoas = new RepositorioPessoasArray(5);
        RepositorioLojas repLojas = new RepositorioLojasArray();
        RepositorioLivros repLivros = new RepositorioLivroArray(20);
        CadastroPessoas crudPessoas = new CadastroPessoas(repPessoas);
        CadastroLojas crudLojas = new CadastroLojas(repLojas);
        CadastroLivros crudLivros = new CadastroLivros(repLivros);
        Sebo sebo = new Sebo(crudPessoas, crudLojas, crudLivros);
        try {
            Lojas loja01 = new Lojas(01, "Recife");
            sebo.cadastroLojas(loja01);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Pessoas f01 = new Funcionarios("Jose", "11897419465", "81996571720", "js@cin.ufpe.br", 200, "Gerente", 01);
            sebo.cadastroPessoas(f01);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            sebo.cadastroPessoas(new Funcionarios("Artur", "2212212213", "888885", "edurom@gmail.com", 100, "Vendedor", 01));
            sebo.cadastroPessoas(new Funcionarios("Artur", "2212212213", "888885", "edurom@gmail.com", 100, "Vendedor", 01));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            sebo.removerPessoas("2212212214");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            sebo.removerPessoas("2212212213");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            Livros livro01 = new Livros("A Elite do Atraso", 35, "Jessé Souza", "01", "Viver");
            sebo.cadastroLivros(livro01);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Pessoas cli01 = new Clientes("Nalbert", "1189741455", "81996574214", "nms@cin.ufpe.br", 40);
            sebo.cadastroPessoas(cli01);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Livros livro02 = new Livros("A Classe Média no Espelho", 45, "Jessé Souza", "02", "Cortex");
            sebo.cadastroLivros(livro02);
            Pessoas cli02 = new Clientes("Paulo", "009741455", "81996544214", "plm@cin.ufpe.br", 120);
            sebo.cadastroPessoas(cli02);
            Lojas loja02 = new Lojas(02, "Recife");
            sebo.cadastroLojas(loja02);;
            sebo.inserirLivro(livro02, loja02);
            sebo.venderLivros(livro02, cli02, loja02);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            Lojas loja03 = new Lojas(03, "Olinda");
            sebo.cadastroLojas(loja03);
            sebo.cadastroLojas(loja03);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            sebo.removerLojas(03);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            Livros livro03 = new Livros("Manifesto Comunista", 45, "Karl Marx", "03", "viver");
            Livros livro04 = new Livros("Harry Potter e o cálice de fogo", 45, "J. k. Rowling", "04", "viver");
            sebo.cadastroLivros(livro03);
            sebo.cadastroLivros(livro04);
            sebo.inserirLivro(livro03, sebo.procurarLojas(2));
            sebo.inserirLivro(livro04, sebo.procurarLojas(2));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            sebo.removerLivro("03", sebo.procurarLojas(2));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
