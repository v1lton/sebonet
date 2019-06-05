import Excecoes.LimiteLojaException;
import Excecoes.LojaJaCadastradaException;
import Excecoes.LojaNaoEncontradaException;

public class InterfaceUsuario {

    public static void main(String[] args) throws LimiteLojaException, LojaNaoEncontradaException, LojaJaCadastradaException {
        System.out.println("Hello World!");
        FachadaGeral.TestesLojas.main();
    }

}
