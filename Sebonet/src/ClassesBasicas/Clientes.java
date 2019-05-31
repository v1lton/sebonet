package ClassesBasicas;

import Excecoes.SaldoInsuficienteException;


public class Clientes extends Pessoas {
    public Clientes(String nome, String CPF, String numero, String email, double credito) {
        super(nome, CPF, numero, email, credito);
    }

    public boolean comprar(Livro livro) throws SaldoInsuficienteException {
        double valorDesconto = (livro.getPreço() * 0.9);
        if(this.credito >= valorDesconto) {
            this.credito -= valorDesconto;
            return true;
        } else {
            throw new SaldoInsuficienteException();
        }
    }
}
