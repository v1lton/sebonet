package ClassesBasicas;

public class Lojas {

    private int id;
    private  String endereco;
    private listaLivros livros;

    public Lojas(int id, String endereco){

        this.id = id;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public listaLivros getLivros() {
        return livros;
    }

    public void setLivros(listaLivros livros) {
        this.livros = livros;
    }

    public void inserirLivro(Livro livro){
        this.livros.inserir(livro);
    }
}

class listaLivros{

    private Livro livro;
    private listaLivros proximo;

    public listaLivros(){
        this.livro = null;
        this.proximo = null;
    }
    public void inserir(Livro livro){
        if(this.livro == null){
            this.livro = livro;
            this.proximo = new listaLivros();
        }else {
            this.proximo.inserir(livro);
        }
    }
}
