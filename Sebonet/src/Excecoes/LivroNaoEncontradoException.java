package Excecoes;

public class LivroNaoEncontradoException extends Exception{
    public LivroNaoEncontradoException () {
        super("Livro não Encontrado.");
    }
}
