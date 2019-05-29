package Excecoes;

public class LimiteLojaException extends Exception {
    public LimiteLojaException(){
        super("Limite de lojas excedido.");
    }
}
