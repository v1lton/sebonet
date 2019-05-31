package Excecoes;

public class CargoNaoExistenteException extends Exception {
    public CargoNaoExistenteException() {
        super("Cargo não existente");
    }
}
