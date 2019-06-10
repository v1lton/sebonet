package ClassesBasicas;

public class Lojas {

    private int id;
    private  String endereco;
    private listaLivros livros;

    public Lojas(int id, String endereco){

        this.id = id;
        this.endereco = endereco;
        this.livros = new listaLivros();
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

    public void inserirLivro(Livros livro){
        this.livros.inserir(livro);
    }

    public void removerLivro(Livros livro){
        this.livros.remover(livro.getCodigo());
    }
}

class listaLivros{

    private Livros livro;
    private listaLivros proximo;

    public listaLivros(){
        this.livro = null;
        this.proximo = null;
    }
    public void inserir(Livros livro){
        if(this.livro == null){
            this.livro = livro;
            this.proximo = new listaLivros();
        }else {
            this.proximo.inserir(livro);
        }
    }


    public void remover(String codigo){
        if(this.livro.getCodigo().equals(codigo)){
            this.livro = this.proximo.livro;
            this.proximo = this.proximo.proximo;
        }else {
            this.proximo.remover(codigo);
        }
    }
}
