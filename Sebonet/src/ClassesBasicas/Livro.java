package ClassesBasicas;

public class Livro {
    private String titulo;
    private double preço;
    private String autor;
    private String codigo;
    private String editora;

    public Livro(String nome, double preço, String autor, String codiqo,String editora) {
        this.titulo = nome;
        this.preço = preço;
        this.autor = autor;
        this.codigo = codigo;
        this.editora = editora;

    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String m) {
        this.autor = m;
    }

    public double getPreço() {
        return this.preço;
    }

    public void setPreço(double n) {
        this.preço = n;
    }

    public String getEditora() {
        return this.editora;
    }

    public void setEditora(String m) {
        this.editora = m;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String m) {
        this.codigo = m;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public void setTitulo(String m){
        this.titulo = m;
    }


}

