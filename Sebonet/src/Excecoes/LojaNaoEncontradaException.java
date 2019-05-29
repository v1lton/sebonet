package Excecoes;

public class LojaNaoEncontradaException extends Exception {
    public LojaNaoEncontradaException(){
        super("Loja não encontrada.");
    }
}
