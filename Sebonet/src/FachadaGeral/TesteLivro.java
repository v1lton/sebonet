package FachadaGeral;
import ClassesBasicas.Livros;
import ClassesFachadaIndividual.CadastroLivros;
import Excecoes.InventarioCheioException;
import Excecoes.LivroJaCadastradoException;
import Excecoes.LivroNaoEncontradoException;
import Repositorios.RepositorioLivroArray;
import Repositorios.RepositorioLivros;


public class TesteLivro {
    public static  void main()throws LivroJaCadastradoException, LivroNaoEncontradoException, InventarioCheioException {
        RepositorioLivros rep = new RepositorioLivroArray(150);
        CadastroLivros cadastro = new CadastroLivros(rep);
        try{
             Livros livro = new Livros("A",17.99,"B","C","D");
             Livros lovro = new Livros("E",18.99,"F","G","H");
             Livros luvro = new Livros("I",19.99,"J","K","L");
             cadastro.cadastrar(livro);
             cadastro.cadastrar(lovro);
             cadastro.cadastrar(luvro);
             cadastro.remover("m");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
