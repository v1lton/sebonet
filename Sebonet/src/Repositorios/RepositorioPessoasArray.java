package Repositorios;
import ClassesBasicas.Pessoas;
import Excecoes.PessoaNaoEncontradaException;

public class RepositorioPessoasArray implements RepositorioPessoas{
    private Pessoas[] pessoas;
    private int indice;

    public RepositorioPessoasArray(int valor) {
        this.pessoas = new Pessoas[valor];
        this.indice = 0;
    }
    public void inserir(Pessoas pessoa) {
        if (this.indice != pessoas.length) {
            this.pessoas[this.indice] = pessoa;
            this.indice++;
        } else {
            Pessoas[] aux = new Pessoas[2 * pessoas.length];
            for (int i =0; i < pessoas.length; i++) {
                aux[i] = pessoas[i];
            }
            this.pessoas = aux;
            inserir(pessoa);
        }
    }

    public void atualizar(Pessoas pessoa) {
        int i = 0;
        while(i < pessoas.length) {
            if (this.pessoas[i].getCPF().equals(pessoa.getCPF())) {
                this.pessoas[i] = pessoa;
                i = pessoas.length;
            } else {
                i++;
            }
        }
    }

    public void remover(String CPF) {
        boolean status = true;
        int i = 0;
        while (status && i < pessoas.length) {
            if (this.pessoas[i].getCPF().equals(CPF)) {
                if (this.indice == pessoas.length) {
                    this.pessoas[i] = null;
                } else {
                    boolean aux = true;
                    while (aux) {
                        if (this.pessoas[i + 1] != null) {
                            this.pessoas[i] = this.pessoas[i+1];
                            i++;
                        } else {
                            aux = false;
                        }
                    }
                }
                status = false;
                this.indice--;
            } else {
                i++;
            }
        }
    }

    public Pessoas procurar(String CPF) {
        int i = 0;
        while (i < pessoas.length) {
            if (this.pessoas[i].getCPF().equals(CPF)) {
                return this.pessoas[i];
            } else {
                i++;
            }
        }
        return null;
    }


    public boolean existe(String CPF) {
        int i = 0;
        while (i < pessoas.length) {
            if (this.pessoas[i] == null) {
                return false;
            } else if (this.pessoas[i].getCPF().equals(CPF)) {
                return true;
            } else {
                i++;
            }
        }
        return false;
    }
}
