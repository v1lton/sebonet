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

    public void atualizar(Pessoas pessoa) throws PessoaNaoEncontradaException {
        if (this.existe(pessoa.getCPF())) {
            boolean status = true;
            int i = 0;
            while(status && i < pessoas.length) {
                if (this.pessoas[i].getCPF().equals(pessoa.getCPF())) {
                    this.pessoas[i] = pessoa;
                    status = false;
                } else {
                    i++;
                }
            }
        } else {
            throw new PessoaNaoEncontradaException();
        }
    }

    public void remover(String CPF) throws PessoaNaoEncontradaException {
        if (this.existe(CPF)) {
            boolean status = true;
            int i = 0;
            while (status && i < pessoas.length) {
                if (this.pessoas[i].getCPF().equals(CPF)) {
                    if (this.pessoas[i+1] == null) {
                        this.pessoas[i] = null;
                    } else {
                        boolean aux = true;
                        while (aux) {
                            if (this.pessoas[i + 1] != null && i < pessoas.length) {
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
        } else {
            throw new PessoaNaoEncontradaException();
        }
    }

    public Pessoas procurar(String CPF) throws PessoaNaoEncontradaException {
        if (this.existe(CPF)) {
            boolean status = true;
            int i = 0;
            Pessoas aux = null;
            while (status && i < pessoas.length) {
                if (this.pessoas[i].getCPF().equals(CPF)) {
                    aux = this.pessoas[i];
                    status = false;
                } else {
                    i++;
                }
            }
            return aux;
        } else {
            throw new PessoaNaoEncontradaException();
        }
    }


    public boolean existe(String CPF) {
        boolean status = true;
        boolean aux = false;
        int i = 0;
        while (status && i < pessoas.length) {
            if (this.pessoas[i] == null) {
                status = false;
            } else if (this.pessoas[i].getCPF().equals(CPF)) {
                aux = true;
                status = false;
            } else {
                i++;
            }
        }
        return aux;
    }
}
