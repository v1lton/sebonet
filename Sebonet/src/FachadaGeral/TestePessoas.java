package FachadaGeral;

import ClassesBasicas.*;
import ClassesFachadaIndividual.CadastroPessoas;
import Excecoes.*;
import Repositorios.*;


public class TestePessoas {
    public static void main () throws CargoNaoExistenteException, LimitePessoasException, PessoaNaoEncontradaException, SaldoInsuficienteException {
        RepositorioPessoas rep = new RepositorioPessoasArray(2);
        CadastroPessoas cadastro = new CadastroPessoas(rep);
        try {
            Pessoas pessoa = new Clientes("Wilton", "11897419465", "996571720", "wrs",100);
            Pessoas pessoa1 = new Funcionarios("ZE", "1189452563", "9999999", "teste@gmail.com", 100, "Gerente", 1);
            Pessoas pessoa2 = new Funcionarios("ZE", "1189452564", "9999999", "teste@gmail.com", 100, "Vendedor", 1);
            cadastro.cadastrar(pessoa);
            cadastro.cadastrar(pessoa1);
            cadastro.cadastrar(pessoa2);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
        }