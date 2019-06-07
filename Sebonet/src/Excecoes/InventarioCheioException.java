package Excecoes;

public class InventarioCheioException extends Exception{
    public InventarioCheioException() {
        super("Inventário cheio.");
    }
}