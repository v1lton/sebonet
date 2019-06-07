package Excecoes;

public class LivroJaCadastradoException extends Exception {
    public LivroJaCadastradoException() {
        super("Livro já cadastrado.");
    }
}