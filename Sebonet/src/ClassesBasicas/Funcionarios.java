package ClassesBasicas;

import Excecoes.CargoNaoExistenteException;
import Excecoes.SaldoInsuficienteException;

public class Funcionarios extends Pessoas {
    private String cargo;
    private double salario;
    private int loja;

    public Funcionarios (String nome, String CPF, String numero, String email, double credito, String cargo, int loja) throws CargoNaoExistenteException {
        super (nome, CPF, numero, email, credito);
        this.setCargo(cargo);
        this.loja = loja;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) throws CargoNaoExistenteException {
        if (cargo.equals("Vendedor")) {
            this.cargo = cargo;
            this.setSalario(2000.00);
        } else if(cargo.equals("Gerente")) {
            this.cargo = cargo;
            this.setSalario(3000.00);
        } else {
            throw new CargoNaoExistenteException();
        }
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getLoja() {
        return this.loja;
    }

    public void setLoja(int loja) {
        this.loja = loja;
    }

    public void retirarCredito(double valor) throws SaldoInsuficienteException {
        double valorFuncionario = valor * 0.8;
        if (this.credito >= valorFuncionario) {
            this.credito -= valorFuncionario;
        }  else {
            throw new SaldoInsuficienteException();
        }
    }
}
