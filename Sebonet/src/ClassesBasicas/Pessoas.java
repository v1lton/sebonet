package ClassesBasicas;

import Excecoes.SaldoInsuficienteException;

public abstract class Pessoas {
    private String nome;
    private String CPF;
    private String numero;
    private String email;
    protected double credito;

    public Pessoas(String nome, String CPF, String numero, String email, double credito) {
        this.nome = nome;
        this.CPF = CPF;
        this.numero = numero;
        this.email = email;
        this.credito = credito;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return this.CPF;
    }

    public void setCPF(String CPF) {
        this.nome = CPF;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getCredito() {
        return this.credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public abstract void retirarCredito(double valor) throws SaldoInsuficienteException;

}
