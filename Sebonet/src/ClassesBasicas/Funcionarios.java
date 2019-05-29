package ClassesBasicas;

public class Funcionarios extends Pessoas {
    private String cargo;
    private double salario;
    // private Lojas loja;

    public Funcionarios ( String nome, String CPF, String numero, String email, double credito, String cargo, double salario) {
        super (nome, CPF, numero, email, credito);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) { // Definir quais são os cargos e aumentar os salarios atraves do cargo
        this.cargo = cargo;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean comprar(String nomeLivro) {
        return true;
    }
}
