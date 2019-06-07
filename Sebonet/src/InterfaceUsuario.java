import Excecoes.*;

public class InterfaceUsuario {

    public static void main(String[] args) throws PessoaNaoEncontradaException, PessoaCadastradaException, CargoNaoExistenteException, LimitePessoasException, SaldoInsuficienteException{
        System.out.println("Hello World!!");
        FachadaGeral.TestePessoas.main();
    }

}
