package Excecoes;

public class LimitePessoasException extends Exception {
    public LimitePessoasException () {
        super("Limite de Pessoas atingido.");
    }
}
