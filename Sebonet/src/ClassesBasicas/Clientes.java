package ClassesBasicas;

public class Clientes extends Pessoas {
    public Clientes(String nome, String CPF, String numero, String email, double credito) {
        super(nome, CPF, numero, email, credito);
    }

    public boolean comprar(String nomeLivro) {
        return true;
    }
}
