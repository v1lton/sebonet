package Excecoes;

public class LojaJaCadastradaException  extends  Exception{
    public LojaJaCadastradaException() {
        super("Loja já cadastrada.");
    }
}
