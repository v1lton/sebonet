package ClassesBasicas;

public class Lojas {

    private int id;
    private int capacidadeMax;
    private  String endereco;
    private Livro[] livros;

    public Lojas(int id, int capacidadeMax, String endereco){

        this.id = id;
        this.capacidadeMax = capacidadeMax;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public int getCapacidadeMax() {
        return capacidadeMax;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setCapacidadeMax(int capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Livro[] getLivros() {
        return livros;
    }

    public void setLivros(Livro[] livros) {
        this.livros = livros;
    }
}

