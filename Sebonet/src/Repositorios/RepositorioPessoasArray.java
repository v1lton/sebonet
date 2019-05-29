package Repositorios;
import ClassesBasicas.Pessoas;

public class RepositorioPessoasArray implements RepositorioPessoas{
    private Pessoas[] pessoas;
    private int indice;

    public RepositorioPessoasArray() {
        this.pessoas = new Pessoas[500];
        this.indice = 0;
    }
    public void inserir(Pessoas pessoa) { // Criar a exceção
        if (this.indice < 500) {
        this.pessoas[this.indice] = pessoa;
        this.indice++; }
        else {
            //erro
        }
    }

    public void atualizar(Pessoas pessoa) { // Criar a exceção
        boolean status = true;
        int i = 0;
        while (status && i < 500) {
            if (this.pessoas[i] == null) {
                //erro
            } else if (this.pessoas[i].getNome().equals(pessoa.getNome())) {
                this.pessoas[i] = pessoa;
                status = false;
            } else {
                i++;
            }
        }
    }

    public void remover(String nome) { // Criar a exceção
        boolean status = true;
        int i = 0;
        while (status && i < 500) {
            if (this.pessoas[i] == null) {
                //erro
            } else if (this.pessoas[i].getNome().equals(nome)) {
                if (this.pessoas[i + 1] == null) {
                    this.pessoas[i] = null;
                } else {
                    boolean aux = true;
                    while (aux) {
                        if (this.pessoas[i + 1] != null && i < 500) {
                            this.pessoas[i] = this.pessoas[i+1];
                            i++;
                        } else {
                            aux = false;
                        }
                    }
                }
                status = false;
            } else {
                i++;
            }
        }
    }

    public Pessoas procurar(String nome) { // Criar a exceção
        boolean status = true;
        int i = 0;
        Pessoas aux = null;
        while (status && i < 500) {
            if (this.pessoas[i] == null) {
                return null;
                //erro
            } else if (this.pessoas[i].getNome().equals(nome)) {
                aux = this.pessoas[i];
                status = false;
            } else {
                i++;
            }
        }
        return aux;
    }
    public boolean existe(String nome) {
        boolean status = true;
        boolean aux = false;
        int i = 0;
        while (status && i < 500) {
            if (this.pessoas[i] == null) {
                aux = false;
                status = false;
            } else if (this.pessoas[i].getNome().equals(nome)) {
                aux = true;
                status = false;
            } else {
                i++;
            }
        }
        return aux;
    }
}
