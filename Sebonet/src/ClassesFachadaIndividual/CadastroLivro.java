package ClassesFachadaIndividual;

import Excecoes.InventarioCheioException;
import Excecoes.LivroJaCadastradoException;
import Excecoes.LivroNaoEncontradoException;
import ClassesBasicas.Livro;
import Repositorios.RepositorioLivros;

public class CadastroLivro {
    private RepositorioLivros repLivros;

    public CadastroLivro(RepositorioLivros rep) {
        this.repLivros = rep;

    }

    public void cadastrar(Livro livro) throws LivroJaCadastradoException, InventarioCheioException {
        if (this.repLivros.existe(livro.getCodigo())) {
            repLivros.inserir(livro);
        }
    }

    public void remover(String codigo) throws LivroNaoEncontradoException {
        if (this.repLivros.existe(codigo)) {
            repLivros.remover(codigo);
        } else {
            throw new LivroNaoEncontradoException();
        }
    }

    public boolean existe(String codigo) {
        return repLivros.existe(codigo);
    }

    public void atualizar(Livro livro) throws LivroNaoEncontradoException {
        if (this.existe(livro.getCodigo())) {
            repLivros.atualizar(livro);
        } else {
            throw new LivroNaoEncontradoException();
        }
    }

    public Livro procurar(String codigo) throws LivroNaoEncontradoException {
        if (this.existe(codigo)) {
            return this.repLivros.procurar(codigo);
        } else {
            throw new LivroNaoEncontradoException();
        }
    }
}