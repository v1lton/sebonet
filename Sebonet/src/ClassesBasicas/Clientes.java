package ClassesBasicas;

import Excecoes.SaldoInsuficienteException;


public class Clientes extends Pessoas {
    public Clientes(String nome, String CPF, String numero, String email, double credito) {
        super(nome, CPF, numero, email, credito);
    }

    public void retirarCredito(double valor) throws SaldoInsuficienteException {
        if (this.credito >= valor) {
            this.credito -= valor;
        } else {
            throw new SaldoInsuficienteException();
        }
    }
}
