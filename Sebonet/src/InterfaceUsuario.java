import Excecoes.*;

public class InterfaceUsuario {

    public static void main(String[] args) throws CargoNaoExistenteException, LimitePessoasException, PessoaNaoEncontradaException, SaldoInsuficienteException, LimiteLojaException, LojaNaoEncontradaException {
        System.out.println("Hello World!");
        //FachadaGeral.TestesLojas.main();
        FachadaGeral.TestePessoas.main() ;
    }

}
