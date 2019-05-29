package ClassesBasicas;

public class Funcionarios extends Pessoas {
    private String cargo;
    private double salario;
    private int loja;

    public Funcionarios ( String nome, String CPF, String numero, String email, double credito, String cargo, double salario, int loja) {
        super (nome, CPF, numero, email, credito);
        this.cargo = cargo;
        this.salario = salario;
        this.loja = loja;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public boolean comprar(String livro) {
        return true;
    }
}
